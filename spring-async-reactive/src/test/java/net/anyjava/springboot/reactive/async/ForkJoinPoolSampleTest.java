package net.anyjava.springboot.reactive.async;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolSampleTest {

    @Test
    public void testForkJoinPool() throws InterruptedException {

        ForkJoinPool pool = new ForkJoinPool(2);

        for (int i = 0; i < 5; ++i) {
            pool.execute(new ForkJoinPoolSample());
        }

        Thread.sleep(10 * 1000);
    }

    @Test
    public void testThreadPool() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; ++i) {
            executor.execute(new ForkJoinPoolSample());
        }

        Thread.sleep(10 * 1000);
    }

}