package elte.project.pcbuilder.view;

import elte.project.pcbuilder.domain.components.PCComponent;
import elte.project.pcbuilder.domain.user.Credential;
import elte.project.pcbuilder.domain.user.Order;
import elte.project.pcbuilder.domain.user.OrderItem;

import java.util.List;
import java.util.Scanner;

public class PCBuilderConsoleView implements PCBuilderView {
    @Override
    public Credential getCredentials(){
        Credential userCredentials = new Credential();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please login!");
        System.out.print("Username: ");
        userCredentials.setUsername(sc.nextLine());
        System.out.print("Password: ");
        userCredentials.setPassword(sc.nextLine());
        return userCredentials;
    }

    @Override
    public void loginError() {
        System.out.println("Invalid Login Credentials.");
        System.out.println("Please try again!");
    }

    @Override
    public void welcomeMessage(String username) {
        System.out.printf("Welcome to the PCBuilder application %s!%n",username);
    }

    @Override
    public void printMenu() {
        System.out.println("1. Exit");
        System.out.println("2. Buy");
        System.out.println("3. Order");
        System.out.println("4. Check orders");
        System.out.println("5. Delete order");
    }


    @Override
    public void printComponentCategories() {
        System.out.println("1. GPU");
        System.out.println("2. CPU");
        System.out.println("3. CPU Cooler");
        System.out.println("4. Motherboard");
        System.out.println("5. PSU");
        System.out.println("6. RAM");
        System.out.println("7. Storage");
        System.out.println("8. Case");
    }

    @Override
    public PCComponent printSelectedComponentCategory(List<? extends PCComponent> pcComponentLists) throws IndexOutOfBoundsException {
        for (int i = 0; i < pcComponentLists.size(); i++) {
            System.out.printf("%d. %s Price:%d%n",i + 1,pcComponentLists.get(i).getName(),pcComponentLists.get(i).getPrice().intValue());
        }
        int itemNumber = Integer.parseInt(readLine()) - 1;
        return pcComponentLists.get(itemNumber);
    }

    @Override
    public String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void printOrders(List<Order> orderList) {
        if(orderList.isEmpty()){
            System.out.println("You don't have any orders.");
        } else {
            for (int i = 0; i < orderList.size(); i++) {
                List<OrderItem> orderItems = orderList.get(i).getOrderItems();
                System.out.println("Order - " + (i+1));
                for (int j = 0; j < orderItems.size(); j++) {
                    OrderItem currentOrderItem = orderItems.get(j);
                    System.out.println("    "+currentOrderItem.toString());
                }
            }
        }

    }

    @Override
    public Order getOrderForDelete(List<Order> orderList) {
        printOrders(orderList);
        int i = Integer.parseInt(readLine()) - 1;
        return orderList.get(i);
    }


}
