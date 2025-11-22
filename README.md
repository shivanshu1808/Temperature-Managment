## Apartment Building — Full-Stack (Backend + Frontend)
- Project overview
   - Backend: Spring Boot (Java), REST APIs, JPA, MySQL, Docker.
   - Frontend: Next.js (React), Fetch API, dark theme dashboard.
   - Purpose: Create and manage a Building with Apartments and Common Rooms, each room tracks temperature and automatically enables heating or cooling based on the building requested temperature.
     
### Features
 - Rooms
    - Each Room has:
         - id (unique)
         - currentTemperature (random 10°C — 40°C at creation)
         - heatingEnabled (boolean)
         - coolingEnabled (boolean)
      - Heating/Cooling logic:
           - If room.currentTemperature < building.requestedTemperature → heatingEnabled = true
           - If room.currentTemperature > building.requestedTemperature → coolingEnabled = true
           - Otherwise both disabled
 - Apartment
    - Inherits Room properties
    - Additional fields: apartmentNumber, ownerName
- CommonRoom
    - Inherits Room properties
    - Additional field: roomType ∈ {Gym, Library, Laundry}
- Building
     - Has a requestedTemperature (default 20.0°C)
     - Contains zero or more Apartments and zero or more CommonRooms
     - Can change requested temperature
     - Can add Apartments / CommonRooms
  - Initial state (main application)
       - On startup the app creates a Building with:
            - Apartments: 101, 102
            - Common rooms: Gym, LibraryrequestedTemperature = 25.0°C
       - The app evaluates each room and sets heating/cooling based on the requested temperature.
         
### Tech stack
- Backend: Java 17, Spring Boot 3.x, Spring Web, Spring Data JPA, Hibernate
- Database: MySQL (prod) / H2 (optional for tests)
- Build: Maven
- Container: Docker
- Frontend: Next.js 16, React, CSS (dark theme)
- Dev tools: IntelliJ, Node, Docker

### Troubleshooting
  - Failed to determine a suitable driver class” → Add MySQL connector dependency and set correct DB URL in application.properties.
  - Next.js module not found → Ensure components/ folder & filenames exactly match imports; restart dev server (npm run dev) to clear Turbopack cache.
  - CORS issues → Ensure backend allows frontend origin (or use proxy in Next dev).
   
