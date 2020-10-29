package com.example.demo.exception;

public class NotEnoughtTrainers extends RuntimeException {
    public NotEnoughtTrainers(String message) {
        super(message);
    }
}
