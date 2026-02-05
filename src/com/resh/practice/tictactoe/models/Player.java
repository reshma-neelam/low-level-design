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

    public Move makeMove(){
        System.out.println("Please enter row and column number where you want to make the Move. (Starting from 0) ");

        System.out.println("Please enter the row number: ");
        int row = scanner.nextInt();
        System.out.println("Please enter the column number: ");
        int column = scanner.nextInt();

        return new Move(new Cell(row, column), this);
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
