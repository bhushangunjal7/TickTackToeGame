package org.example;

import org.example.Controller.GameController;
import org.example.models.*;
import org.example.strategies.EasyBotPlayingStatergy;
import org.example.strategies.winningStrategy.ColumnWinningStratergy;
import org.example.strategies.winningStrategy.DiagonalWinningStratergy;
import org.example.strategies.winningStrategy.RowWinningStratergy;
import org.example.strategies.winningStrategy.WinningStrategy;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to tick tack toe Game.....");
        System.out.println("Welcome to Bhushans Games....");
        GameController gameController=new GameController();


        int dimension=3;
        int nummberOfPlayers=dimension-1;
        List<Player> players=new ArrayList<>();
        players.add(
                new Player(1L,"Bhushan",PlayerType.HUMAN,new Symbol('*')
                ));
        players.add(
                new Bot(2L ,"BotPlayer",PlayerType.BOT,new Symbol('0'),BotDifficultyLevel.EASY,
                        new EasyBotPlayingStatergy()
                ));

        List<WinningStrategy> winningStrategies=new ArrayList<>();
        winningStrategies.add(new RowWinningStratergy());
        winningStrategies.add(new ColumnWinningStratergy());
        winningStrategies.add(new DiagonalWinningStratergy());

        //Start game
        Game game= gameController.startGame(dimension,players,winningStrategies);

        while (gameController.getGameState(game).equals(GameState.IN_PROGRESS)){
            System.out.println("This is current state of board....");
            gameController.displayBoard(game);

            gameController.makeMove(game);

        }
        if(gameController.getGameState(game).equals(GameState.ENDED)){
           gameController.displayBoard(game);
            System.out.println("Winner is " +gameController.getWinner(game).getName());
        }else {
            System.out.println("Game is Drawn...");
        }

    }
}