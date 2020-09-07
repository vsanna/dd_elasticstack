package dev.ishikawa.demo.elasticstack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class ElasticstackApplication {
    final static Logger logger = LoggerFactory.getLogger(ElasticstackApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ElasticstackApplication.class, args);

        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            UUID uuid = UUID.randomUUID();
            MDC.put("uuid", uuid.toString());
            logger.info(String.format("[%s] uuid=%s", Thread.currentThread().getId(), uuid));
        }, 0, 1000, TimeUnit.MILLISECONDS);
    }

}
