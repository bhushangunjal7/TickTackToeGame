package org.example.models;

import java.util.Scanner;

public class Player {
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    private Long id;

    public Player(Long id, String name, PlayerType playerType, Symbol symbol) {
        this.id = id;
        this.name = name;
        this.playerType = playerType;
        this.symbol = symbol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
    public Move makeMove(Board board){
       //ask player to provide index to provide m0ve

        Scanner sc=new Scanner(System.in);
        System.out.println("Please tell the row index to make a move");
       int rowNumber=sc.nextInt();
        System.out.println("Please tell the col index to make a move");
        int colNumber=sc.nextInt();
        return new Move(new Cell(rowNumber,colNumber), this);
    }
}
