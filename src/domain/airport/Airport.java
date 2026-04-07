package domain.airport;

import java.util.Objects;

public class Airport {

    private final String airportId;
    private String name;
    private String code;
    private Location location;

    public Airport(String airportId, String name, String code, Location location) {
        if (airportId == null || airportId.isBlank()) {
            throw new IllegalArgumentException("Airport ID cannot be empty");
        }
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Airport code cannot be empty");
        }

        this.airportId = airportId;
        this.name = name;
        this.code = code;
        this.location = location;
    }

    public String getAirportId() {
        return airportId;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Location getLocation() {
        return location;
    }

    public void updateLocation(Location newLocation) {
        this.location = newLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport)) return false;
        Airport airport = (Airport) o;
        return airportId.equals(airport.airportId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportId);
    }
}