package org.behavioral.state;

//interface that will provide the connection to the Controller class
public interface Connection {

    void open();

    void close();

    void log();

    void update();
}
