package com.anjali.configs;

import com.anjali.payroll.Employee;
import com.anjali.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDataBase {
    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);

    @Bean
    CommandLineRunner initDataBase (EmployeeRepository repository ){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                log.info("Preloading" + repository.save(new Employee ("Anjali","SE")));
                log.info("Preloading" + repository.save(new Employee("Rutuja","ST")));
            }
        };
    }
}
