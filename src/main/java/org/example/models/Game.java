package org.example.models;

import org.example.exception.GameInvalidationException;
import org.example.strategies.winningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private GameState gameState;
    private Player winner;
    private int nextMovePlayerIndex;
    private List<Move> moves;
    private  List<WinningStrategy> winningStrategies;



    private Game(int dimension, List<Player> players,List<WinningStrategy> winningStrategies ){
        this.board=new Board(dimension);
        this.gameState=GameState.IN_PROGRESS;
        this.nextMovePlayerIndex=-0;
        this.moves=new ArrayList<>();
        this.winningStrategies=winningStrategies;
        this.players=players;

    }

    //Builder Design pattern




    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public List<Move> getMove() {
        return moves;
    }

    public void setMove(List<Move> move) {
        this.moves = move;
    }

    public int getNextMovePlayerIndex() {
        return nextMovePlayerIndex;
    }

    public void setNextMovePlayerIndex(int nextMovePlayerIndex) {
        this.nextMovePlayerIndex = nextMovePlayerIndex;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }



    public void printBoard() {
           board.displayBoard();
    }

    public void undo() {

    }

    private boolean validateMove(Move move){
        int row= move.getCell().getRow();
        int col=move.getCell().getCol();
        
        if(row >= board.getDimension() && row<0 && col>=getBoard().getDimension() && col<0 && !board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY)){
            return false;
        }
        return true;
        
    }



    private  boolean checkWinner(Board board,Move move){
        for(WinningStrategy winningStrategy:winningStrategies){
            if(winningStrategy.checkWinner(move,board)){
                return true;
            }
        }
        return false;
    }



    public void makeMove() {
        //
        Player currentPlayer= players.get(nextMovePlayerIndex);
        System.out.println("It is "+ currentPlayer.getName()+" 's move.");
        Move move= currentPlayer.makeMove(this.board);
        System.out.println(currentPlayer.getName() + " has made a move at Row "+ move.getCell().getRow()+
                ", col: "+ move.getCell().getCol());


        if(!validateMove(move)){
            System.out.println("Invalid move by player: " + currentPlayer.getName());
            return;
            
        }
        int row= move.getCell().getRow();
        int col=move.getCell().getCol();
        Cell finalCellTOMakeMove=board.getBoard().get(row).get(col);
        finalCellTOMakeMove.setCellState(CellState.FILLED);
        finalCellTOMakeMove.setPlayer(currentPlayer);
        
        Move finalMove=new Move(finalCellTOMakeMove,currentPlayer);
        moves.add(finalMove);

        nextMovePlayerIndex +=1;
        nextMovePlayerIndex %=players.size();
        //once player made the move check if player win or draw
        //check winner method

        if(checkWinner(board, finalMove)){
            gameState=GameState.ENDED;
            winner=currentPlayer;

        }else if(moves.size()==board.getDimension()*board.getDimension())
          gameState=GameState.DRAW;
    }

    //Builder

    public static Builder getBuilder(){
        return new Builder();
    }


    public static class Builder{

        private int dimension;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

//        private Builder(){
//            this.players=new ArrayList<>();
//            this.winningStrategies=new ArrayList<>();
//            this.dimension=0;
//        }

        private boolean validate(){
            //Validations   TODo
            //1.only one bot is allowed
            //2.no 2 players should have same symbol
            return true;
        }
        public Game build() throws Exception{
            if(!validate()){
                throw new GameInvalidationException("Invalid Game");
            }
            return new Game(dimension,players,winningStrategies);
        }
    }



}
