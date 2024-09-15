public class Main {
    public static void main(String[] args) {
        GrafoMatrizADJ grafoDesconexo = new GrafoMatrizADJ(9, 9, false);

        /* GRAFO DESCONEXO REPRESENTADO:
           1 --- 2     5 -- 6    
           | \   |      \  /
           |   \ |        7
           3--- 4     8 -- 9
        */

        grafoDesconexo.addMatriz(1, 2);
        grafoDesconexo.addMatriz(1, 3);
        grafoDesconexo.addMatriz(1, 4);
        grafoDesconexo.addMatriz(2, 4);
        grafoDesconexo.addMatriz(3, 4);
        grafoDesconexo.addMatriz(5, 6);
        grafoDesconexo.addMatriz(5, 7);
        grafoDesconexo.addMatriz(6, 7);
        grafoDesconexo.addMatriz(8, 9);

        grafoDesconexo.MontarMatrizVerticesADJ();

        DFS_Components BuscaEmProfundidade_TO_GrafoDesconexo = new DFS_Components(grafoDesconexo, 1);

        // GrafoDesconexo com componentes conexos
        System.out.println("**********************GrafoDesconexo**********************");
        System.out.println("Tempo de chegada de cada vertice no grafo: ");
        BuscaEmProfundidade_TO_GrafoDesconexo.exibeDTempoVertices();
        System.out.println("Tempo de Finalizacao de cada vertice no grafo: ");
        BuscaEmProfundidade_TO_GrafoDesconexo.exibeFTempoVertices();
        System.out.print("Custo total: "); BuscaEmProfundidade_TO_GrafoDesconexo.custoFinalDFS();

        System.out.println();

        // Lista de antecessores
        System.out.println("Arvore gerada: ");
        BuscaEmProfundidade_TO_GrafoDesconexo.exibePiVertices();
        System.out.print("Numero de componentes conexos: "); System.out.println(BuscaEmProfundidade_TO_GrafoDesconexo.getContComponente()); 

        // Representacao dos componentes
        System.out.println();
        BuscaEmProfundidade_TO_GrafoDesconexo.exibeComponentesGrafo();

    }
}
