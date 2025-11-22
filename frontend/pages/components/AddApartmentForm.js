import { useState } from "react";

export default function AddApartmentForm({ loadBuilding }) {
  const [aptNumber, setAptNumber] = useState("");
  const [ownerName, setOwnerName] = useState("");

  const addApartment = async (e) => {
    e.preventDefault();

    await fetch(`http://localhost:8080/api/building/1/add-apartment`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        apartmentNumber: aptNumber,
        ownerName: ownerName,
      }),
    });

    setAptNumber("");
    setOwnerName("");
    loadBuilding();
  };

  return (
    <div className="card">
      <h2>Add Apartment</h2>

      <form onSubmit={addApartment} className="form-row">
        <input
          placeholder="Apartment No"
          value={aptNumber}
          onChange={(e) => setAptNumber(e.target.value)}
          className="input"
        />
        <input
          placeholder="Owner Name"
          value={ownerName}
          onChange={(e) => setOwnerName(e.target.value)}
          className="input"
        />
        <button className="btn">Add</button>
      </form>
    </div>
  );
}
