package kr.hs.dsm.java.taxipot_backend;

import kr.hs.dsm.java.taxipot_backend.repository.TaxipotRepository;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TaxipotBackendApplicationTests {

    @Autowired
    JobLauncherTestUtils testUtils;
    @Autowired
    TaxipotRepository repository;

    @Test
    public void contextLoads() throws Exception{
        JobExecution execution = testUtils.launchJob();
        Assert.assertThat(execution.getStatus(), CoreMatchers.is(BatchStatus.COMPLETED));
        //Assert.assertThat();
    }

}
