package elte.project.pcbuilder.view;

import elte.project.pcbuilder.domain.components.PCComponent;
import elte.project.pcbuilder.domain.user.Credential;

import java.util.List;

public interface PCBuilderView {
    Credential getCredentials();
    void welcomeMessage(String username);

    void printMenu();

    void printComponentCategories();
    void printSelectedComponentCategory(PCComponent pcComponent);
}
