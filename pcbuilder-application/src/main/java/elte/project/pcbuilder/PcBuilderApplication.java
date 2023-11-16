package elte.project.pcbuilder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan("pcbuilder-domain/src/main/java/domain/classes")
public class PcBuilderApplication {
    public static void main(String[] args) {SpringApplication.run(PcBuilderApplication.class,args);}


    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx){
        return args -> {
            System.out.println("Hello!");

        };
    }



}
