package com.ewise.cooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.ewise.cooking.*")
@EnableTransactionManagement
public class CookingApplication {

  public static void main(String[] args) {
    SpringApplication.run(CookingApplication.class, args);
  }

}
