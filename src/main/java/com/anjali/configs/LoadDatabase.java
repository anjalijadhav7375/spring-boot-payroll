package com.anjali.configs;

import com.anjali.model.Employee;
import com.anjali.model.Order;
import com.anjali.model.Status;
import com.anjali.repository.EmployeeRepository;
import com.anjali.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    @Qualifier("cmdLineRunner")
    CommandLineRunner initDatabase(EmployeeRepository repository, OrderRepository orderRepository) {

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                Employee employee = new Employee("SE","Vikram","Gupta");
                log.info("Preloading " + repository.save(employee));
                log.info("Preloading " + repository.save(new Employee("ST","Vivek","Gupta")));

                orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
                orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));

                orderRepository.findAll().forEach(order -> {
                    log.info("Preloaded " + order);
                });
            }
        };
    }
}