import java.util.*;

public class Dijkstra {
    public static Map<String, Integer> calculateShortestPath(Graph graph, String source, int timeOfDay) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (String location : graph.getRoutes(source).keySet()) {
            distances.put(location, Integer.MAX_VALUE);
            previous.put(location, null);
        }

        distances.put(source, 0);
        queue.add(new AbstractMap.SimpleEntry<>(source, 0));

        while (!queue.isEmpty()) {
            String currentLocation = queue.poll().getKey();
            for (Map.Entry<String, Route> entry : graph.getRoutes(currentLocation).entrySet()) {
                String neighbor = entry.getKey();
                Route route = entry.getValue();
                int newDist = distances.get(currentLocation) + DynamicPricing.getPriceForRoute(route, timeOfDay);

                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    previous.put(neighbor, currentLocation);
                    queue.add(new AbstractMap.SimpleEntry<>(neighbor, newDist));
                }
            }
        }

        return distances;
    }
}

