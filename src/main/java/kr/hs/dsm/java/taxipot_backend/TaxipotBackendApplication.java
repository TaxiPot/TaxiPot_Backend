package kr.hs.dsm.java.taxipot_backend;

import kr.hs.dsm.java.taxipot_backend.batch.JobConfiguration;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableBatchProcessing
@SpringBootApplication
@EnableScheduling
public class TaxipotBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaxipotBackendApplication.class, args);
    }

}
