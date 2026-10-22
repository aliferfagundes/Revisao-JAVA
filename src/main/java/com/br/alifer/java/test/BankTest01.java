package com.br.alifer.java.test;

import com.br.alifer.java.domain.exercise02.CurrentAccount;
import com.br.alifer.java.domain.exercise02.SavingsAccount;
import com.br.alifer.java.domain.exercise02.bankAccount;
import com.br.alifer.java.exceptions.InsuficientBalanceException;

public class BankTest01 {
    public static void main(String[] args) {
        bankAccount contaCorrente = new CurrentAccount("Fulano", 2500, 500);
        bankAccount contaPoupanca = new SavingsAccount("Siclano", 4300);


        try{
            contaPoupanca.withdraw(2500);
            System.out.println("Pagamento Bem sucedido!");
        }catch(InsuficientBalanceException e){
            System.out.println(e.getMessage());
        }


        try{
            contaCorrente.withdraw(2500,250);
            System.out.println("Pagamento Bem Sucedido!");
        }catch (InsuficientBalanceException e){
            System.out.println(e.getMessage());
        }
    }
}
