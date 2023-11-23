package elte.project.pcbuilder.view;

import elte.project.pcbuilder.domain.components.PCComponent;
import elte.project.pcbuilder.domain.user.Credential;

import java.util.Collection;
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
    public void printSelectedComponentCategory(PCComponent pcComponent) {

    }

    @Override
    public String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
