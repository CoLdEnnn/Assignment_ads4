import java.util.*;

public class UnweightedGraph<T> {
    private final Map<Vertex<T>, List<Vertex<T>>> adjList;
    private final boolean directed;

    public UnweightedGraph() {
        this(false);
    }

    public UnweightedGraph(boolean directed) {
        this.adjList = new HashMap<>();
        this.directed = directed;
    }

    public void addVertex(Vertex<T> vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex<T> source, Vertex<T> destination) {
        addVertex(source);
        addVertex(destination);
        adjList.get(source).add(destination);
        if (!directed) {
            adjList.get(destination).add(source);
        }
    }

    public Set<Vertex<T>> getVertices() {
        return adjList.keySet();
    }

    public Map<Vertex<T>, Double> getAdjacencyList(Vertex<T> vertex) {
        Map<Vertex<T>, Double> neighbors = new HashMap<>();
        if (adjList.containsKey(vertex)) {
            for (Vertex<T> neighbor : adjList.get(vertex)) {
                neighbors.put(neighbor, 1.0); // All edges have weight 1.0
            }
        }
        return neighbors;
    }

    public void printGraph() {
        for (Map.Entry<Vertex<T>, List<Vertex<T>>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for (Vertex<T> neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}
