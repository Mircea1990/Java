package org.behavioral.command;

//class that will act as an ConcreteCommand
public class ActionSave implements ActionListernerCommand {

    private final Document doc;

    public ActionSave(Document doc) {
        this.doc = doc;
    }

    @Override
    public void execute() {
        doc.save();
    }
}
