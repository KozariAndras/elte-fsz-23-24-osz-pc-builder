package elte.project.pcbuilder.view;

import elte.project.pcbuilder.domain.components.PCComponent;
import elte.project.pcbuilder.domain.user.Credential;
import elte.project.pcbuilder.domain.user.Order;
import elte.project.pcbuilder.domain.user.OrderItem;

import java.util.List;

public interface PCBuilderView {
    Credential getCredentials();
    void loginError();
    void welcomeMessage(String username);
    void printMenu();
    void printComponentCategories();
    PCComponent printSelectedComponentCategory(List<? extends PCComponent> pcComponents);
    String readLine();

    void printOrders(List<Order> orderList);

    Order getOrderForDelete(List<Order> orderList);

    void listOrderItems(List<OrderItem> cartItems);
}
