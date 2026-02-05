package com.resh.practice.tictactoe.strategies;

import com.resh.practice.tictactoe.models.Board;
import com.resh.practice.tictactoe.models.Move;

public class RowWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkIfWon(Board board, Move move) {
        return false;
    }

}
