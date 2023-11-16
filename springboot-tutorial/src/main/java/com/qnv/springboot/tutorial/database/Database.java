package com.qnv.springboot.tutorial.database;


import com.qnv.springboot.tutorial.models.Product;
import com.qnv.springboot.tutorial.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//now connect with mysql using JPA
/*
docker run -d --rm --name mysql-spring-boot-tutorial -e MYSQL_ROOT_PASSWORD=q01689032365 -e MYSQL_USER=root -e MYSQL_PASSWORD=q01689032365 -e MYSQL_DATABASE=test_db -p 3309:3306 --volume mysql-spring-boot-tutorial-volume:/var/lib/mysql mysql: latest
 */

@Configuration
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Product productA = new Product("Macbook Pro 16", 2020, 2400.0, "");
                Product productB = new Product("ipad Air Blue", 2022, 599.0, "");
                logger.info("insert data: "+ productRepository.save(productA));
                logger.info("insert data: "+ productRepository.save(productB));
            }
        };
    }
}
