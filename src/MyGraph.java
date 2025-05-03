import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyGraph<T> {
    private Map<Vertex<T>, List<Edge<T>>> adjList;
    private boolean directed;

    public MyGraph() {
        adjList = new HashMap<>();
        directed = false;
    }

    public MyGraph(boolean directed) {
        this();
        this.directed = directed;
    }
    public void addVertex(Vertex<T> vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex<T> source, Vertex<T> destination) {
        addVertex(source);
        addVertex(destination);
        adjList.get(source).add(new Edge<>(source, destination));
        if (!directed) {
            adjList.get(destination).add(new Edge<>(destination, source));
        }
    }

    public void printGraph() {
        for (Vertex<T> vertex : adjList.keySet()) {
            System.out.print(vertex + ": ");
            for (Edge<T> edge : adjList.get(vertex)) {
                System.out.print(edge.getDestination() + " ");
            }
            System.out.println();
        }
    }


}