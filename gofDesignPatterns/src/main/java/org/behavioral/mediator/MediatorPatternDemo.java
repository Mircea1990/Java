package org.behavioral.mediator;

//class that will use participants involved in chatting
public class MediatorPatternDemo {

    public static void main(String[] args) {

        ApnaChatRoom chat = new ApnaChatRoomIml();

        User1 u1 = new User1(chat);
        u1.setName("Stefanescu Mircea");
        u1.sendMsg("Hi Ana! how are you?");


        User2 u2 = new User2(chat);
        u2.setName("Ioana Constantin");
        u2.sendMsg("I am Fine ! You tell?");
    }
}
