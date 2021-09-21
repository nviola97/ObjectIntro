package com.company;

public class Main {

    public static void main(String[] args) {
        var myAccount = new BankAccount(2000);
        var yourAccount = new BankAccount(2000, 0.05f);
        myAccount.deposit(1000);
        var newBalance = myAccount.addInterest();
        var yourBalance = yourAccount.addInterest();
        System.out.println("Your account with account ID: "+yourAccount.getAccountID()+ " has " + yourBalance + " after adding interest.");
        var succeeded = myAccount.withdraw(2000);
        if (succeeded)
            System.out.println("you managed to withdraw successfully");
        else
            System.out.println(" You don't have that much money. Balance is: "+myAccount.checkBalance());
    }
}
