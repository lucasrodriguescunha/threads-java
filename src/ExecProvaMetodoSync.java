import java.util.ArrayList;

public class ExecProvaMetodoSync implements Runnable {
    private final ArrayList<String> listaNomes;
    private final String nome;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            adicionarNome();
        }
    }

    private synchronized void adicionarNome() {
        if (listaNomes != null) {
            listaNomes.add(nome);
        }
    }

    public ExecProvaMetodoSync(String meuNome, ArrayList<String> lista) {
        this.nome = meuNome;
        this.listaNomes = lista;
    }
}
