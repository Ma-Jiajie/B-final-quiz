package com.example.demo.exception;

// TODO GTB-工程实践: - 拼写错误NotEnoughtTrainers
public class NotEnoughtTrainers extends RuntimeException {
    public NotEnoughtTrainers(String message) {
        super(message);
    }
}
