package org.behavioral.command;

//class that will act as an ConcreteCommand
public class ActionOpen implements ActionListernerCommand {

    private final Document doc;

    public ActionOpen(Document doc) {
        this.doc = doc;
    }

    @Override
    public void execute() {
        doc.open();
    }
}
