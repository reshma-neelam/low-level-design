package com.resh.practice.tictactoe.exceptions;

public class InvalidNumberOfPlayers extends RuntimeException {
    public InvalidNumberOfPlayers(String message) {
        super(message);
    }
}
