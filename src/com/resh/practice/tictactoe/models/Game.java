package com.resh.practice.tictactoe.models;

import com.resh.practice.tictactoe.exceptions.DuplicatePlayerSymbol;
import com.resh.practice.tictactoe.exceptions.InvalidMoveException;
import com.resh.practice.tictactoe.exceptions.InvalidNumberOfPlayers;
import com.resh.practice.tictactoe.exceptions.MoreThanOneBotPlayer;
import com.resh.practice.tictactoe.strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private Player winner;
    private GameState gameState;
    private int nextPlayerIndex;
    private List<WinningStrategy> winningStrategies;

    private Game (int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.players = players;
        this.board = new Board(dimension);
        this.moves = new ArrayList<>();
        this.winningStrategies = winningStrategies;
        this.gameState = GameState.READY;
        this.nextPlayerIndex = 0;

    }

    public static Builder createBuilder(){
        return new Builder();
    }



    public static class Builder{

        private int dimension;
        private List<Player> players;

        private List<WinningStrategy> winningStrategies;

        private Builder() {
            this.dimension = 0;
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
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
                    throw new DuplicatePlayerSymbol("Duplicate Symbols used by Players. Select unique symbols");
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
            return new Game(dimension, players, winningStrategies);

        }
    }

    public GameState getGameState(){
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void printBoard() {
        board.printBoard();
    }

    public void makeMove(){
        Player currentPlayer = players.get(nextPlayerIndex);
        System.out.println("It is " + currentPlayer.getName() + "'s turn. Your Symbol is " + currentPlayer.getSymbol().getaChar());

        Move move = currentPlayer.makeMove();
        move.validateUserMove();
        board.makeMove(move);

        //set nextplayer index logic
        //nextPlayerIndex++;


    }

}
