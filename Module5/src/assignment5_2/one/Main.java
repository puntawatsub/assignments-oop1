package assignment5_2.one;

import java.util.ArrayList;

class Customer extends Thread {
    static private int count;
    private int timeTaken;
    private int thisCustomerId;
    private int ticketToReserve;

    public Customer() {
        count++;
        this.thisCustomerId = count;
        this.timeTaken = ((int) (Math.random() * 2000)) + 1000;
        this.ticketToReserve = ((int) (Math.random() * 4)) + 1;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(timeTaken);
            String displayText = TicketReservationManager.getInstance().reserveTicket(this.ticketToReserve) ? String.format("Customer %d reserved %d tickets.", this.thisCustomerId, this.ticketToReserve) : String.format("Customer %d couldn't reserve %d tickets.", this.thisCustomerId, this.ticketToReserve);
            System.out.println(displayText);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TicketReservationManager {

    private static TicketReservationManager instance;
    private int ticketCount = 10;

    private TicketReservationManager() {}

    public static TicketReservationManager getInstance() {
        if (instance == null) {
            instance = new TicketReservationManager();
        }
        return instance;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public synchronized boolean reserveTicket(int reservation) {
        if ((ticketCount - reservation) < 0) {
            return false;
        }
        this.ticketCount -= reservation;
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        int customerCount = 12;

        for (int i = 0; i < customerCount; i++) {
            Customer customer = new Customer();
            customer.start();
            customers.add(customer);
        }

        try {
            for (Customer customer: customers) {
                customer.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
