
public class SessaoTeste {
    public static void main(String[] args) {
        GrafoMatrizADJ grafoTeste = new GrafoMatrizADJ(7, 10, false);
        GrafoMatrizADJ grafoAplicacao = new GrafoMatrizADJ(8, 10, false);
        
        // Aplicando DFS em grafos representados computacionalmente por Matriz de Adjacencia
        grafoTeste.addMatriz(1, 2); grafoAplicacao.addMatriz(1, 2);
        grafoTeste.addMatriz(1, 3); grafoAplicacao.addMatriz(1, 6);
        grafoTeste.addMatriz(1, 4); grafoAplicacao.addMatriz(1, 7);
        grafoTeste.addMatriz(2, 4); grafoAplicacao.addMatriz(1, 8);
        grafoTeste.addMatriz(2, 6); grafoAplicacao.addMatriz(2, 8);
        grafoTeste.addMatriz(3, 4); grafoAplicacao.addMatriz(3, 4);
        grafoTeste.addMatriz(4, 7); grafoAplicacao.addMatriz(3, 6);
        grafoTeste.addMatriz(5, 6); grafoAplicacao.addMatriz(4, 5);
        grafoTeste.addMatriz(5, 7); grafoAplicacao.addMatriz(6, 7);
        grafoTeste.addMatriz(6, 7); grafoAplicacao.addMatriz(7, 8);

        // Montando uma matriz onde cada linha representa os adjacentes de um vertice 
        grafoTeste.MontarMatrizVerticesADJ();
        grafoAplicacao.MontarMatrizVerticesADJ();

        DFS BuscaEmProfundidade_TO_GrafoTeste = new DFS(grafoTeste, 1); // Comeca a busca a partir do Vertice 1
        DFS BuscaEmProfundidade_TO_GrafoAplicacao = new DFS(grafoAplicacao, 4); // Comeca a busca a partir do Vertice 4
    
        // Custo inicial é 1 seguindo o algoritmo de Cormem Et Al
        
        // GrafoTeste
        System.out.println("******************GrafoTeste******************");
        System.out.println("Tempo de chegada de cada vertice no grafo: ");
        BuscaEmProfundidade_TO_GrafoTeste.exibeDTempoVertices();
        System.out.println("Tempo de Finalizacao de cada vertice no grafo: ");
        BuscaEmProfundidade_TO_GrafoTeste.exibeFTempoVertices();
        System.out.print("Custo total: "); BuscaEmProfundidade_TO_GrafoTeste.custoFinalDFS();
        
        System.out.println();
        
        // Lista de antecessores
        System.out.println("Arvore gerada: ");
        BuscaEmProfundidade_TO_GrafoTeste.exibePiVertices();
        
        System.out.println();

        // GrafoAplicacao
        System.out.println("******************GrafoAplicacao******************");
        System.out.println("Tempo de chegada de cada vertice no grafo: ");
        BuscaEmProfundidade_TO_GrafoAplicacao.exibeDTempoVertices();
        System.out.println("Tempo de Finalizacao de cada vertice no grafo: ");
        BuscaEmProfundidade_TO_GrafoAplicacao.exibeFTempoVertices();
        System.out.print("Custo total: "); BuscaEmProfundidade_TO_GrafoAplicacao.custoFinalDFS();
        
        System.out.println();
        
        // Lista de antecessores
        System.out.println("Arvore gerada: ");
        BuscaEmProfundidade_TO_GrafoAplicacao.exibePiVertices();
    }
}