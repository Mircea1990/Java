package org.behavioral.command;

//class that will act as a Client
public class CommanPatternClient {

    public static void main(String[] args) {
        Document doc = new Document();

        ActionListernerCommand clickOpen = new ActionOpen(doc);
        ActionListernerCommand clickSave = new ActionSave(doc);

        MenuOptions menu = new MenuOptions(clickOpen, clickSave);

        menu.clickOpen();
        menu.clickSave();
    }
}
