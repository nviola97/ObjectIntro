package com.company;

public class BankAccount {
    private double balance;
    private float interestRate;
    private int accountID;
    private static int nextId = 100;

    public BankAccount(){
        interestRate = 0.02f;
        accountID = nextId;
        nextId++;
    }

    public BankAccount(double initialBalance, float initialRate){
        balance = initialBalance;
        interestRate = initialRate;
        accountID = nextId;
        nextId+= 1;
    }
    public int getAccountID(){
        return accountID;
    }

    public BankAccount(int initialBalance) {
    }

    public void deposit(double amount){
        balance += amount;
    }
    public boolean withdraw(double amount){
        if(amount > balance){
            return false;
        }
        balance = balance - amount;
        return true;
    }
    public double checkBalance(){
        return balance;
    }
    public double addInterest(){
        balance = (interestRate * balance) + balance; return balance;
    }
}
