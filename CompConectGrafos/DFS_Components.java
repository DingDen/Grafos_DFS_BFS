import java.util.ArrayList;
import java.util.List;

public class DFS_Components {
    private String[] cor;
    private int[] piVertice;
    private int contTempo;
    private int[] dTempo;
    private int[] fTempo;
    private int verticeDeEscolha;
    private List<List<Integer>> componenteGrafos; // Lista com todos os componentes do grafo
    private List<Integer> componenteAtual; // Componente em si
    
    //  *** MODIFICACAO PARA CONTAR OS COMPONENTES CONEC ***
    private int contComponente; // Variavel criada para contar os componentes conexos de um grafo

    public int getContComponente() { // Retorna o número de componentes conexos do grafo
        return ++contComponente;
    }

    public int getVerticeDeEscolha() { // Vertice inicial em que se realiza a busca DFS
        return verticeDeEscolha;
    }

    public DFS_Components (GrafoMatrizADJ grafo, int v) { // Adaptado para identificar componentes conectados
        if (v <= 0) throw new IllegalArgumentException("O valor do vertice deve ser maior que 0");
        this.verticeDeEscolha = v;
        cor = new String[grafo.getVertices()];
        for(int i = 0; i < grafo.getVertices(); i++) {
            cor[i] = "BRANCO";
        }
        //  *** MODIFICACAO PARA CONTAR OS COMPONENTES CONEC ***
        contComponente = 0; // Inicializa a variavel que conta os componentes do grafo
        
        componenteGrafos = new ArrayList<>(); // Inicializacao da Lista de componentes

        dTempo = new int[grafo.getVertices()];
        fTempo = new int[grafo.getVertices()];
        piVertice = new int[grafo.getVertices()]; // Inicializacao da lista de vertices antecessores
        
        componenteAtual = new ArrayList<>(); // Inicializacao do componente atual (lista com os vertices do componente)
        DFS_Visit(grafo, v);
        componenteGrafos.add(new ArrayList<>(componenteAtual)); // Adiciona uma copia do componente atual na Lista

        for (int i = 0; i < cor.length; i++) { // *** MODIFICACAO PARA CONTAR OS COMPONENTES CONEC ***
            if (!cor[i].equals("PRETO")) { // Se for branco então aplica DFS nos outros componentes do grafo
                componenteAtual.clear(); // Limpa a lista do componente anterior
                DFS_Visit(grafo, i+1); // De acordo com vertices > 0, entao incrementa-se i em 1 
                componenteGrafos.add(new ArrayList<>(componenteAtual)); // Guarda uma copia do novo componente
                contComponente++;
            }
        }
        
    }

    private void DFS_Visit(GrafoMatrizADJ grafo, int w) {
        cor[w-1] = "CINZA"; // Vertice atual
        contTempo++; // Custo de tempo
        dTempo[w-1] =  contTempo; // Salvando o tempo de chegada do vertice
        componenteAtual.add(w); // Guarda o vertice w para a lista de componentes
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

    // Custo total é diferente para grafo desconexo, ele finaliza apenas no ultimo componente
    public void custoFinalDFS() { // Custo final quando o algoritmo retorna ao primeiro vertice (nesse caso no ultimo componente)
        
        // Funcao que retorna o maior tempo
        int maior = fTempo[0]; 
        
        for (int t : fTempo) {
            if(t >= maior) maior = t;
        }

        System.out.println(maior); // Custo final do algoritmo
    }

    // Exibe os componentes conexos encontrados no Grafo
    public void exibeComponentesGrafo() {
        System.out.println("Componentes conexos: ");
        for (int i = 0; i < componenteGrafos.size(); i++) {
            System.out.print("Componente " + (i+1) + ": ");
            for (Integer v : componenteGrafos.get(i)) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}