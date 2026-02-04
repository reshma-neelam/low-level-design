package com.resh.practice.tictactoe.exceptions;

public class DuplicatePlayerSymbol extends RuntimeException {
    public DuplicatePlayerSymbol(String message) {
        super(message);
    }
}
