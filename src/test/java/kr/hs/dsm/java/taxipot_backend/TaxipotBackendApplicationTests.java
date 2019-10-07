package kr.hs.dsm.java.taxipot_backend;

import kr.hs.dsm.java.taxipot_backend.entity.TaxiPot;
import kr.hs.dsm.java.taxipot_backend.repository.TaxipotRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@RunWith(SpringRunner.class)
@DataJpaTest
public class TaxipotBackendApplicationTests {
    @Autowired
    TaxipotRepository repository;
    @Test
    public void contextLoads() throws Exception{
        repository.save(new TaxiPot(new Date().getTime()));
    }
}
