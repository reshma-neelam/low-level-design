package com.resh.practice.tictactoe.strategies;

import com.resh.practice.tictactoe.models.*;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {


    @Override
    public Move makeMove(Board board, Bot bot) {

        for(List<Cell> row : board.getBoard()) {
            for(Cell cell : row) {
                if(cell.getCellState()== CellState.EMPTY) {
                    return new Move(cell, bot);
                }
            }
        }
        return null;
    }
}