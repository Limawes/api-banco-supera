package br.com.banco.exception;

public class BancoNotFoundException extends RuntimeException {
    public BancoNotFoundException(final String message) {
        super(message);
    }
}
