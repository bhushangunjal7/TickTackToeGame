package org.example.models;

public class Cell {

    private int row;
    private int col;
    private Player player;
    private CellState cellState;

    public Cell(int col, int row) {
        this.cellState = CellState.EMPTY;
        this.col = col;

        this.row = row;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
