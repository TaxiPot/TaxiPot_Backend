package kr.hs.dsm.java.taxipot_backend.batch;

import kr.hs.dsm.java.taxipot_backend.entity.TaxiPot;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
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
    @Autowired
    private JdbcCursorItemReader<TaxiPot> reader;
    @Autowired
    private ItemProcessor<TaxiPot, TaxiPot> processor;
    @Autowired
    private JpaItemWriter<TaxiPot> writer;

    private static final String query = "select * from taxipot";
    private static final int chunkSize = 10;

    @Bean
    public Job jobBuild() {
        LoggerFactory.getLogger(JobConfiguration.class).info("Job 생성중 에러?");
        return jobBuilderFactory.get("jobBuild")
                .start(stepBuild())
                .build();
    }

    @Bean
    @JobScope
    public Step stepBuild() {
        return stepBuilderFactory.get("stepBuild")
                .<TaxiPot,TaxiPot>chunk(chunkSize)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    @StepScope
    public JdbcCursorItemReader<TaxiPot> readerBuild() {
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
    public ItemProcessor<TaxiPot, TaxiPot> processorBuild() {
        return new TaxipotItemProcessor();
    }

    @Bean
    @StepScope
    public JpaItemWriter<TaxiPot> writerBuild() {
        JpaItemWriter<TaxiPot> item = new JpaItemWriter<>();
        item.setEntityManagerFactory(entityManagerFactory);
        return item;
    }
}