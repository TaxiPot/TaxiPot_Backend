package kr.hs.dsm.java.taxipot_backend.batch;

import kr.hs.dsm.java.taxipot_backend.entity.TaxiPot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Slf4j
@Configuration
public class JobConfiguration {
    @Autowired
    JobBuilderFactory jobBuilderFactory;
    @Autowired
    StepBuilderFactory stepBuilderFactory;
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    @Autowired
    private DataSource dataSource;

    private static final String query = "select * from taxipot";
    private static final int chunkSize = 10;

    @Bean
    public Job jobBuild() {
        return jobBuilderFactory.get("jobBuild")
                .start(stepBuild())
                .build();
    }

    @Bean
    @JobScope
    public Step stepBuild() {
        return stepBuilderFactory.get("stepBuild")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        return RepeatStatus.FINISHED;
                    }
                })
                .build();
    }

    @Bean
    @StepScope
    public JdbcCursorItemReader<TaxiPot> reader() {
        return new JdbcCursorItemReaderBuilder<TaxiPot>()
                .sql(query)
                .rowMapper(new BeanPropertyRowMapper<>(TaxiPot.class))
                .fetchSize(chunkSize)
                .dataSource(dataSource)
                .name("taxipotReader")
                .build();
    }

    @Bean
    @StepScope
    public ItemProcessor<TaxiPot, TaxiPot> paging() {
        return new TaxipotItemProcessor();
    }

    @Bean
    @StepScope
    public JpaItemWriter<TaxiPot> writer() {
        JpaItemWriter<TaxiPot> item = new JpaItemWriter<>();
        item.setEntityManagerFactory(entityManagerFactory);
        return item;
    }
}