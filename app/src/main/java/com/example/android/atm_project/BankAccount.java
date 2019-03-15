package com.example.android.atm_project;

import java.util.ArrayList;

public class BankAccount {
        //attributes
        private String number;

        public String getNumber() {
                return number;
        }

        public void setNumber(String number) {
                this.number = number;
        }

        public double getBalance() {
                return balance;
        }

        public void setBalance(double balance) {
                this.balance = balance;
        }

        public ArrayList getHistory() {
                return history;
        }

        public void setHistory(ArrayList history) {
                this.history = history;
        }

        private double balance;
        ArrayList history=new ArrayList();

        //Methods
        public void add_history(double newTrans,String type) {
                history.add(type + " : "+newTrans);
        }
}
