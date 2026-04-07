import domain.airport.*;
import domain.route.*;

public class Main {
    public static void main(String[] args) {

        Location loc1 = new Location(41.1579, -8.6291);
        Location loc2 = new Location(38.7223, -9.1393);

        Airport porto = new Airport("1", "Porto Airport", "OPO", loc1);
        Airport lisboa = new Airport("2", "Lisbon Airport", "LIS", loc2);

        Distance distance = new Distance(300);

        Route route = new Route("R1", porto, lisboa, distance, 500, 180);

        route.updateMonthlyAverageFlights(120);

        System.out.println("Route created from " +
                route.getOrigin().getName() + " to " +
                route.getDestination().getName());
    }
}
