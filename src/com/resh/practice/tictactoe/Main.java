package com.resh.practice.tictactoe;


import com.resh.practice.tictactoe.controllers.GameController;
import com.resh.practice.tictactoe.models.*;
import com.resh.practice.tictactoe.strategies.ColumnWinningStrategy;
import com.resh.practice.tictactoe.strategies.RowWinningStrategy;
import com.resh.practice.tictactoe.strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the dimension of the Board:");
        int dimensionOfBoard = scanner.nextInt();

        System.out.println("Enter the number of players:");
        int numberOfPlayers = scanner.nextInt();

        List<Player> players = new ArrayList<>();
        List<WinningStrategy> winningStrategies = new ArrayList<>();

        System.out.println("Enter the player Name:");
        String playerName = scanner.next();

        players.add(new Player(playerName, 1, PlayerType.HUMAN, new Symbol('X')));
        players.add(new Bot(2, new Symbol('O'), BotDifficultyLevel.EASY));

        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColumnWinningStrategy());

        Game game = gameController.startGame(dimensionOfBoard, players, winningStrategies);

        System.out.println("Game started : " + gameController.getGameState(game).toString());
        game.setGameState(GameState.IN_PROGRESS);

        while (gameController.getGameState(game) == GameState.IN_PROGRESS) {

            // 1. printBoard
            gameController.printBoard(game);

            // 2. Specify which Player's turn and ask to make move. BOT players will do auto-move
            gameController.makeMove(game);



        }

        // print game ended once game state is out of in-progress
        gameController.concludeGame(game);



    }
}