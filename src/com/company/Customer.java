package com.company;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<BankAccount> accounts;
    private int customerID;

    public Customer(String customerName, int taxID) {
        customerID = taxID;
    }

    public int getID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public boolean openAccount(double initialDeposit) {
        var newAccount = new BankAccount();
        newAccount .deposit(initialDeposit);
        var didSucceed = accounts.add(newAccount);
        return didSucceed;
    }
}