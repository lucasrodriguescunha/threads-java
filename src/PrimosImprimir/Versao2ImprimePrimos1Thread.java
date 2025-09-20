package PrimosImprimir;

public class Versao2ImprimePrimos1Thread {
    public static void main(String[] args) {
        int inicio = 1;
        int fim = 100000;

        ComputaPrimosThread thread = new ComputaPrimosThread(inicio, fim);
        thread.start();
    }
}
