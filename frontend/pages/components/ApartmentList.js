export default function ApartmentList({ apartments }) {
  return (
    <>
      {apartments.map((apt) => (
        <div className="room-card" key={apt.id}>
          <h3>Apartment #{apt.apartmentNumber}</h3>
          <p><b>Owner:</b> {apt.ownerName}</p>
          <p><b>Temp:</b> {apt.currentTemperature.toFixed(1)}°C</p>
          <p><b>Status:</b> {apt.heatingEnabled ? "Heating" : apt.coolingEnabled ? "Cooling" : "Idle"}</p>
        </div>
      ))}
    </>
  );
}
