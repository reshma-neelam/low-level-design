package com.resh.practice.tictactoe.models;

import com.resh.practice.tictactoe.exceptions.InvalidMoveException;

public class Move {

    private Cell cell;
    private Player player;

    public Move(Cell cell, Player player) {
        this.cell = cell;
        this.player = player;
    }

    public void validateUserMove() throws InvalidMoveException {
        if(cell.getCellState()== CellState.FILLED)
            throw new InvalidMoveException("Selected Cell is already filled. Select an empty cell.");
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
