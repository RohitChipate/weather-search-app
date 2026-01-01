# Weather App (React + Vite + Spring Boot)

A simple full‑stack weather search app. The React frontend calls a Spring Boot API that fetches current weather from OpenWeather and caches results for 10 minutes.

## Tech Stack
- Frontend: React 19 + Vite
- Backend: Spring Boot 3 (Java 17, Maven wrapper)
- External API: OpenWeather (metric units)

## Prerequisites
- Node.js 18+ and npm
- Java 17+
- Maven is not required (project uses the Maven wrapper: `mvnw`/`mvnw.cmd`)

## Quick Start

### 1) Start the Backend (port 8080)
From the repository root:

cd backend
mvnw.cmd spring-boot:run
```
```

- API base URL: `http://localhost:8080`
- Endpoint: `GET /api/weather?city=<CITY_NAME>`

Test the API:
```bash
curl "http://localhost:8080/api/weather?city=Pune"
```

Configuration:
- OpenWeather key and base URL are configured in `backend/src/main/resources/application.properties`:
  - `weather.api.key` (replace with your own API key)
  - `weather.api.url`

### 2) Start the Frontend (Vite, port 5173)

cd frontend
npm install
npm run dev
```
Visit: `http://localhost:5173`

The frontend makes requests to `http://localhost:8080/api/weather`.



## Project Structure
```
weather_app/
├─ backend/               # Spring Boot API
│  ├─ src/main/java/...   # Controllers, services, cache, models
│  ├─ src/main/resources/ # application.properties
│  └─ pom.xml             # Maven (wrapper included)
└─ frontend/              # React + Vite UI
   ├─ src/                # App.jsx, styles
   ├─ package.json        # scripts (dev/build/preview)
   └─ vite.config.js
```



