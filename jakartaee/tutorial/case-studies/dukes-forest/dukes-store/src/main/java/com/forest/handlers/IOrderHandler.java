package com.forest.handlers;

import com.forest.events.OrderEvent;


public interface IOrderHandler {

    public void onNewOrder(OrderEvent event);

}
