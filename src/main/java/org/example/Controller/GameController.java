package org.example.Controller;

import org.example.models.Game;
import org.example.models.GameState;
import org.example.models.Player;
import org.example.strategies.winningStrategy.WinningStrategy;

import java.util.List;

public class GameController {

    public Game startGame(int boardDimension, List<Player> players,
                          List<WinningStrategy> winningStrategies) throws Exception {
        return Game.getBuilder()
                .setDimension(boardDimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public void displayBoard(Game game){
        game.printBoard();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }
    public void undo(Game game){
        game.undo();
    }
    public GameState getGameState(Game game){
        return game.getGameState();
    }
}
