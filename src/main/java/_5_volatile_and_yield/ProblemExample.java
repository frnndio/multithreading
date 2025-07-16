package _5_volatile_and_yield;

/**
 * JAVA MULTITHREAD - Volatile e Yield
 * @author RinaldoDev
 */
public class ProblemExample {

    private static int numero = 0;
    private static boolean preparado = false;

    private static class MeuRunnable implements Runnable {
        @Override
        public void run() {
            while (!preparado) {
                Thread.yield();
            }

            String failWarning = numero == 0 ? " <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" : "";
            System.out.println(numero + failWarning);
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 1_000; i++) {
            executeExample();
        }

    }

    private static void executeExample() {
        Thread t0 = new Thread(new MeuRunnable());
        t0.start();
        numero = 42;
        preparado = true;
    }

}
