# Weather App (React + Vite + Spring Boot)
A simple full-stack weather search app. The React frontend calls a Spring Boot API that fetches current weather from OpenWeather and caches results for 10 minutes. 

## Running the App
1. Clone the repo
2. Get an API key from [OpenWeather](https://openweathermap.org/api)
3. Add the API key to `backend/src/main/resources/application.properties`
4. Run `cd weather-app`
5. Run `cd backend`
6. Run `mvn clean install`
7. Run `java -jar target/backend-0.0.1-SNAPSHOT.jar`
8. The backend runs on localhost:8080
9. Run `cd ../frontend`
10. Run `npm install`
11. Run `npm run dev`
12. Open [http://localhost:3000](http://localhost:3000) in your browser
13. The frontend runs on localhost:3000
