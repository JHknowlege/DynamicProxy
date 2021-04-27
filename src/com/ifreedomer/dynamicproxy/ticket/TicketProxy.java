package com.ifreedomer.dynamicproxy.ticket;

public class TicketProxy implements TicketBoy{
    private final TicketBoy ticketBoy;
    public TicketProxy(TicketBoy ticketBoy){
        this.ticketBoy = ticketBoy;
    }

    public void  buyTrainTicket() {
        System.out.println("帮你抢票");
        ticketBoy.buyTrainTicket();
        System.out.println("把票给你");
    }

    @Override
    public void buyFlyTicket() {
        System.out.println("帮你抢票");
        ticketBoy.buyFlyTicket();
        System.out.println("把票给你");
    }

    public static void main(String[] args) {
        TicketProxy ticketProxy = new TicketProxy(new Heyan());
        ticketProxy.buyFlyTicket();
    }
}
