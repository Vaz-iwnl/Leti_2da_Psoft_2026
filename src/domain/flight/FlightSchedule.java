package domain.flight;

import java.time.LocalDateTime;

public class FlightSchedule {
    private final LocalDateTime departureTime;
    private final LocalDateTime arrivalTime;

    public FlightSchedule(LocalDateTime departureTime, LocalDateTime arrivalTime) {
        if (arrivalTime.isBefore(departureTime)) {
            throw new IllegalArgumentException("Arrival cannot be before departure");
        }
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public LocalDateTime getDepartureTime() { return departureTime; }
    public LocalDateTime getArrivalTime() {return arrivalTime; }
}