package org.portfolio;

import org.portfolio.dao.HerpRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HerpetologyApplication {

    public static void main(String[] args) {
        SpringApplication.run(HerpetologyApplication.class, args);
    }


}
