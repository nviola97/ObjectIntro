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
                case 4:
                    doYearlyMaintenance();
                    break;
                default:
                    System.out.println("Please choose one of the menu options");
            }
        }
    }

    private void doYearlyMaintenance() {
        for(var currentAccount: allAccounts);
        currentAccount.addinterest();
        System.out.println("Account ID: " + currentAccount.getAccountID() + "has balance of " + currentAccount.checkBalance());
    }

    private void doCustomerMenu(Scanner menuReader){
        System.out.println("We will finish next week");
    }
    private Optional<Customer> selectCustomer(Scanner reader) {
        System.out.println(" Customer ID:");
        var idTofind = reader.nextInt();
        for (var currentCustomer: allCustomers){
            if(currentCustomer.getId() == idTofind)
                return Optional.of(currentCustomer);
        }
        return Optional.empty();
    }
    private void doCustomerMenu(Scanner menuReader, Customer currentCustomer){
        while(true){
            printCustomerMenu();
            var customerChoice = menuReader.nextInt();
            switch (customerChoice){
                case 1:
                    openCustomerAccount(menuReader, currentCustomer);
                    break;
                case 2:
                    closeCustomerAccount(menuReader, currentCustomer);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid Input, please choose a listed option");
            }
        }
    }
    private void printCustomerMenu(){
        System.out.println("_______________________________________________");
        System.out.println(" What do you want to do with this customer");
        System.out.println("    [1] Open an account");
        System.out.println("    [2] Close an account");
        System.out.println("    [3] Return to main menu");
        System.out.println("_______________________________________________");
    }
    private void openCustomerAccount(Scanner menuReader, Customer currentCustomer){
        System.out.println("Creating account number......");
        System.out.println(" What is the initial deposit");
        var initialDeposit = menuReader.nextDouble();
        var newAccount = currentCustomer.openAccount(initialDeposit);
        allAccounts.add(newAccount);
    }
    private void closeCustomerAccount(Scanner menuReader, Customer currentCustomer){
        System.out.println(" enter account number: ");
        var accountNum = menuReader.nextInt();
        Optional<BankAccount> accountToClose = currentCustomer.closeAccount(accountNum);
        if(accountToClose.isPresent()){
            allAccounts.remove(accountToClose.get());
        }
    }

    private void printMenu() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("what would you like to do next?");
        System.out.println("    [1] Exit Program");
        System.out.println("    [2] Add Customer");
        System.out.println("    [3] Select customer by ID");
        System.out.println("    [4] Do the yearly maintenance");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
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
