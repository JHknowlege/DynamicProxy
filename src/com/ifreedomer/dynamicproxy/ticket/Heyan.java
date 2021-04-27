package com.ifreedomer.dynamicproxy.ticket;

public class Heyan implements TicketBoy {
    private int age;

    public Heyan(int age) {
        this.age = age;
    }

    public Heyan() {
    }


    @Override
    public void buyTrainTicket() {
        System.out.println("何言买火车票");
    }

    @Override
    public void buyFlyTicket() {
        System.out.println("何言买飞机票");

    }
}
