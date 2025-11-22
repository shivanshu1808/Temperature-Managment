import { useState } from "react";

export default function AddCommonRoomForm({ loadBuilding }) {
  const [commonType, setCommonType] = useState("Gym");

  const addCommonRoom = async (e) => {
    e.preventDefault();

    await fetch(`http://localhost:8080/api/building/1/add-common-room`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ roomType: commonType }),
    });

    loadBuilding();
  };

  return (
    <div className="card">
      <h2> Add Common Room</h2>

      <form onSubmit={addCommonRoom} className="form-row">
        <select
          value={commonType}
          onChange={(e) => setCommonType(e.target.value)}
          className="input"
        >
          <option>Gym</option>
          <option>Library</option>
          <option>Laundry</option>
        </select>

        <button className="btn">Add</button>
      </form>
    </div>
  );
}
