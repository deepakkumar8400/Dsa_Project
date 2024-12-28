import java.util.HashMap;
import java.util.Map;

public class Graph {
    // Stores locations and their corresponding routes
    private Map<String, Map<String, Route>> graph;

    public Graph() {
        graph = new HashMap<>();
    }

    public void addLocation(String location) {
        if (!graph.containsKey(location)) {
            graph.put(location, new HashMap<>());
        }
    }

    public void addRoute(String from, String to, Route route) {
        graph.get(from).put(to, route);
    }

    public Map<String, Route> getRoutes(String location) {
        return graph.get(location);
    }

    public boolean containsLocation(String location) {
        return graph.containsKey(location);
    }
}
