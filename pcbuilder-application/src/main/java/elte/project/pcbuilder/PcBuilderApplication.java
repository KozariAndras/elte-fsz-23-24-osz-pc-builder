package elte.project.pcbuilder;

import elte.project.pcbuilder.domain.components.PCComponent;
import elte.project.pcbuilder.domain.user.Cart;
import elte.project.pcbuilder.domain.user.Credential;
import elte.project.pcbuilder.domain.user.User;
import elte.project.pcbuilder.service.*;
import elte.project.pcbuilder.view.PCBuilderView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashMap;

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
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;



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
        Cart cart = new Cart();
        cart.setPcComponents(new ArrayList<>());

        while(loggedInUser.getId() == 0){
            Credential credential = consoleView.getCredentials();
            loggedInUser = authenticationService.authenticateUser(credential);
            if(loggedInUser.getId() == 0) consoleView.loginError();
        }
        consoleView.welcomeMessage(loggedInUser.getCredential().getUsername());

        String menuInput = "";
        while(!menuInput.equals("1")){
            consoleView.printMenu();
            menuInput = consoleView.readLine();

            switch (menuInput) {
                case "1" -> {
                    System.out.println("Exiting");
                }
                case "2" -> {
                    consoleView.printComponentCategories();
                    String selectedCategory = consoleView.readLine();
                    PCComponent selectedComponent;
                    switch (selectedCategory){
                        case "1" -> {
                            selectedComponent = consoleView.printSelectedComponentCategory(pcComponentService.findAllGPU());
                            cartService.add(selectedComponent,cart.getPcComponents());
                        }
                        case "2" -> {
                            selectedComponent = consoleView.printSelectedComponentCategory(pcComponentService.findAllCPU());
                            cartService.add(selectedComponent,cart.getPcComponents());
                        }
                        case "3" -> {
                            selectedComponent = consoleView.printSelectedComponentCategory(pcComponentService.findAllCPUCooler());
                            cartService.add(selectedComponent,cart.getPcComponents());
                        }
                        case "4" -> {
                            selectedComponent = consoleView.printSelectedComponentCategory(pcComponentService.findAllMotherboard());
                            cartService.add(selectedComponent,cart.getPcComponents());
                        }
                        case "5" -> {
                            selectedComponent = consoleView.printSelectedComponentCategory(pcComponentService.findAllPSU());
                            cartService.add(selectedComponent,cart.getPcComponents());
                        }
                        case "6" -> {
                            selectedComponent = consoleView.printSelectedComponentCategory(pcComponentService.findAllRAM());
                            cartService.add(selectedComponent,cart.getPcComponents());
                        }
                        case "7" -> {
                            selectedComponent = consoleView.printSelectedComponentCategory(pcComponentService.findAllStorage());
                            cartService.add(selectedComponent,cart.getPcComponents());
                        }
                        case "8" -> {
                            selectedComponent = consoleView.printSelectedComponentCategory(pcComponentService.findAllCase());
                            cartService.add(selectedComponent,cart.getPcComponents());
                        }
                        default -> {
                            System.out.println("Wrong Input!");
                        }
                    }
                }
                case "3" -> {
                    System.out.println("Order");
                    System.out.println("Your order costs:" + cartService.calculateTotalPrice(cart.getPcComponents()).intValue() + "ft");
                    orderService.create(cart,loggedInUser);
                }
                default -> {
                    System.out.println("Bad Input!");
                }
            }
        }


    }



}
