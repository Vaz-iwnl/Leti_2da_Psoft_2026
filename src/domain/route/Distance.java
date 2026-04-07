package domain.route;

public class Distance {

    private final double value;

    public Distance(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Distance must be positive");
        }
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
