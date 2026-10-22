package com.br.alifer.java.domain.exercise02;

import com.br.alifer.java.exceptions.InsuficientBalanceException;

public class CurrentAccount extends bankAccount {
    private double limit;
    public CurrentAccount(String owner, double balance, double limit) {
        super(owner, balance);
        this.limit = limit;
    }

    @Override
    public void withdraw(double val) {
        double supportVal;
        if((balance + limit ) >= (val)){
            if(((balance)-(val)<0)){
                supportVal= (val)-balance;
                limit-=supportVal;
                balance = 0.0;
                return;
            }
            balance -= (val);
        }else{
            throw new InsuficientBalanceException("Saldo e limite Insuficiente!");
        }
    }
    @Override
    public void withdraw(double val, double tax) throws InsuficientBalanceException {
        double supportVal;
        if((balance + limit ) >= (val + tax)){
            if(((balance)-(val+tax))<0){
                supportVal= (val+tax)-balance;
                limit-=supportVal;
                balance = 0.0;
                return;
            }
            balance -= (val+tax);
        }else{
            throw new InsuficientBalanceException("Saldo e limite Insuficiente!");
        }
    }
}
