package com.resh.practice.tictactoe.strategies;

import com.resh.practice.tictactoe.models.Board;
import com.resh.practice.tictactoe.models.Bot;
import com.resh.practice.tictactoe.models.Move;

public interface BotPlayingStrategy {

    public Move makeMoveForBot(Board board);

}
