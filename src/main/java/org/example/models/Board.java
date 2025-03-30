package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int dimension;
    private List<List<Cell>> board;

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public Board(int n) {
        this.dimension = n;
        board=new ArrayList<>();//Rows

        for(int i=0;i<n;i++){
            board.add(new ArrayList<>());  //Cols

            for(int j=0;j<n;j++){
                board.get(i).add(new Cell(i,j));
            }
        }
    }
    public void printBoard(){

    }

    public void displayBoard() {
        for(int i = 0; i < dimension; i++) {
            for(int j = 0; j < dimension; j++) {
                Cell cell = board.get(i).get(j);
                if(cell.getCellState().equals(CellState.EMPTY)) {
                    System.out.print("|  |");
                } else {
                    System.out.print("|" + cell.getPlayer().getSymbol().getSymbol() + "|");
                }
            }
            System.out.println();
        }
    }
}
