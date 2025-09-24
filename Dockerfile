# ---------- BACKEND BUILD ----------
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# warm the maven cache
COPY backend/pom.xml ./pom.xml
RUN --mount=type=cache,target=/root/.m2 mvn -B -U -DskipTests verify || true

# build sources
COPY backend/ .
RUN --mount=type=cache,target=/root/.m2 mvn -B -U -DskipTests package

# ---------- BACKEND RUNTIME ----------
FROM eclipse-temurin:17-jre-alpine AS backend
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]

# ---------- FRONTEND BUILD ----------
FROM node:18-alpine AS fe-build
WORKDIR /app
COPY frontend/package*.json ./
RUN --mount=type=cache,target=/root/.npm npm ci --no-audit --no-fund
COPY frontend/ .
# Angular prod build
RUN npm run build -- --configuration=production

# ---------- FRONTEND RUNTIME ----------
FROM nginx:1.25-alpine AS frontend
ARG NG_APP_NAME=frontend-angular-hospital
COPY frontend.nginx.conf /etc/nginx/conf.d/default.conf
# copy *contents* of the Angular dist subfolder -> web root
COPY --from=fe-build /app/dist/${NG_APP_NAME}/ /usr/share/nginx/html/
