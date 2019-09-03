package kr.hs.dsm.java.taxipot_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan("kr.hs.dsm.java.taxipot_backend.controller")
@SpringBootApplication
public class TaxipotBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaxipotBackendApplication.class, args);
    }

}
