package kr.hs.dsm.java.taxipot_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TaxipotBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaxipotBackendApplication.class, args);
    }

}
