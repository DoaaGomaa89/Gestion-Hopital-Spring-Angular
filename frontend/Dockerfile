# -------- build stage --------
FROM node:18-alpine AS build
WORKDIR /app

# Install deps using the lockfile
COPY package*.json ./
RUN --mount=type=cache,target=/root/.npm npm ci --no-audit --no-fund

# Copy sources and build for production
COPY . .
# Name of the folder Angular writes into under /app/dist (see angular.json -> outputPath)
# The default here matches your build log: /app/dist/frontend-angular-hospital
ARG DIST_DIR=frontend-angular-hospital
RUN npm run build -- --configuration=production

# -------- runtime (nginx) --------
FROM nginx:1.25-alpine

# Minimal SPA config (no external file needed)
RUN cat > /etc/nginx/conf.d/default.conf <<'NGINX'
server {
  listen 80;
  server_name _;
  root /usr/share/nginx/html;
  index index.html;

  # SPA fallback so deep links work
  location / {
    try_files $uri $uri/ /index.html;
  }

  # Static assets caching (optional)
  location ~* \.(?:js|css|png|jpg|jpeg|gif|svg|ico|woff2?)$ {
    expires 7d;
    access_log off;
  }
}
NGINX

# Copy the compiled app
ARG DIST_DIR=frontend-angular-hospital
COPY --from=build /app/dist/${DIST_DIR}/ /usr/share/nginx/html/

EXPOSE 80
