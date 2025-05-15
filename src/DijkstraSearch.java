import java.util.*;

public class DijkstraSearch<T> extends Search<T> {
    private final Map<Vertex<T>, Double> distance;

    public DijkstraSearch(WeightedGraph<T> graph, Vertex<T> source) {
        super(source);
        distance = new HashMap<>();

        for (Vertex<T> v : graph.getVertices()) {
            distance.put(v, Double.POSITIVE_INFINITY);
        }
        distance.put(source, 0.0);

        PriorityQueue<Vertex<T>> pq = new PriorityQueue<>(Comparator.comparingDouble(distance::get));
        pq.add(source);

        while (!pq.isEmpty()) {
            Vertex<T> current = pq.poll();
            marked.add(current);

            for (Map.Entry<Vertex<T>, Double> entry : graph.getAdjacencyList(current).entrySet()) {
                Vertex<T> neighbor = entry.getKey();
                double weight = entry.getValue();

                double newDist = distance.get(current) + weight;
                if (newDist < distance.get(neighbor)) {
                    distance.put(neighbor, newDist);
                    edgeTo.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }
    }
}
