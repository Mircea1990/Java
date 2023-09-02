package org.behavioral.command;

//class that will act as an Invoker
public class MenuOptions {

    private final ActionListernerCommand openCommand;
    private final ActionListernerCommand saveCommand;

    public MenuOptions(ActionListernerCommand open, ActionListernerCommand save) {
        this.openCommand = open;
        this.saveCommand = save;
    }

    public void clickOpen() {
        openCommand.execute();
    }

    public void clickSave() {
        saveCommand.execute();
    }
}
