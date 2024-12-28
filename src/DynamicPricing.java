public class DynamicPricing {
    public static int getPriceForRoute(Route route, int timeOfDay) {
        return route.getPrice(timeOfDay);
    }
}
