import java.util.ArrayList;

public class ExecProvaOriginal implements Runnable {
    private final ArrayList<String> listaNomes;
    private final String nome;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            listaNomes.add(nome);
        }
    }

    public ExecProvaOriginal(String meuNome, ArrayList<String> lista) {
        this.nome = meuNome;
        this.listaNomes = lista;
    }
}
