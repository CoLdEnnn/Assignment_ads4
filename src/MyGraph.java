import java.util.*;

public class MyGraph<T> extends WeightedGraph<T> {
    private Map<Vertex<T>, List<Edge<T>>> adjList = new HashMap<>();
    private boolean directed = false;

    public MyGraph() {}

    public MyGraph(boolean directed) {
        this.directed = directed;
    }

    public void addVertex(Vertex<T> vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex<T> source, Vertex<T> destination) {
        addEdge(source, destination, 1.0);
    }

    public void addEdge(Vertex<T> source, Vertex<T> destination, double weight) {
        addVertex(source);
        addVertex(destination);
        adjList.get(source).add(new Edge<>(source, destination, weight));
        source.addAdjacentVertex(destination, weight);

        if (!directed) {
            adjList.get(destination).add(new Edge<>(destination, source, weight));
            destination.addAdjacentVertex(source, weight);
        }
    }

    public void setWeight(Vertex<T> source, Vertex<T> destination, double weight) {
        // Replace existing edge with new weight
        addEdge(source, destination, weight);
    }

    public Map<Vertex<T>, Double> getAdjacencyList(Vertex<T> vertex) {
        return vertex.getAdjacentVertices();
    }

    public Set<Vertex<T>> getVertices() {
        return adjList.keySet();
    }

    public void printGraph() {
        for (Vertex<T> vertex : adjList.keySet()) {
            System.out.print(vertex + ": ");
            for (Edge<T> edge : adjList.get(vertex)) {
                System.out.print(edge.getDestination() + "(" + edge.getWeight() + ") ");
            }
            System.out.println();
        }
    }
}
