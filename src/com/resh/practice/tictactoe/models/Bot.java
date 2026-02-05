package com.resh.practice.tictactoe.models;

import com.resh.practice.tictactoe.strategies.BotPlayingStrategy;
import com.resh.practice.tictactoe.strategies.BotPlayingStrategyFactory;

public class Bot extends Player{

    BotDifficultyLevel difficultyLevel;
    BotPlayingStrategy botPlayingStrategy;

    public Bot(int id, Symbol symbol, BotDifficultyLevel difficultyLevel) {
        super("BOT", id, PlayerType.BOT, symbol);
        this.difficultyLevel = difficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(this.difficultyLevel);
    }

    @Override
    public Move makeMove(Board board) {
        Move move =  botPlayingStrategy.makeMoveForBot(board);
        move.setPlayer(this);
        return move;
    }

    public BotDifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(BotDifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
}
