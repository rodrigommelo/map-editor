package org.academiadecodigo.cunnilinux.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.IOException;

public class keyboardHandler implements KeyboardHandler {

    Grid grid;




    public keyboardHandler(Grid grid) {
        this.grid = grid;
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                if(grid.myCursor.cursor.getX()<grid.getGameArea().getWidth()) {

                    grid.myCursor.setCol(10);


                grid.myCursor.cursor.translate(Grid.cellSize,0);
                   }


                break;
            case KeyboardEvent.KEY_LEFT:
                if(grid.myCursor.cursor.getX()>grid.getGameArea().getX()){
                    grid.myCursor.setCol(-10);

                grid.myCursor.cursor.translate(-Grid.cellSize,0);
                    }

                break;

            case KeyboardEvent.KEY_DOWN:
                if(grid.myCursor.cursor.getY()<grid.getGameArea().getHeight()){
                    grid.myCursor.setRow(10);

                grid.myCursor.cursor.translate(0,Grid.cellSize);
                    }

                break;


            case KeyboardEvent.KEY_UP:
                if(grid.myCursor.cursor.getY()>grid.getGameArea().getY()){
                    grid.myCursor.setRow(-10);

                grid.myCursor.cursor.translate(0,-Grid.cellSize);
                   }

                break;

            case KeyboardEvent.KEY_SPACE:
                grid.positions[(grid.myCursor.getRow())/Grid.cellSize][(grid.myCursor.getCol())/Grid.cellSize].rectangle.fill();
                grid.positions[(grid.myCursor.getRow())/Grid.cellSize][(grid.myCursor.getCol())/Grid.cellSize].setPainted(true);


                System.out.println(grid.positions[(grid.myCursor.getRow())/Grid.cellSize][(grid.myCursor.getCol())/Grid.cellSize].toString());


                break;

            case KeyboardEvent.KEY_C:
                for (int i = 1; i <grid.positions.length ; i++) {


                    for (int j = 1; j < grid.positions[i].length ; j++) {

                       grid.positions[i][j].rectangle.draw();
                       grid.positions[i][j].setPainted(false);

                    }


                }



                break;

            case KeyboardEvent.KEY_S:
                try {
                    FileManager.saver(grid.toString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


                break;

            case KeyboardEvent.KEY_L:
                try {
                   grid.stringToGrid(FileManager.load());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                break;




                }

        }



    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
