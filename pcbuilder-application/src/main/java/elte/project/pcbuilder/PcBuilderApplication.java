package elte.project.pcbuilder;

import elte.project.pcbuilder.domain.user.Credential;
import elte.project.pcbuilder.domain.user.User;
import elte.project.pcbuilder.service.AuthenticationService;
import elte.project.pcbuilder.service.PCComponentService;
import elte.project.pcbuilder.service.TestDataGenerator;
import elte.project.pcbuilder.view.PCBuilderView;
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
    @Autowired
    private PCBuilderView consoleView;
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private PCComponentService pcComponentService;

    public static void main(String[] args) {
        SpringApplication.run(PcBuilderApplication.class,args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx){
        return args -> {
            dataGenerator.createTestTable();
            start();
        };
    }

    public void start(){
        User loggedInUser = new User();
        while(loggedInUser.getId() == 0){
            Credential credential = consoleView.getCredentials();
            loggedInUser = authenticationService.authenticateUser(credential);
            if(loggedInUser.getId() == 0) consoleView.loginError();
        }
        consoleView.welcomeMessage(loggedInUser.getCredential().getUsername());
        consoleView.printMenu();



    }



}
