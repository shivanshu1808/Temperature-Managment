export default function CommonRoomList({ commonRooms }) {
  return (
    <div>
      <h2></h2>

      <div className="grid">
        {commonRooms.map((room) => (
          <div className="room-card" key={room.id}>
            <h3>{room.roomType}</h3>
            <p>Temp: {room.currentTemperature.toFixed(1)}°C</p>
            <p>
              Status: {room.heatingEnabled ? "Heating" : room.coolingEnabled ? "Cooling" : "Idle"}
            </p>
          </div>
        ))}
      </div>
    </div>
  );
}
