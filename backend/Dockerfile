# ---------- build stage ----------
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copy only backend first to leverage Docker cache
COPY backend/pom.xml ./pom.xml
RUN --mount=type=cache,target=/root/.m2 mvn -B -U -DskipTests verify || true

# Now copy the full backend sources and build
COPY backend/ .
RUN --mount=type=cache,target=/root/.m2 mvn -B -U -DskipTests package

# ---------- runtime stage ----------
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*-SNAPSHOT.jar app.jar

# Let docker-compose set SPRING_* envs
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
