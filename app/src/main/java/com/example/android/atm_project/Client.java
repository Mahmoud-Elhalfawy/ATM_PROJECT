package com.example.android.atm_project;

import android.content.Intent;

public class Client {
    public Client(String name, BankAccount userAccount) {
        this.name = name;
        this.userAccount = userAccount;
    }

    private String name;
    BankAccount userAccount;
    public void deposit(Double newDeposit){
        userAccount.setBalance(userAccount.getBalance()+newDeposit);
    }
    public void withdraw(Double newWithdraw){
        userAccount.setBalance(userAccount.getBalance()-newWithdraw);
    }
    public double checkBalance() {
        double balance = userAccount.getBalance();
        return balance;
    }
    public Object checkHistory(int counter){
        return userAccount.getHistory().get(counter);
    }
}
