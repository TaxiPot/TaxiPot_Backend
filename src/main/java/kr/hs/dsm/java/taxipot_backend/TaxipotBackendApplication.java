package kr.hs.dsm.java.taxipot_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
public class TaxipotBackendApplication {

    @RequestMapping(method = RequestMethod.GET, path = "/")
    String home() {
        return "Welcome Taxipot!";
    }

    public static void main(String[] args) {
        SpringApplication.run(TaxipotBackendApplication.class, args);
    }

}
