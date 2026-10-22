package com.br.alifer.java.domain.exercise02;

import com.br.alifer.java.exceptions.InsuficientBalanceException;

public abstract class bankAccount {
    protected String owner;
    protected double balance;

    public abstract void withdraw(double val) throws InsuficientBalanceException;
    public void withdraw(double val,double tax) throws InsuficientBalanceException{

    }

    public bankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
