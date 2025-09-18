package Simple;

public class Processo {
    public static void main(String[] args) {
        System.out.println("Process that creates Threads");

        Thread t1 = new Thread();
        t1.start();

        Thread t2 = new Thread();
        t2.start();

        System.out.println("Process completed");
    }
}

