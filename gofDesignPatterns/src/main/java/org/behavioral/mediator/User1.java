package org.behavioral.mediator;

//class that will extend Participant abstract class and will use the ApnaChatRoom interface
public class User1 extends Participant {

    private final ApnaChatRoom chat;
    private String name;

    public User1(ApnaChatRoom chat) {
        this.chat = chat;
    }

    @Override
    public void sendMsg(String msg) {
        chat.showMsg(msg, this);

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
