package PrimosImprimir;

public class Versao4ImprimePrimosVariasThreads {
    public static void main(String[] args) {
        int inicio = 1;
        int fim = 100;
        int qtdThreads = 4;

        int tamanhoIntervalo = (fim - inicio) / qtdThreads;

        ComputaPrimosThread[] threads = new ComputaPrimosThread[qtdThreads];

        int inicioAtual = inicio;

        for (int i = 0; i < qtdThreads; i++) {
            int fimAtual = (i == qtdThreads - 1) ? fim : inicioAtual + tamanhoIntervalo - 1;

            threads[i] = new ComputaPrimosThread(inicioAtual, fimAtual);
            threads[i].start();

            inicioAtual = fimAtual + 1;
        }

        for (int i = 0; i < qtdThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Todas as threads terminaram!");
    }
}
