import java.util.Arrays;

public class graph {
    private int countNodes;
    private int countEdges;
    private int[][] adjMatrix;

    public graph(int countNodes) {
        this.countNodes = countNodes;
        this.adjMatrix = new int[countNodes][countNodes];
    }

    public int getCountNodes() {
        return countNodes;
    }

    public int getCountEdges() {
        return countEdges;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < this.adjMatrix.length; i++) {
            for (int j = 0; j < this.adjMatrix[i].length; j++) {
                str += this.adjMatrix[i][j] + "\t";
            }
            str += "\n";
        }
        return str;
    }

    public void addEdge(int source, int sink, int weight) {
        if (source < 0 || source > this.countNodes - 1 || sink < 0 || sink > this.countNodes - 1 || weight <= 0) {
            System.err.println("Invalid edge: " + source + " " + sink + " " + weight);
            return;
        }
        this.adjMatrix[source][sink] = weight;
        this.countEdges++;
    }

    public int degree(int node) {
        // returns the degree of a node
        if (node < 0 || node > this.countNodes - 1) {
            System.err.println("Invalid node: " + node);
        }
        int degree = 0;
        for (int j = 0; j < this.adjMatrix[node].length; j++) {
            if (this.adjMatrix[node][j] != 0) {
                ++degree;
            }
        }

        return degree;
    }

    public int highestDegree() {
        int aux = 0;// para melhorar o desempenho do codi, nao ficar repetindo o degree
        int highest = 0;
        for (int i = 0; i < this.adjMatrix.length; i++) {
            aux = degree(i);
            if (aux > highest) {
                highest = aux;
            }

        }
        return highest;
    }

    public int lowDegree() {
        int aux = 0;// para melhorar o desempenho do codi, nao ficar repetindo o degree
        int low = this.adjMatrix.length;// tem que ser comparado com o maior tamanho, para ser comparado com o menor.
        for (int i = 0; i < this.adjMatrix.length; i++) {
            aux = degree(i);
            if (aux < low) {
                low = aux;
            }

        }
        return low;
    }

    public graph complement() {
        // returnes the complement of the corruent grafo
        graph complement = new graph(this.adjMatrix.length);
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix.length; j++) {
                if (adjMatrix[i][j] == 0) {
                    complement.adjMatrix[i][j] = 1;
                }
                if (adjMatrix[i][j] != 0) {
                    complement.adjMatrix[i][j] = 0;
                }
                if (i == j) {
                    complement.adjMatrix[i][j] = 0;
                }
            }
        }
        return complement;

    }

}
