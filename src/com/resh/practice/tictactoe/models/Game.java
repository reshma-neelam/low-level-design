package com.resh.practice.tictactoe.models;

import com.resh.practice.tictactoe.exceptions.DuplicatePlayerSymbol;
import com.resh.practice.tictactoe.exceptions.InvalidMoveException;
import com.resh.practice.tictactoe.exceptions.InvalidNumberOfPlayers;
import com.resh.practice.tictactoe.exceptions.MoreThanOneBotPlayer;
import com.resh.practice.tictactoe.strategies.WinningStrategy;

import java.util.*;

public class Game {

    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private Player winner;
    private GameState gameState;
    private int nextPlayerIndex;
    private List<WinningStrategy> winningStrategies;
    private boolean enableUndo;

    private Game (int dimension, List<Player> players, List<WinningStrategy> winningStrategies, boolean enableUndo) {
        this.players = players;
        this.board = new Board(dimension);
        this.moves = new ArrayList<>();
        this.winningStrategies = winningStrategies;
        this.gameState = GameState.READY;
        this.nextPlayerIndex = 0;
        this.enableUndo = enableUndo;

    }

    public static Builder createBuilder(){
        return new Builder();
    }



    public static class Builder{

        private int dimension;
        private List<Player> players;

        private List<WinningStrategy> winningStrategies;
        private boolean enableUndo;

        private Builder() {
            this.dimension = 0;
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
            this.enableUndo = false;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setEnableUndo(boolean enableUndo) {
            this.enableUndo = enableUndo;
            return this;
        }


            public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder addPlayer(Player player){
            this.players.add(player);
            return this;
        }
        public Builder addWinningStrategy(WinningStrategy winningStrategy){
            this.winningStrategies.add(winningStrategy);
            return this;
        }

        private void validate() throws InvalidNumberOfPlayers, MoreThanOneBotPlayer, DuplicatePlayerSymbol {
            try {
                validateNotMoreThanOneBotPlayer();
                validateNoDuplicatePlayerSymbol();
                validateNumberOfPlayers();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                throw e;
            }

        }

        private void validateNotMoreThanOneBotPlayer() throws MoreThanOneBotPlayer {
            int botCount =0;

            for(Player player : players){
                if(player.getPlayerType() == PlayerType.BOT)
                    botCount++;
            }
            if(botCount >1){
                throw new MoreThanOneBotPlayer("A Game can't have more than one bot player");
            }
        }

        private void validateNoDuplicatePlayerSymbol() throws DuplicatePlayerSymbol {

            Map<Character,Integer> symbolCounts = new HashMap<>();

            for(Player player : players){

                if(!symbolCounts.containsKey(player.getSymbol().getaChar())) {
                    symbolCounts.put(player.getSymbol().getaChar(), 0);
                }

                symbolCounts.put(player.getSymbol().getaChar(), symbolCounts.get(player.getSymbol().getaChar()) + 1);

                if(symbolCounts.get(player.getSymbol().getaChar()) > 1){
                    throw new DuplicatePlayerSymbol("Duplicate Symbols used by Players. Select unique symbols. Symbol 'O' is used by BOT player");
                }
            }


        }

        private void validateNumberOfPlayers() throws InvalidNumberOfPlayers {
            if(players.size() != dimension -1){
                throw new InvalidNumberOfPlayers("Number of players should be BoardSize - 1");
            }
        }

        public Game build(){
            validate();
            return new Game(dimension, players, winningStrategies, enableUndo);

        }
    }

    public GameState getGameState(){
        return gameState;
    }

    public void printBoard() {
        board.printBoard();
    }

    public void startGame(){
        this.gameState = GameState.IN_PROGRESS;
    }

    public boolean isEnableUndo() {
        return enableUndo;
    }

    public void concludeGame(){
        printBoard();
        if(gameState == GameState.CONCLUDED){
            System.out.println("Player " + winner.getName() + " won!");
        } else if (gameState == GameState.DRAW) {
            System.out.println("Draw! Nobody won this round!");
        }
        System.out.println("Game has ended.");
    }

    public void makeMove(){

        // 1. Specify which player's turn it is and show their symbol
        Player currentPlayer = players.get(nextPlayerIndex);


        // 2. Get Move from user and validate
        Move move = currentPlayer.makeMove(board);

        //3. Make the move on the board
        Move actualMove = board.makeMove(move);

        // 4. store the last move made
        moves.add(actualMove);
        updateStrategyMaps(actualMove);

        // 5. Update nextplayer index
        // cyclic moving of index within size of players ex: players 2 so indexes 0 1 0 1 0 1 and so on..
        nextPlayerIndex += 1;
        nextPlayerIndex %= players.size();

    }

    private void updateStrategyMaps(Move move){
        for(WinningStrategy winningStrategy : winningStrategies){
            winningStrategy.updateStrategyMap(move);
        }
    }

    private void removeFromStrategyMaps(Move move){
        for(WinningStrategy winningStrategy : winningStrategies){
            winningStrategy.handleUndoMove(move);
        }
    }

    public void evaluateGame(){

        Move lastMove = moves.getLast();
        if(checkIfWon(lastMove)) {
            gameState = GameState.CONCLUDED;
            winner= lastMove.getPlayer();
            return; //bug: if last move on the board wins, don't check the state for DRAW
        }

        // if number of moves is N*N, this tells us Board is fully filled - no need to check board
        if(moves.size() == (board.getSize() * board.getSize())){
            gameState = GameState.DRAW;
        }
    }

    private boolean checkIfWon(Move move){

        for(WinningStrategy winningStrategy : winningStrategies){
            if(winningStrategy.checkIfWon(board, move))
                return true;
        }

        return false;

    }

    public void undoLastMove(){

        Move lastMove = moves.getLast();

        // 1. undo from the board
        board.undoMove(lastMove);

        // 4. remove the last move affects
        moves.remove(lastMove);
        removeFromStrategyMaps(lastMove);

        // 5. Update nextplayer index
        // cyclic moving of index within size of players ex: players 2 so indexes 0 1 0 1 0 1 and so on..
        nextPlayerIndex -= 1;
        nextPlayerIndex = (nextPlayerIndex + players.size()) % players.size();

    }



}
