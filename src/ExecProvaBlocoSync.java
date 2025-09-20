import java.util.ArrayList;

public class ExecProvaBlocoSync implements Runnable {
    private final ArrayList<String> listaNomes;
    private final String nome;
    private final Object monitor = new Object();

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (monitor) {
                if (listaNomes != null) {
                    listaNomes.add(nome);
                }
            }
        }
    }

    public ExecProvaBlocoSync(String meuNome, ArrayList<String> lista) {
        this.nome = meuNome;
        this.listaNomes = lista;
    }
}
