package com.br.alifer.java.exceptions;

public class InsuficientBalanceException extends RuntimeException {
    public InsuficientBalanceException(String message) {
        super(message);
    }
}
