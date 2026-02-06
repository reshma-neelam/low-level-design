package com.resh.practice.tictactoe;


import com.resh.practice.tictactoe.controllers.GameController;
import com.resh.practice.tictactoe.models.*;
import com.resh.practice.tictactoe.strategies.ColumnWinningStrategy;
import com.resh.practice.tictactoe.strategies.DiagonalWinningStrategy;
import com.resh.practice.tictactoe.strategies.RowWinningStrategy;
import com.resh.practice.tictactoe.strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Lets Play Tic Tac Toe!");

        /* Take inputs from user for N size and N-1 players and their names */
        /*
        System.out.println("Enter the dimension of the Board:");
        int dimensionOfBoard = scanner.nextInt();

        System.out.println("Enter the number of human players:");
        int numberOfPlayers = scanner.nextInt();
        */
        int dimensionOfBoard = 3;
        int numberOfPlayers = 2;
        List<Player> players = new ArrayList<>();
        System.out.println("Default settings : BoardSize is 3, Two players can play.");

        System.out.println("Select player type: 1. Multi-player 2. Single-player");
        System.out.println("Enter the choice number: ");

        int choice = scanner.nextInt();
        if (choice == 1) {
            for(int i = 1; i <= numberOfPlayers; i++) {
                Player player = getPlayerDetails(i);
                players.add(player);
            }
        } else if(choice == 2) {
            players.add(getPlayerDetails(1));
            players.add(getBotPlayer(2));
        }



        List<WinningStrategy> winningStrategies = new ArrayList<>();

        //default all 3 strategies added. Can be taken as input from user
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColumnWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        System.out.println("Do you want Undo feature ? (Y/N)");
        String enableUndoFeature = scanner.next();
        boolean enableUndo = enableUndoFeature.equalsIgnoreCase("Y");

        Game game = gameController.createGame(dimensionOfBoard, players, winningStrategies, enableUndo);
        System.out.println("Game is created : " + gameController.getGameState(game).toString());

        gameController.startGame(game);
        System.out.println("Game started : " + gameController.getGameState(game).toString());

        while (gameController.getGameState(game) == GameState.IN_PROGRESS) {

            // 1. printBoard
            gameController.printBoard(game);

            // 2. Specify which Player's turn and ask to make move. BOT players will do auto-move
            gameController.makeMove(game);

            //3. If Undo is supported, ask if last move undo needed ?
            if(game.isEnableUndo()){
                gameController.printBoard(game);
                if(askToUndo()) {
                    gameController.undoLastMove(game);
                    continue;
                }
            }

            //4. check if last player who made move won
            gameController.evaluateGame(game);

        }

        // print game ended once game state is out of in-progress
        gameController.concludeGame(game);

    }

    public static boolean askToUndo(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to undo the last move (Y/N): ");
        String answer = scanner.next();
        return answer.equalsIgnoreCase("Y");
    }

    public static Player getPlayerDetails(int id){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter player name: ");
        String playerName = scanner.next();
        System.out.print("Enter player symbol: ");
        char symbol = scanner.next().charAt(0);
        return new Player(playerName, id, PlayerType.HUMAN, new Symbol(symbol));
    }

    public static Player getBotPlayer(int id){
        return new Bot( id, new Symbol('O'), BotDifficultyLevel.EASY);
    }


}