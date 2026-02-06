package com.resh.practice.tictactoe.models;

import java.util.Scanner;

public class Player {

    private String name;
    private int id;
    private PlayerType playerType;
    private Symbol symbol;
    private Scanner scanner;

    public Player(String name, int id, PlayerType playerType, Symbol symbol) {
        this.name = name;
        this.id = id;
        this.playerType = playerType;
        this.symbol = symbol;
        this.scanner = new Scanner(System.in);
    }

    private boolean isNumberValidForMove(int number, int boardSize) {
        return number < boardSize;
    }

    public Move makeMove(Board board){

        Cell cell = getUserMove(board);
        Move move = new Move(cell, this, board );

       while(!move.validateUserMove()){
           cell = getUserMove(board);
           move = new Move(cell, this, board);
       }

        return move;
    }

    private Cell getUserMove(Board board){
        System.out.println("It is " + this.getName() + "'s turn. Your Symbol is " + this.getSymbol().getaChar());
        System.out.println("Please enter row and column number where you want to make the Move. (Starting from 0) ");

        System.out.println("Please enter the row number: ");
        int row = scanner.nextInt();

        while (!isNumberValidForMove(row, board.getSize())) {
            System.out.println("Invalid row! Please enter a valid row number according to Board size: ");
            row = scanner.nextInt();
        }

        System.out.println("Please enter the column number: ");
        int column = scanner.nextInt();

        while (!isNumberValidForMove(column, board.getSize())) {
            System.out.println("Invalid column! Please enter a valid column number according to Board size:");
            column = scanner.nextInt();
        }

        return new Cell(row, column);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
