package kr.hs.dsm.java.taxipot_backend;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan
@EnableTransactionManagement
public class DatabaseConfig {
}
