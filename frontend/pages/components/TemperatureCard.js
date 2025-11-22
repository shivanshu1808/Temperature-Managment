import { useState } from "react";

export default function TemperatureCard({ building, loadBuilding }) {
  const [newTemp, setNewTemp] = useState("");

  const updateTemp = async (e) => {
    e.preventDefault();
    if (!newTemp) return;

    await fetch(
      `http://localhost:8080/api/building/1/temperature?newTemperature=${newTemp}`,
      { method: "PUT" }
    );

    setNewTemp("");
    loadBuilding();
  };

  return (
    <div className="card">
      <h2>Requested Temperature</h2>
      <p style={{ fontSize: "22px" }}>{building.requestedTemperature}°C</p>

      <form onSubmit={updateTemp} className="form-row">
        <input
          type="number"
          placeholder="Enter new temp"
          value={newTemp}
          onChange={(e) => setNewTemp(e.target.value)}
          className="input"
        />
        <button className="btn">Update</button>
      </form>

      <p>Apartments: {building.apartments.length}</p>
      <p>Common Rooms: {building.commonRooms.length}</p>
    </div>
  );
}
