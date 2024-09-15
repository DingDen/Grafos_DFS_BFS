public class GrafoMatrizADJ {
    private int vertices;
    private int arestas;
    private int[][] matrizAdj;
    private int[][] verticesADJ;
    private boolean isDirecionado;

    public int getVertices() {
        return vertices;
    }

    public int getArestas() {
        return arestas;
    }

    public int[][] getMatrizAdj() {
        return matrizAdj;
    }

    public int[][] getVerticesADJ() {
        return verticesADJ;
    }

    public GrafoMatrizADJ(int vertices, int arestas, boolean isDirecionado) {
        this.vertices = vertices;
        this.arestas = arestas;
        this.isDirecionado = isDirecionado;
        this.matrizAdj = new int[vertices][vertices];
        this.verticesADJ = new int[vertices][vertices]; // Novo metodo para salvar os vertices ADJ a um vertice
    }

    public void addMatriz(int v1, int v2) {
        if (v1-1 < vertices && v2-1 < vertices && v1 > 0 && v2 > 0) matrizAdj[v1-1][v2-1] = 1;
            if (!isDirecionado) matrizAdj[v2-1][v1-1] = 1; // Grafo não direcionado, relação simétrica.       
    }

    // Metodo criado para verificar os adjacentes de um vertice na MatrizADJ
    public void MontarMatrizVerticesADJ() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (matrizAdj[i][j] == 1) verticesADJ[i][j] = j + 1; // Adiciona o vertice adjacente no array
            }
        }
    }

    public void exibirMatrizAdj() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(matrizAdj[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void ExibirMatrizVerticesADJ() {
        for (int i = 0; i < vertices; i++) {
            System.out.print((i+1) + ": ");
            for (int j = 0; j < vertices; j++) {
                if (matrizAdj[i][j] == 1) System.out.print(verticesADJ[i][j] + " ");
            }
            System.out.println();
        }
    }
}

