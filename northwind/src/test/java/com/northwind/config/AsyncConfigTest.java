package com.northwind.config;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.Executor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootTest
public class AsyncConfigTest {

    @Autowired
    @Qualifier("taskExecutor")
    private Executor taskExecutor;

    @Test
    public void testTaskExecutorBean() {
        // Verify that the bean is not null.
        assertNotNull(taskExecutor, "The taskExecutor bean should not be null");

        // Verify that our executor is an instance of ThreadPoolTaskExecutor.
        assertTrue(taskExecutor instanceof ThreadPoolTaskExecutor, "The executor should be an instance of ThreadPoolTaskExecutor");

        ThreadPoolTaskExecutor executor = (ThreadPoolTaskExecutor) taskExecutor;

        // Verify that the executor has the expected settings.
        assertEquals(4, executor.getCorePoolSize(), "The core pool size should be 4");
        assertEquals(8, executor.getMaxPoolSize(), "The max pool size should be 8");
        assertEquals(100, executor.getQueueCapacity(), "The queue capacity should be 100");
        assertEquals("AsyncThread-", executor.getThreadNamePrefix(), "The thread name prefix should be 'AsyncThread-'");
    }
}
