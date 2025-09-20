package PrimosImprimir;

public class Versao3ImprimePrimos2Thread {
    public static void main(String[] args) {
        int inicio = 1;
        int fim = 100000;

        ComputaPrimosThread thread1 = new ComputaPrimosThread(inicio, fim / 2);
        thread1.start();

        ComputaPrimosThread thread2 = new ComputaPrimosThread((fim / 2) + 1, fim);
        thread2.start();
    }
}
