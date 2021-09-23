package com.company;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;
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
                    Optional<Customer> current = selectCustomer(menuReader);
                    if(current.isPresent())
                    break;
                default:
                    System.out.println("Please choose one of the menu options");
            }
        }
    }

    private void doCustomerMenu(Scanner menuReader){
        System.out.println("We will finish next week");
    }
    private Optional<Customer> selectCustomer(Scanner reader) {
        System.out.println(" Customer ID:");
        var idTofind = reader.nextInt();
        for (var currentCustomer: allCustomers){
            if(currentCustomer.getId() == idTofind)
                return new Optional
        }
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
