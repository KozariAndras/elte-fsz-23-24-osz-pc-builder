package elte.project.pcbuilder;

import elte.project.pcbuilder.domain.components.PCComponent;
import elte.project.pcbuilder.domain.user.Credential;
import elte.project.pcbuilder.domain.user.Order;
import elte.project.pcbuilder.domain.user.User;
import elte.project.pcbuilder.service.*;
import elte.project.pcbuilder.view.PCBuilderView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PCBuilder implements CommandLineRunner {
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

    @Override
    public void run(String... args) throws Exception {
        dataGenerator.createTestTable();
        start();
    }

    public void start(){
        User loggedInUser = new User();
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
                case "1" -> System.out.println("Exiting");
                case "2" -> {
                    consoleView.printComponentCategories();
                    String selectedCategory = consoleView.readLine();
                    PCComponent selectedComponent;
                    switch (selectedCategory){
                        case "1" -> {
                            selectedComponent = consoleView.printSelectedComponentCategory(pcComponentService.findAllGPU());
                            cartService.add(selectedComponent);
                        }
                        case "2" -> {
                            selectedComponent = consoleView.printSelectedComponentCategory(pcComponentService.findAllCPU());
                            cartService.add(selectedComponent);
                        }
                        case "3" -> {
                            selectedComponent = consoleView.printSelectedComponentCategory(pcComponentService.findAllCPUCooler());
                            cartService.add(selectedComponent);
                        }
                        case "4" -> {
                            selectedComponent = consoleView.printSelectedComponentCategory(pcComponentService.findAllMotherboard());
                            cartService.add(selectedComponent);
                        }
                        case "5" -> {
                            selectedComponent = consoleView.printSelectedComponentCategory(pcComponentService.findAllPSU());
                            cartService.add(selectedComponent);
                        }
                        case "6" -> {
                            selectedComponent = consoleView.printSelectedComponentCategory(pcComponentService.findAllRAM());
                            cartService.add(selectedComponent);
                        }
                        case "7" -> {
                            selectedComponent = consoleView.printSelectedComponentCategory(pcComponentService.findAllStorage());
                            cartService.add(selectedComponent);
                        }
                        case "8" -> {
                            selectedComponent = consoleView.printSelectedComponentCategory(pcComponentService.findAllCase());
                            cartService.add(selectedComponent);
                        }
                        default -> System.out.println("Wrong Input!");
                    }
                }
                case "3" -> {
                    if(cartService.calculateTotalPrice().intValueExact() != 0){
                        System.out.println("Order:");
                        System.out.println("Your order costs:" + cartService.calculateTotalPrice().intValueExact() + "ft.");
                        orderService.create(cartService.getCartItems(),loggedInUser);
                    }else {
                        System.out.println("Your cart is empty.");
                    }

                }
                case "4" -> {
                    if(!cartService.getCartItems().isEmpty()){
                        System.out.println("Cart:");
                        consoleView.listOrderItems(cartService.getCartItems());
                    } else {
                        System.out.println("Your cart is empty.");
                    }
                }
                case "5" -> {
                    List<Order> orderList = orderService.getOrdersByUser(loggedInUser);
                    consoleView.printOrders(orderList);
                }
                case "6" -> {
                    List<Order> orderList = orderService.getOrdersByUser(loggedInUser);
                    Order orderForDelete = consoleView.getOrderForDelete(orderList);

                    orderService.remove(orderForDelete);
                }
                default -> System.out.println("Bad Input!");
            }
        }

    }
}
