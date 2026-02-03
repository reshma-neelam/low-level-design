package com.resh.practice.tictactoe.models;

import com.resh.practice.tictactoe.strategies.WinningStrategy;

import java.util.List;

public class Game {

    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private Player winner;
    private GameState gameState;
    private int nextPlayerIndex;
    private List<WinningStrategy> winningStrategies;

}
