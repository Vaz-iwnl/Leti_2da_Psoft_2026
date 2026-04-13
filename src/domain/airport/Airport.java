package domain.airport;

import java.util.List;
import java.util.Objects;

public class Airport {

    private final AirportCode code; // Aggregate ID
    private String name;
    private Location location;
    private Timezone timezone;
    private AirportStatus status;
    private List<Runway> runways;
    private List<AirplaneCertification> certifications;

    public Airport(AirportCode code,
                   String name,
                   Location location,
                   Timezone timezone,
                   AirportStatus status,
                   List<Runway> runways,
                   List<AirplaneCertification> certifications) {

        if (code == null) {
            throw new IllegalArgumentException("Airport code cannot be null");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Airport name cannot be empty");
        }
        if (location == null) {
            throw new IllegalArgumentException("Location cannot be null");
        }

        this.code = code;
        this.name = name;
        this.location = location;
        this.timezone = timezone;
        this.status = status;
        this.runways = runways;
        this.certifications = certifications;
    }

    public AirportCode getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public Timezone getTimezone() {
        return timezone;
    }

    public AirportStatus getStatus() {
        return status;
    }

    public List<Runway> getRunways() {
        return runways;
    }

    public List<AirplaneCertification> getCertifications() {
        return certifications;
    }

    public void updateLocation(Location newLocation) {
        if (newLocation == null) {
            throw new IllegalArgumentException("Location cannot be null");
        }
        this.location = newLocation;
    }

    public void updateStatus(AirportStatus newStatus) {
        this.status = newStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport)) return false;
        Airport airport = (Airport) o;
        return code.equals(airport.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}