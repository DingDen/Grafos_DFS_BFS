
public class Aplicacao {
    public static void main(String[] args) {
        GrafoMatrizADJ grafoTeste = new GrafoMatrizADJ(7, 10, false);
        GrafoMatrizADJ grafoAplicacao = new GrafoMatrizADJ(8, 10, false);
        
        // Aplicando BFS em grafos representados computacionalmente por Matriz de Adjacencia
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

        grafoTeste.MontarMatrizVerticesADJ();
        grafoAplicacao.MontarMatrizVerticesADJ();

        BFS BuscaEmLargura_TO_GrafoTeste = new BFS(grafoTeste, 1); // Comeca no vertice 1
        BFS BuscaEmLargura_TO_GrafoAplicacao = new BFS(grafoAplicacao, 4); // Comeca no vertice 4

        // Custo comeca em Zero (0) seguindo o algoritmo de Cormem ET AL
        
        // GrafoTeste
        System.out.println("******************GrafoTeste******************");
        System.out.println("Arvore gerada: ");
        BuscaEmLargura_TO_GrafoTeste.exibePiVertices();
        System.out.print("Custo total: "); System.out.println(BuscaEmLargura_TO_GrafoTeste.getDCusto());
        
        System.out.println();
        
        // GrafoAplicacao
        System.out.println("******************GrafoAplicacao******************");
        System.out.println("Arvore gerada: ");
        BuscaEmLargura_TO_GrafoAplicacao.exibePiVertices();
        System.out.print("Custo Total: "); System.out.println(BuscaEmLargura_TO_GrafoAplicacao.getDCusto());
    }
}
