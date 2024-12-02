//package Lab_6;

import java.util.Random;

class CounterEmptyException extends Exception 
{
    public CounterEmptyException(String message) 
    {
        super(message);
    }
}

class CoffeeShop 
{
    private int counter=0;
    private final int maxcapacity=3;

    // Synchronize methods for wait() and notify()
    public synchronized void addCoffee() throws InterruptedException 
    {
        while(counter==maxcapacity) 
        {
            System.out.println("Barista is waiting. Counter is full.");
            wait();
        }
        counter++;
        System.out.println("Barista prepared coffee. Counter: " + counter);
        notifyAll();  // Notify customers and reviewers
    }

    public synchronized void pickUpCoffee(int quantity) throws InterruptedException, CounterEmptyException {
        while (counter==0) 
        {
            System.out.println("Customer is waiting. Counter is empty.");
            wait();
        }
        if (counter<quantity) 
            throw new CounterEmptyException("Not enough coffee available.");
        
        counter=counter-quantity;
        System.out.println("Customer picked up " + quantity + " coffee(s). Counter: " + counter);
        notifyAll();  // Notify baristas and reviewers
    }

    public synchronized void sampleCoffee() throws InterruptedException, CounterEmptyException 
    {
        while(counter==0) 
        {
            System.out.println("Reviewer is waiting. Counter is empty.");
            wait();
        }
        counter--;
        System.out.println("Coffee Reviewer sampled coffee. Counter: " + counter);
        notifyAll();  // Notify baristas and customers
    }
}

class Barista extends Thread 
{
    private CoffeeShop shop;
    private int coffeeprep;

    public Barista(CoffeeShop shop, int coffeeprep) 
    {
        this.shop = shop;
        this.coffeeprep = coffeeprep;
    }

    public void run() 
    {
        try 
        {
            for (int i=0; i<coffeeprep; i++) 
            {
                shop.addCoffee();
                //Coffee preparation time
                Thread.sleep(new Random().nextInt(1000)); 
            }
        } 
        catch(InterruptedException e) 
        {
            Thread.currentThread().interrupt();
        }
    }
}

class Customer extends Thread 
{
    private CoffeeShop shop;
    private int coffeesToPick;

    public Customer(CoffeeShop shop, int coffeesToPick) 
    {
        this.shop=shop;
        this.coffeesToPick=coffeesToPick;
    }

    public void run() 
    {
        try 
        {
            shop.pickUpCoffee(coffeesToPick);
            //Time taken to pick up coffee
            Thread.sleep(new Random().nextInt(1000)); 
        }
        catch(InterruptedException|CounterEmptyException e) 
        {
            e.printStackTrace();
        }
    }
}

class Reviewer extends Thread 
{
    private CoffeeShop shop;

    public Reviewer(CoffeeShop shop) 
    {
        this.shop=shop;
    }

    public void run() 
    {
        try 
        {
            shop.sampleCoffee();
            //Review time
            Thread.sleep(new Random().nextInt(1000)); 
        } 
        catch(InterruptedException|CounterEmptyException e) 
        {
            e.printStackTrace();
        }
    }
}

public class Question2
{
    public static void main(String[] args) 
    {
        CoffeeShop shop = new CoffeeShop();

        Thread barista1 = new Barista(shop, 2);
        Thread barista2 = new Barista(shop, 3);

        Thread customer1 = new Customer(shop, 1);
        Thread customer2 = new Customer(shop, 2);
        Thread customer3 = new Customer(shop, 1);

        Thread reviewer = new Reviewer(shop);

        barista1.start();
        barista2.start();
        customer1.start();
        customer2.start();
        customer3.start();
        reviewer.start();

        try 
        {
            barista1.join();
            barista2.join();
            customer1.join();
            customer2.join();
            customer3.join();
            reviewer.join();
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }
}