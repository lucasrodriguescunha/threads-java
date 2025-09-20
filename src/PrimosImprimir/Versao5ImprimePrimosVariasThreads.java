package PrimosImprimir;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ComputaPrimosThreadV5 extends Thread {
    private final int limiteInferior;
    private final int limiteSuperior;
    private final List<Integer> primosEncontrados;

    public ComputaPrimosThreadV5(int limiteInferior, int limiteSuperior) {
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
        this.primosEncontrados = new ArrayList<>();
        System.out.println("ComputaPrimos(" + limiteInferior + "," + limiteSuperior + ")");
    }

    @Override
    public void run() {
        for (int valor = limiteInferior; valor <= limiteSuperior; valor++) {
            if (ehPrimo(valor)) {
                primosEncontrados.add(valor);
            }
        }
    }

    private boolean ehPrimo(int valor) {
        if (valor < 2) return false;
        for (int divisor = 2; divisor <= Math.sqrt(valor); divisor++) {
            if (valor % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> getPrimosEncontrados() {
        return primosEncontrados;
    }
}

public class Versao5ImprimePrimosVariasThreads {
    public static void main(String[] args) {
        int inicio = 5;
        int fim = 25;
        int qtdThreads = 4;

        System.out.println("Intervalo: " + inicio + " a " + fim);

        int tamanhoIntervalo = (fim - inicio + 1) / qtdThreads;

        ComputaPrimosThreadV5[] threads = new ComputaPrimosThreadV5[qtdThreads];

        int inicioAtual = inicio;

        for (int i = 0; i < qtdThreads; i++) {
            int fimAtual = (i == qtdThreads - 1) ? fim : inicioAtual + tamanhoIntervalo - 1;

            threads[i] = new ComputaPrimosThreadV5(inicioAtual, fimAtual);
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

        List<Integer> todosPrimos = new ArrayList<>();
        for (ComputaPrimosThreadV5 thread : threads) {
            todosPrimos.addAll(thread.getPrimosEncontrados());
        }

        Collections.sort(todosPrimos);

        System.out.print("Primos existentes: ");
        for (int i = 0; i < todosPrimos.size(); i++) {
            System.out.print(todosPrimos.get(i));
            if (i < todosPrimos.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println("Quantidade de primos existentes: " + todosPrimos.size());

        System.out.println("Todas as threads terminaram!");
    }
}
