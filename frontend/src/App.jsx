import { useState } from "react";
import "./App.css";

function App() {
  const [city, setCity] = useState("");
  const [data, setData] = useState(null);
  const [error, setError] = useState("");

  const searchWeather = async () => {
    try {
      const res = await fetch(
        `http://localhost:8080/api/weather?city=${city}`
      );

      if (!res.ok) throw new Error();

      const json = await res.json();
      setData(json);
      setError("");
    } catch {
      setError("City not found");
      setData(null);
    }
  };

  return (
    <div className="app">
      <h1>🌦 Weather Search</h1>

      <div className="search">
        <input
          placeholder="Enter city"
          value={city}
          onChange={(e) => setCity(e.target.value)}
        />
        <button onClick={searchWeather}>Search</button>
      </div>

      {error && <p className="error">{error}</p>}

      {data && (
        <div className="card">
          <h2>{data.name}</h2>
          <p>🌡 Temp: {data.main.temp} °C</p>
          <p>🤗 Feels Like: {data.main.feels_like} °C</p>
          <p>💧 Humidity: {data.main.humidity}%</p>
          <p>🌬 Wind: {data.wind.speed} m/s</p>
          <small>Source: {data.source}</small>
        </div>
      )}
    </div>
  );
}

export default App;
