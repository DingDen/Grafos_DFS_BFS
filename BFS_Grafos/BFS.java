import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private String[] cor;
    private int[] piVertice;
    private int dCusto;

    public int getDCusto() { // Custo comeca em Zero (0) seguindo o algoritmo de Cormem ET AL
        return dCusto;
    }

    public BFS(GrafoMatrizADJ grafo, int vertice) { // Vertices inteiros maiores que 0 (Z*)
        cor = new String[grafo.getVertices()];
        for (int i = 0; i < grafo.getVertices(); i++) {
            if (i != vertice-1) cor[i] = "BRANCO"; // Todos menos o vertice fonte sao pintados de BRANCO
        }
        this.cor[vertice-1] = "CINZA"; // Pinta o vertice inicial de Cinza
        this.dCusto = 0;
        this.piVertice = new int[grafo.getVertices()];
        this.piVertice[vertice-1] = 0; // 0 para nulo, vertice v nao tem antecessor
        bfs(grafo, vertice);
    }

    public void bfs(GrafoMatrizADJ grafo, int w) {
        Queue<Integer> fila = new LinkedList<>();
        fila.add(w);
        while (!fila.isEmpty()) {
            int v = fila.remove();
            for (int vAdj : grafo.getVerticesADJ()[v-1]) {
                if(vAdj != 0 && cor[vAdj-1].equals("BRANCO")) { // Vertice é branco?
                    cor[vAdj-1] = "CINZA"; // Entao pinta de cinza
                    dCusto++;
                    piVertice[vAdj-1] = v; 
                    fila.add(vAdj);
                }
            }
            // Pintar de preto
            cor[v-1] = "PRETO"; 
        }
    }

    public void exibePiVertices() {
        for (int i = 0; i < piVertice.length; i++) {
            if (piVertice[i] <= 0) System.out.print("\tVertice " + (i+1) + ": " + "nulo    ");
            else System.out.print("\tVertice " + (i+1) + ": " + piVertice[i] + "    ");
            if((i+1) % 3 == 0) System.out.println();
        }
        System.out.println();
    }
}