package com.example.batch.narayana.demo;

import com.example.batch.narayana.demo.model.Product;
import com.example.batch.narayana.demo.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoBatchNarayanaApplication {

    private static final Logger LOG = LoggerFactory.getLogger(DemoBatchNarayanaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoBatchNarayanaApplication.class, args);
        addShutdownHook();
    }

    @Bean
    public ApplicationRunner initApplication(ProductService productService) {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                for (int i = 0; i < 10; i++) {
                    Product product = productService.createProduct(new Product("product" + i, 10.0D, 20));
                    LOG.info("product persisted id {}", product.getId());
                }
                readDaemonThreads();
            }
        };
    }

    private static void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            LOG.info("JVM is shutting down. Executing shutdown hook...");
            // Aquí puedes añadir el código que deseas ejecutar al apagar la JVM
            readDaemonThreads();
        }));
    }


    public static void readDaemonThreads() {
        // Obtener todos los hilos activos
        Thread[] threads = new Thread[Thread.activeCount()];
        Thread.enumerate(threads);

        // Imprimir el estado de cada hilo
        for (Thread thread : threads) {
            System.out.println("--------------------------> Thread name: " + thread.getName() + ", Daemon: " + thread.isDaemon());
        }
    }



}
