public class Route {
    private String destination;
    private int basePrice;  // Base price for the route
    private int timeFactor; // A factor that influences the price based on the time of day

    public Route(String destination, int basePrice, int timeFactor) {
        this.destination = destination;
        this.basePrice = basePrice;
        this.timeFactor = timeFactor;
    }

    public String getDestination() {
        return destination;
    }

    public int getPrice(int timeOfDay) {
        return basePrice + (timeFactor * timeOfDay); // Dynamic pricing logic based on time
    }
}
