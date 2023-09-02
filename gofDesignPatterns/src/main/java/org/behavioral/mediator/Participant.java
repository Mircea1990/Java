package org.behavioral.mediator;

public abstract class Participant {

    public abstract void sendMsg(String msg);

    public abstract String getName();

    public abstract void setName(String name);
}
