package com.momo.gestiondestock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan
@EnableSwagger2
public class GestiondestockApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestiondestockApplication.class, args);
    }

}
