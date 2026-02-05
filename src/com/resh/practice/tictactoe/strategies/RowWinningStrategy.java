package com.resh.practice.tictactoe.strategies;

import com.resh.practice.tictactoe.models.Board;
import com.resh.practice.tictactoe.models.Move;
import com.resh.practice.tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy {

    // Store the occurrence of each symbol in each of the rows
    Map<Integer, Map<Symbol, Integer>> rowSymbolCount;

    //what rowSymbolCount looks like
    // { 0th row , { X-> 0, O -> 0 } }
    // { 1st row , { X-> 0, O -> 0 } }
    // { 2nd row , { X-> 0, O -> 0 } }

    public RowWinningStrategy() {
        this.rowSymbolCount = new HashMap<>();
    }


    //LOGIC:
    // if any row has a symbol N times, that symbol and corresponding player wins

    @Override
    public boolean checkIfWon(Board board, Move move) {

        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();

        return rowSymbolCount.get(row).get(symbol) == board.getSize();
    }

    @Override
    public void updateStrategyMap(Move move) {

        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!rowSymbolCount.containsKey(row)){
            rowSymbolCount.put(row, new HashMap<>());
        }
        if(!rowSymbolCount.get(row).containsKey(symbol)){
            rowSymbolCount.get(row).put(symbol, 0);
        }

        rowSymbolCount.get(row).put(symbol, rowSymbolCount.get(row).get(symbol) + 1);
    }

    public Map<Integer, Map<Symbol, Integer>> getRowSymbolCount() {
        return rowSymbolCount;
    }

    public void setRowSymbolCount(Map<Integer, Map<Symbol, Integer>> rowSymbolCount) {
        this.rowSymbolCount = rowSymbolCount;
    }
}
