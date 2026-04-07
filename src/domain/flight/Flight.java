package domain.flight;

import java.util.Objects;

public class Flight {
    private final String flightId;
    private final String routeId;
    private final String aircraftId;
    private FlightSchedule schedule;

    public Flight(String flightId, String routeId, String aircraftId, FlightSchedule schedule) {
        if (flightId == null || routeId == null || aircraftId == null) {
            throw new IllegalArgumentException("IDs cannot be null");
        }
        this.flightId = flightId;
        this.routeId = routeId;
        this.aircraftId = aircraftId;
        this.schedule = schedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return flightId.equals(flight.flightId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId);
    }
}