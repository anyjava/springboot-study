package net.anyjava.springboot.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableFeignClients
@EnableAsync
public class StudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
    }


    /**
     * 1. CORE_POOL_SIZE 를 먼저 소비 한다.
     * 2. CORE_POOL_SIZE 를 모두 점유 했다면, QUEUE_CAPACITY 값만큼 대기한다.
     * 3. QUEUE_CAPACITY 도 다 찬다면, MAX_POOL_SIZE 만큼 THREAD 를 생성해서 처리한다.
     * 주의!! 3가지의 설정을 적절히 해주어야 한다.
     */
    private static final int CORE_POOL_SIZE = 100;
    private static final int KEEP_ALIVE_SECONDS = 60;
    private static final int MAX_POOL_SIZE = Integer.MAX_VALUE;
    private static final int QUEUE_CAPACITY = Integer.MAX_VALUE;
    private static final boolean WAIT_FOR_JOBS_TO_COMPLETE_ON_SHUTDOWN = true;
    private static final int AWAIT_TERMINATION_SECONDS = 60; // 각 서비스에 맞는 적절한 값을 사용하도록 하자.

    @Bean
    @Primary
    public ThreadPoolTaskExecutor adCenterTaskExecutor() {

        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();

        threadPoolTaskExecutor.setThreadNamePrefix("AdCenter-");
        threadPoolTaskExecutor.setCorePoolSize(CORE_POOL_SIZE);
        threadPoolTaskExecutor.setMaxPoolSize(MAX_POOL_SIZE);
        threadPoolTaskExecutor.setQueueCapacity(QUEUE_CAPACITY);
        threadPoolTaskExecutor.setKeepAliveSeconds(KEEP_ALIVE_SECONDS);
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(WAIT_FOR_JOBS_TO_COMPLETE_ON_SHUTDOWN);
        threadPoolTaskExecutor.setAwaitTerminationSeconds(AWAIT_TERMINATION_SECONDS);
        threadPoolTaskExecutor.setBeanName("TaskExecutor Name");

        return threadPoolTaskExecutor;
    }
}
