import { useEffect, useState } from "react";
import TemperatureCard from "./components/TemperatureCard";
import AddApartmentForm from "./components/AddApartmentForm";
import AddCommonRoomForm from "./components/AddCommonRoomForm";
import ApartmentList from "./components/ApartmentList";
import CommonRoomList from "./components/CommonRoomList";



export default function Home() {
  const [building, setBuilding] = useState(null);
  const [error, setError] = useState("");

  const loadBuilding = () => {
    fetch("http://localhost:8080/api/building/1")
      .then((res) => res.json())
      .then((data) => setBuilding(data))
      .catch(() => setError("Failed to load building data"));
  };

  useEffect(() => {
    loadBuilding();
  }, []);

  if (!building)
    return <h2 style={{ textAlign: "center", marginTop: "40px" }}>Loading…</h2>;

  return (
    <div className="container">

      <h1 style={{ textAlign: "center", marginBottom: "25px", fontSize: "32px" }}>
        Building Control Dashboard
      </h1>

    
      <div className="card">
        <TemperatureCard building={building} loadBuilding={loadBuilding} />
      </div>

      
      <div className="card">
        <AddApartmentForm loadBuilding={loadBuilding} />
      </div>

      
      <div className="card">
        <AddCommonRoomForm loadBuilding={loadBuilding} />
      </div>

      
      <h2 style={{ marginTop: "25px" }}>Apartments</h2>
      <div className="grid">
        <ApartmentList apartments={building.apartments} />
      </div>

      
      <h2 style={{ marginTop: "25px" }}>Common Rooms</h2>
      <div className="grid">
        <CommonRoomList commonRooms={building.commonRooms} />
      </div>

    </div>
  );
}
