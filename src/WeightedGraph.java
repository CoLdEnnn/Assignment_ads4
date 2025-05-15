import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WeightedGraph<T> {
    private Set<Vertex<T>> vertices = new HashSet<>();

    public Map<Vertex<T>, Double> getAdjacencyList(Vertex<T> vertex) {
        return vertex.getAdjacentVertices();
    }

    public void addVertex(Vertex<T> vertex) {
        vertices.add(vertex);
    }

    public void addEdge(Vertex<T> source, Vertex<T> destination, double weight) {
        vertices.add(source);
        vertices.add(destination);
        source.addAdjacentVertex(destination, weight);
    }

    public Set<Vertex<T>> getVertices() {
        return vertices;
    }
}
