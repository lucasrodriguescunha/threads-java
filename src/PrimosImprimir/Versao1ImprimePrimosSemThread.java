package PrimosImprimir;

public class Versao1ImprimePrimosSemThread {
    public static void main(String[] args) {
        int inicio = 1;
        int fim = 100000;

        for (int valor = inicio; valor <= fim; valor++) {
            if (ehPrimo(valor)) {
                System.out.println(valor);
            }
        }
    }

    private static boolean ehPrimo(int valor) {
                for (int divisor = 2; divisor <= Math.sqrt(valor); divisor++) {
            if (valor % divisor == 0) {
                return false;
            }
        }
        return true;
    }
}
