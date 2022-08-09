public class main {
    public static void main(String[] args) {

        graph g1 = new graph(4);
        g1.addEdge(0, 1, 3);
        g1.addEdge(1, 0, 3);
        g1.addEdge(0, 3, 4);
        g1.addEdge(3, 0, 4);
        g1.addEdge(3, 2, 4);
        g1.addEdge(3, 4, 2); // AVISO

        System.out.println(g1);
        g1.degree(0);
        g1.degree(1);
        g1.degree(2);
        g1.degree(3);
    }
}
