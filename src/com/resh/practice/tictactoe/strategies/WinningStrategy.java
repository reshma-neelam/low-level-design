package com.resh.practice.tictactoe.strategies;

import com.resh.practice.tictactoe.models.Board;
import com.resh.practice.tictactoe.models.Move;
import com.resh.practice.tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public interface WinningStrategy {

    public boolean checkIfWon(Board board, Move move);

    public void updateStrategyMap(Move move);

    public void handleUndoMove(Move move);
}
