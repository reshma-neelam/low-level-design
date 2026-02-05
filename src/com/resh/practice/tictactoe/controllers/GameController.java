package com.resh.practice.tictactoe.controllers;

import com.resh.practice.tictactoe.models.Game;
import com.resh.practice.tictactoe.models.GameState;
import com.resh.practice.tictactoe.models.Player;
import com.resh.practice.tictactoe.strategies.WinningStrategy;

import java.util.List;

public class GameController {

    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        return Game.createBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public GameState getGameState(Game game){
        return game.getGameState();
    }

    public void printBoard(Game game){
        game.printBoard();
    }

    void getWinner(Game game){
    }


    public void concludeGame(Game game){
        game.concludeGame();
    }


}
