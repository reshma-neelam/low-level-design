package com.resh.practice.tictactoe.models;

import java.util.List;

public class Move {

    private Cell cell;
    private Player player;
    private Board  board;

    public Move(Cell cell, Player player,  Board board) {
        this.cell = cell;
        this.player = player;
        this.board = board;
    }

    public boolean validateUserMove(){

        if(board.getBoard().get(cell.getRow()).get(cell.getCol()).getCellState() == CellState.FILLED){
            board.printBoard();
            System.out.println("Selected Cell is already filled. Select an empty cell.");
            return false;
        }

        return true;
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
    public Board getBoard() {
        return board;
    }
}
