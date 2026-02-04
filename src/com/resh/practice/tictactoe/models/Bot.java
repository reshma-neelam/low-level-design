package com.resh.practice.tictactoe.models;

public class Bot extends Player{

    BotDifficultyLevel difficultyLevel;

    public Bot(int id, Symbol symbol, BotDifficultyLevel difficultyLevel) {
        super("BOT", id, PlayerType.BOT, symbol);
        this.difficultyLevel = difficultyLevel;
    }

    public BotDifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(BotDifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
}
