package com.br.alifer.java.domain.exercise02;

import com.br.alifer.java.exceptions.InsuficientBalanceException;

public class SavingsAccount extends bankAccount{
    public SavingsAccount(String owner, double balance) {
        super(owner, balance);
    }

    @Override
    public void withdraw(double val) {
        if(balance >= val){
            balance -= val;
        }else{
            throw new InsuficientBalanceException("Saldo Insuficiente!");
        }
    }
}
