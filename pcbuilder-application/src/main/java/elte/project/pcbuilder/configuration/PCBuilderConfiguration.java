package elte.project.pcbuilder.configuration;

import elte.project.pcbuilder.view.PCBuilderConsoleView;
import elte.project.pcbuilder.view.PCBuilderView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PCBuilderConfiguration {
    @Bean
    public PCBuilderView consoleView() {
        return new PCBuilderConsoleView();
    }

}

