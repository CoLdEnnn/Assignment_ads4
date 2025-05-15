public class Main {
    public static void main(String[] args) {
        MyGraph<String> graph = new MyGraph<>();

        Vertex<String> astana = new Vertex<>("Astana");
        Vertex<String> karaganda = new Vertex<>("Karaganda");
        Vertex<String> balkash = new Vertex<>("Balkash");
        Vertex<String> almaty = new Vertex<>("Almaty");
        Vertex<String> pavlodar = new Vertex<>("Pavlodar");
        Vertex<String> semey = new Vertex<>("Semey");
        Vertex<String> taldykorgan = new Vertex<>("Taldykorgan");
        Vertex<String> kokshetau = new Vertex<>("Kokshetau");
        Vertex<String> taraz = new Vertex<>("Taraz");

        graph.addEdge(astana, karaganda);
        graph.addEdge(karaganda, balkash);
        graph.addEdge(balkash, almaty);
        graph.addEdge(balkash, taraz);
        graph.addEdge(almaty, taraz);
        graph.addEdge(almaty, taldykorgan);
        graph.addEdge(taldykorgan, semey);
        graph.addEdge(astana, pavlodar);
        graph.addEdge(pavlodar, semey);
        graph.addEdge(astana, kokshetau);
        graph.setWeight(astana, kokshetau, 100);

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, astana);
        System.out.println("BFS Path to Karaganda: " + bfs.pathTo(karaganda));

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, astana);
        System.out.println("Dijkstra Path to Karaganda: " + dijkstra.pathTo(karaganda));

        graph.printGraph();
    }
}
