/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketingsystem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 *   Author Meyer Evenblij
 *   16/10/19
 *   Creates a queue data structure for a shop which for every 3 seconds 
 *   a new customer arrives and every 5 seconds the sales staff is ready 
 *   to see the customer. Customers are then seen in oder of arrival   
 * 
 */

public class TicketingSystem {

    //  Creates a "queue" which stores, displays and outputs the numbers for the "queue"
    public static Queue<String> customerNumber = new LinkedList();

    //  "main" method
    public static void main(String[] args) {
        addCustomers();
        //  "i" displays the placemaker 
        customerNumber.add("1");
        Timer timer = new Timer();
        
        //  The timer which is located in CustomerArrivalTask and it counts ever 5 seconds.
        timer.schedule(new CustomerArrivalTask(), 0, 5000); 
        //  Creates the output for one generation of customer which starts at one
        for (int i = 1; i < 30; i++) {
            customerNumber.add("" + i);
        }
        //  Creates output for the generation of the customer which starts at two
        for (int i = 2; i < 30; i++) {
            customerNumber.add("" + i); 
        }
    }

    //  The "method" that adds a new customer every 3 seconds
    public static void addCustomers() {
        Timer timer = new Timer();
        timer.schedule(new NumberAllocation(), 0, 3000);   
    }

    //  An "inner class" describing the task of seeding the next customer from the "queue"
    public static class CustomerArrivalTask extends TimerTask {

        public void run() {
            //  If the customer number is empty then they are ready move onto next customer
            if (customerNumber.isEmpty()) {
                System.out.println("Sales Assistant is ready to see the next customer..");
                System.out.println("There are no customers to see.\n");
            //   Executes when customers are in the queue and removes old values followed by outputting which customer will be seen and who's next in the queue
            } else {
                System.out.println("Sales Assistant is ready to see the next customer..");
                System.out.println("The customer with ticket number " + customerNumber.poll() + " will be seen");
                //removes the number from the top of the queue which has just been called
                customerNumber.remove(customerNumber.poll());
                //  Output for customers in the queue
                System.out.println("The customers with the following tickets are in the queue: " + customerNumber.toString() + "\n");
            }
        }
    }

    //  "inner class" displaying when the customer has been added and where they sit within the "queue"
    public static class NumberAllocation extends TimerTask {
        //the inner class which deals with the customer being added to the queue
        public void run() {
            customerNumber.add(customerNumber.element());
            //displays the ticket number and notifies that they've been added to the queue
            System.out.println("Customer with ticket " + customerNumber.poll() + " is added to the queue.\n");
        }
    }
}