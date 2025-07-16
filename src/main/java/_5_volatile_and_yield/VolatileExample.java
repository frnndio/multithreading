package _5_volatile_and_yield;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * JAVA MULTITHREAD - Volatile e Yield - Exemplo reproduzível
 * @author RinaldoDev
 */
public class VolatileExample {

    private static int numero = 0;
    private static boolean preparado = false;

//    private static volatile int numero = 0;
//    private static volatile boolean preparado = false;


    private static class MeuRunnable implements Runnable {

        @Override
        public void run() {
            while (!preparado) {
                Thread.yield();
            }

            if (numero != 42) {
//        System.out.println(numero);
                throw new IllegalStateException("Inscreva-se no canal!");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        while (true) {

            List<Thread> threads = new ArrayList<>();

            /*for (int i = 0; i < 100; i++) {
                createAndStartThread(threads);
            }*/

            Arrays.stream(IntStream.range(0, 1_000).toArray()).parallel().forEach(t -> createAndStartThread(threads));


            numero = 42;
            preparado = true;

            while (threads.parallelStream()
                    .anyMatch(thread -> thread.getState() != Thread.State.TERMINATED)) {
                // espera
            }

            numero = 0;
            preparado = false;
        }
    }

    private static void createAndStartThread(List<Thread> threads) {
        Thread thread = new Thread(new MeuRunnable());
        thread.start();
        threads.add(thread);
    }

}
