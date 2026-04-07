package domain.route;

import domain.airport.Airport;

import java.util.Objects;

public class Route {

    private final String routeId;
    private Airport origin;
    private Airport destination;
    private Distance distance;

    private double requiredRange;
    private int requiredCapacity;

    private double monthlyAverageFlights;

    public Route(String routeId,
                 Airport origin,
                 Airport destination,
                 Distance distance,
                 double requiredRange,
                 int requiredCapacity) {

        if (routeId == null || routeId.isBlank()) {
            throw new IllegalArgumentException("Route ID cannot be empty");
        }

        if (origin == null || destination == null) {
            throw new IllegalArgumentException("Airports must exist");
        }

        if (origin.equals(destination)) {
            throw new IllegalArgumentException("Origin and destination cannot be the same");
        }

        this.routeId = routeId;
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
        this.requiredRange = requiredRange;
        this.requiredCapacity = requiredCapacity;
    }

    public String getRouteId() {
        return routeId;
    }

    public Airport getOrigin() {
        return origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public Distance getDistance() {
        return distance;
    }

    public double getRequiredRange() {
        return requiredRange;
    }

    public int getRequiredCapacity() {
        return requiredCapacity;
    }

    public double getMonthlyAverageFlights() {
        return monthlyAverageFlights;
    }

    public void updateMonthlyAverageFlights(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Average flights cannot be negative");
        }
        this.monthlyAverageFlights = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Route)) return false;
        Route route = (Route) o;
        return routeId.equals(route.routeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeId);
    }
}