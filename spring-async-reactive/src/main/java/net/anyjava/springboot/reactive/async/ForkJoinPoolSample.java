package net.anyjava.springboot.reactive.async;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class ForkJoinPoolSample implements Runnable {

    @Override
    public void run() {
        this.run(new Random().nextInt(10));
    }

    private void run(int second) {
        log.info("start doSomething, {}", second);
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            log.info("end doSomething, {}", second);
        }
    }
}
