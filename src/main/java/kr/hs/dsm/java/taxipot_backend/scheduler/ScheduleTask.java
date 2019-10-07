package kr.hs.dsm.java.taxipot_backend.scheduler;

import kr.hs.dsm.java.taxipot_backend.repository.HistoryRepository;
import kr.hs.dsm.java.taxipot_backend.repository.TaxipotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduleTask {
    private static Logger logger = LoggerFactory.getLogger(ScheduleTask.class);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("MM월 dd일 hh시 mm분 ss초");
    @Autowired
    private static TaxipotRepository taxipotRepository;
    @Autowired
    private static HistoryRepository historyRepository;
    @Autowired
    private static JobLauncher jobLauncher;
    @Autowired
    private Job job;

    @Scheduled(cron="*/15 * * * * *")
    public void saveAllHistory(){
        logger.info("현재 시각 : {}", dateFormat.format(new Date()));
        logger.info("job null : {}", job==null);
        try {
            jobLauncher.run(job,new JobParameters());
        } catch (JobParametersInvalidException | JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException e) {
            logger.info("예외 발생 : {}", e.getMessage());
        }
    }
}
