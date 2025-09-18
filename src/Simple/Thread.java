package Simple;

public class Thread extends java.lang.Thread {
    @Override
    public void run() {
        System.out.println("I'm Thread " + this.getId() + ", bye!");
    }
}
