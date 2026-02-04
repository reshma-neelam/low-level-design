package com.resh.practice.tictactoe.models;

public class Player {

    private String name;
    private int id;
    private PlayerType playerType;
    private Symbol symbol;

    public Player(String name, int id, PlayerType playerType, Symbol symbol) {
        this.name = name;
        this.id = id;
        this.playerType = playerType;
        this.symbol = symbol;
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
