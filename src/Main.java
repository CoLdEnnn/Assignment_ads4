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
        graph.addVertex(astana);
        graph.addVertex(karaganda);
        graph.addVertex(balkash);
        graph.addVertex(almaty);
        graph.addVertex(pavlodar);
        graph.addVertex(semey);
        graph.addVertex(taldykorgan);
        graph.addVertex(kokshetau);
        graph.addVertex(taraz);

        graph.addEdge(astana, karaganda);
        graph.addEdge(karaganda, balkash);
        graph.addEdge(balkash, almaty);
        graph.addEdge(balkash, taraz);
        graph.addEdge(almaty, taraz);
        graph.addEdge(almaty, taldykorgan);
        graph.addEdge(taldykorgan, semey);
        graph.addEdge(astana,pavlodar);
        graph.addEdge(pavlodar, semey);
        graph.addEdge(astana,kokshetau);

        graph.printGraph();


    }
}