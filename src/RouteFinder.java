import java.util.*;

public class RouteFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph();

        // Add locations to the graph
        graph.addLocation("A");
        graph.addLocation("B");
        graph.addLocation("C");
        graph.addLocation("D");

        // Add routes with dynamic pricing based on time
        graph.addRoute("A", "B", new Route("B", 10, 2));
        graph.addRoute("A", "C", new Route("C", 15, 3));
        graph.addRoute("B", "C", new Route("C", 5, 1));
        graph.addRoute("C", "D", new Route("D", 10, 2));
        graph.addRoute("B", "D", new Route("D", 20, 5));

        // User input
        System.out.println("Enter source location: ");
        String source = scanner.nextLine();
        System.out.println("Enter destination location: ");
        String destination = scanner.nextLine();
        System.out.println("Enter time of travel (0-24): ");
        int timeOfDay = scanner.nextInt();

        if (!graph.containsLocation(source) || !graph.containsLocation(destination)) {
            System.out.println("Invalid source or destination.");
            return;
        }

        // Find the shortest path
        Map<String, Integer> shortestPaths = Dijkstra.calculateShortestPath(graph, source, timeOfDay);
        System.out.println("Cheapest route from " + source + " to " + destination + ": " + shortestPaths.get(destination));
    }
}
