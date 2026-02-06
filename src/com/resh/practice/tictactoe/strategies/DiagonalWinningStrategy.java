package com.resh.practice.tictactoe.strategies;

import com.resh.practice.tictactoe.models.Board;
import com.resh.practice.tictactoe.models.Move;
import com.resh.practice.tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy {

    // Store the occurrence of each symbol in each of the diagonals
    // Two diagonals - primary and secondary
    //The main (primary) diagonal is where i == j,
    // and the anti (secondary) diagonal is where i + j == n - 1.

    Map<Symbol, Integer> diagSymbolCount;
    Map<Symbol, Integer> antiDiagSymbolCount;

    //what diagSymbolCount looks like
    //  { X-> 0, O -> 0 }


    public DiagonalWinningStrategy() {
        this.diagSymbolCount = new HashMap<>();
        this.antiDiagSymbolCount = new HashMap<>();
    }
    @Override
    public boolean checkIfWon(Board board, Move move) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();

        return diagSymbolCount.getOrDefault(symbol,0) == board.getSize() ||
                antiDiagSymbolCount.getOrDefault(symbol,0) == board.getSize();
    }

    private void updateMap(Map<Symbol,Integer> map, Symbol symbol) {
        if(!map.containsKey(symbol)) {
            map.put(symbol, 0);
        }
        map.put(symbol, map.get(symbol) + 1);
    }

    private void removeFromMap(Map<Symbol,Integer> map, Symbol symbol) {
        if(map.containsKey(symbol)) {
            map.put(symbol, map.get(symbol) - 1);
        }

    }

    @Override
    public void updateStrategyMap(Move move) {

            int row = move.getCell().getRow();
            int col = move.getCell().getCol();
            Symbol symbol = move.getPlayer().getSymbol();

            // primary diagonal
            if(row == col ){
                updateMap(diagSymbolCount, symbol);
            }

            //secondary diagonal
            if(row + col == move.getBoard().getSize()-1) {
                updateMap(antiDiagSymbolCount, symbol);
            }

            //NOTE: for center cell, both ifs will be true hence it will be updated in both maps


    }

    @Override
    public void handleUndoMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        // primary diagonal
        if(row == col ){
            removeFromMap(diagSymbolCount, symbol);
        }

        //secondary diagonal
        if(row + col == move.getBoard().getSize()-1) {
            removeFromMap(antiDiagSymbolCount, symbol);
        }

    }
}
