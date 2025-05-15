import java.util.*;

public class BreadthFirstSearch<T> extends Search<T> {
    public BreadthFirstSearch(WeightedGraph<T> graph, Vertex<T> source) {
        super((Vertex<T>) source);
        bfs(graph, source);
    }

    private void bfs(WeightedGraph<T> graph, Vertex<T> start) {
        Queue<Vertex<T>> queue = new LinkedList<>();
        marked.add((Vertex<T>) start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();
            for (Map.Entry<Vertex<T>, Double> neighborEntry : graph.getAdjacencyList(current).entrySet()) {
                Vertex<T> neighbor = neighborEntry.getKey();
                if (!marked.contains(neighbor)) {
                    marked.add((Vertex<T>) neighbor);
                    edgeTo.put((Vertex<T>) neighbor, (Vertex<T>) current);
                    queue.add(neighbor);
                }
            }
        }
    }
}
