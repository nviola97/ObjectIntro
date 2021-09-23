package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private ArrayList<BankAccount> allAccounts;
    private ArrayList<Customer> allCustomers;
    public Bank(){
        allAccounts = new ArrayList<BankAccount>();
        allCustomers = new ArrayList<Customer>();
    }
    public void doBanking(){
        var menuReader = new Scanner(System.in);
        while(true){
            printMenu();
            var userChoice = menuReader.nextInt();
            switch (userChoice){
                case 1:
                    System.exit(0);
                case 2:
                    addCustomer(menuReader);
                    break;
                case 3:
                    Customer current = selectCustomer(menuReader);
                    break;
                default:
                    System.out.println("Please choose one of the menu options");
            }
        }
    }

    private Customer selectCustomer(Scanner reader) {
    }

    private void printMenu() {
        System.out.println("what would you like to do next?");
        System.out.println("    [1] Exit Program");
        System.out.println("    [2] Add Customer");
        System.out.println("    [3] Select customer by ID");
        System.out.print(" Enter Choice:");
    }
    private void addCustomer(Scanner inputReader){
        System.out.println("What is the new customer's name:");
        inputReader.nextLine(); // eat the orphan newline from previous nextInt call
        var customerName = inputReader.nextLine();
        System.out.println("What is the new Customer's Tax ID:");
        var taxId = inputReader.nextInt();
        var newCustomer = new Customer(customerName, taxId);
        allCustomers.add(newCustomer);
    }
}
