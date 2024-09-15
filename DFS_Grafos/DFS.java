public class DFS {
    private String[] cor;
    private int[] piVertice;
    private int contTempo;
    private int[] dTempo;
    private int[] fTempo;
    private int verticeDeEscolha;

    public DFS (GrafoMatrizADJ grafo, int v) { // v > 0
        if (v <= 0) throw new IllegalArgumentException("O valor do vertice deve ser maior que 0");
        this.verticeDeEscolha = v;
        cor = new String[grafo.getVertices()];
        for(int i = 0; i < grafo.getVertices(); i++) {
            cor[i] = "BRANCO";
        }
        dTempo = new int[grafo.getVertices()];
        fTempo = new int[grafo.getVertices()];
        piVertice = new int[grafo.getVertices()]; // Inicializacao da lista de vertices antecessores
        DFS_Visit(grafo, v); // Aplica visita
    }

    private void DFS_Visit(GrafoMatrizADJ grafo, int w) {
        cor[w-1] = "CINZA"; // Vertice atual
        contTempo++; // Custo de tempo
        dTempo[w-1] =  contTempo; // Salvando o tempo de chegada do vertice
        for (int vAdj : grafo.getVerticesADJ()[w-1]) { // Explora ADJ
            if(vAdj != 0 && cor[vAdj-1].equals("BRANCO")) { // Vertice é branco?
                piVertice[vAdj-1] = w;
                DFS_Visit(grafo, vAdj);
            }
        }
        cor[w-1] = "PRETO"; // Pinta de Preto
        fTempo[w-1] = ++contTempo; // Salvando o tempo de finalizacao do vertice
    }

    public void exibePiVertices() {
        for (int i = 0; i < piVertice.length; i++) {
            if (piVertice[i] <= 0) System.out.print("\tVertice " + (i+1) + ": " + "nulo    ");
            else System.out.print("\tVertice " + (i+1) + ": " + piVertice[i] + "    ");
            if((i+1) % 3 == 0) System.out.println();
        }
    }

    public void exibeFTempoVertices() { // Tempo de finalizacao de cada vertice
        for (int i = 0; i < fTempo.length; i++) {
            System.out.print("\tVertice " + (i+1) + ": " + fTempo[i] + "    ");
            if((i+1) % 3 == 0) System.out.println();
        }
        System.out.println();
    }

    // Custo inicial é 1 seguindo o algoritmo de Cormem Et Al
    public void exibeDTempoVertices() { // Tempo de chegada de cada vertice
        for(int i = 0; i < dTempo.length; i++) {
            System.out.print("\tVertice " + (i+1) + ": " + dTempo[i] + "    ");
            if((i+1) % 3 == 0) System.out.println();
        }
        System.out.println();
    }

    public void custoFinalDFS() { // Custo final quando o algoritmo retorna ao primeiro vertice
        System.out.println(fTempo[verticeDeEscolha-1]);
    }

}