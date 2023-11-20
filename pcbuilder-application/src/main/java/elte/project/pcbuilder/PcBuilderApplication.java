package elte.project.pcbuilder;

import elte.project.pcbuilder.service.TestDataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PcBuilderApplication {
    @Autowired
    private TestDataGenerator dataGenerator;

    public static void main(String[] args) {
        SpringApplication.run(PcBuilderApplication.class,args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx){
        return args -> {
            dataGenerator.createTestTable();
        };
    }



}
