# syntax=docker/dockerfile:1

# --- Stage 1: build Angular app ---
FROM node:18-alpine AS build
WORKDIR /app

COPY package*.json ./
RUN --mount=type=cache,target=/root/.npm npm ci --no-audit --no-fund

COPY . .
# Force correct asset paths in case base/deploy were mis-set
RUN npm run build -- --configuration production --base-href=/ --deploy-url=/

# --- Stage 2: serve with nginx + API proxy ---
FROM nginx:1.25-alpine

# SPA routing + robust proxy to backend service (works for /api and common roots)
RUN printf 'server {\n\
  listen 80;\n\
  server_name _;\n\
  root /usr/share/nginx/html;\n\
  include /etc/nginx/mime.types;\n\
  index index.html;\n\
  # Serve static assets as-is
  location ~* \\.(js|css|png|jpg|jpeg|gif|svg|ico|woff2?)$ { try_files $uri =404; }\n\
  # SPA fallback\n\
  location / { try_files $uri $uri/ /index.html; }\n\
  # Proxy typical API roots to Spring (adjust list if needed)\n\
  location ~ ^/(api|patients|doctors|appointments|auth|users)/ {\n\
    proxy_pass http://backend:8080;\n\
    proxy_set_header Host $host;\n\
    proxy_set_header X-Real-IP $remote_addr;\n\
    proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;\n\
    proxy_set_header X-Forwarded-Proto $scheme;\n\
  }\n\
}\n' > /etc/nginx/conf.d/default.conf

# Angular 18 output is dist/<app-name>/browser
ARG DIST_DIR=frontend-angular-hospital
COPY --from=build /app/dist/${DIST_DIR}/browser/ /usr/share/nginx/html/

EXPOSE 80
