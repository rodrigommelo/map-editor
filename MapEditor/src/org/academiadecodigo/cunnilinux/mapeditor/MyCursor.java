package org.academiadecodigo.cunnilinux.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class MyCursor {
    private int col;
    private int row;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = this.row+row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = this.col+col;
    }

    Rectangle cursor=new Rectangle(Grid.cellSize,Grid.cellSize,Grid.cellSize,Grid.cellSize);
    public MyCursor(int col,int row){
        this.col=col;
        this.row=row;
    }


}
