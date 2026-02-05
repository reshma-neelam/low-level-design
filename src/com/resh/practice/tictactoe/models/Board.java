package com.resh.practice.tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int size;
    private List<List<Cell>> board;

    public Board(int dimension) {
        this.size = dimension;
        this.board = new ArrayList<>(dimension); // [ ]
        for (int i = 0; i < dimension; i++) {
            board.add(new ArrayList<>());// [ {}  {}  {} ]

            for (int j = 0; j < dimension; j++) {
                board.get(i).add(new Cell(i, j)); // [ { 0 0 0 }  { 0 0 0 }  { 0 0 0 } ]
            }
        }
    }

    public void printBoard() {

        for(List<Cell> row : board) {
            for(Cell cell : row) {
                cell.printCell();
            }
            System.out.println();
        }
    }

    public Move  makeMove(Move move){

        int moveRow = move.getCell().getRow();
        int moveCol = move.getCell().getCol();

        Cell cellToMove = board.get(moveRow).get(moveCol);

        cellToMove.setCellState(CellState.FILLED);
        cellToMove.setPlayer(move.getPlayer());

        System.out.println("Move made at [ " + moveRow + " , " + moveCol + " ] by player: " + cellToMove.getPlayer().getName());
        //store the move
        return new Move(cellToMove,move.getPlayer(), this);


    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
