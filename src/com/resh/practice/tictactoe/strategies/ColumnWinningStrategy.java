package com.resh.practice.tictactoe.strategies;

import com.resh.practice.tictactoe.models.Board;
import com.resh.practice.tictactoe.models.Move;
import com.resh.practice.tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy {

    // Store the occurrence of each symbol in each of the columns
    Map<Integer, Map<Symbol, Integer>> colSymbolCount;

    public ColumnWinningStrategy() {
        this.colSymbolCount = new HashMap<>();
    }

    @Override
    public boolean checkIfWon(Board board, Move move) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        return colSymbolCount.get(col).get(symbol) == board.getSize();
    }

    @Override
    public void updateStrategyMap(Move move) {

        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!colSymbolCount.containsKey(col)){
            colSymbolCount.put(col, new HashMap<>());
        }
        if(!colSymbolCount.get(col).containsKey(symbol)){
            colSymbolCount.get(col).put(symbol, 0);
        }

        colSymbolCount.get(col).put(symbol, colSymbolCount.get(col).get(symbol) + 1);
    }


}
