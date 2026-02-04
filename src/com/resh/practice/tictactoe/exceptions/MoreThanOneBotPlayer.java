package com.resh.practice.tictactoe.exceptions;

public class MoreThanOneBotPlayer extends RuntimeException {
    public MoreThanOneBotPlayer(String message) {
        super(message);
    }
}
