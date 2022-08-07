package org.academiadecodigo.cunnilinux.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {
    private int row;
    private int col;

    Rectangle rectangle;
    private boolean painted;
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setPainted(boolean painted) {
        this.painted = painted;
    }

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        rectangle = new Rectangle(col * Grid.cellSize , row * Grid.cellSize , Grid.cellSize,Grid.cellSize);
        rectangle.draw();
    }

    public boolean isPainted() {
        return painted;
    }

    @Override
    public String toString() {
        return painted ? "1" : "0";
    }
}


