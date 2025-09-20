package PrimosImprimir;

public class ComputaPrimosThread extends Thread {
    private final int limiteInferior;
    private final int limiteSuperior;

    public ComputaPrimosThread(int limiteInferior, int limiteSuperior) {
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
        System.out.println("ComputaPrimos(" + limiteInferior + "," + limiteSuperior + ")");
    }

    @Override
    public void run() {
                for (int valor = limiteInferior; valor <= limiteSuperior; valor++) {
            if (ehPrimo(valor)) {
                System.out.println(valor);
            }
        }
    }

    private boolean ehPrimo(int valor) {
                for (int divisor = 2; divisor <= Math.sqrt(valor); divisor++) {
            if (valor % divisor == 0) {
                return false;
            }
        }
        return true;
    }
}

