package io.pivotal.pal.tracker;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.SQLException;


@SpringBootApplication
public class PalTrackerApplication {

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }



    @Bean
    TimeEntryRepository timeEntryRepository() throws SQLException {
        return new JdbcTimeEntryRepository(dataSource);
    }
}