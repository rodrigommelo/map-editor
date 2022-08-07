package org.academiadecodigo.cunnilinux.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    public static int cellSize = 10;
    public static int cols = 50;
    private int rows =50;
    private Rectangle gameArea;
    public Rectangle getGameArea() {
        return gameArea;
    }



    MyCursor myCursor=new MyCursor(cellSize,cellSize);



    public Grid() {
        gridOfSquares();
      keySetup();
      myCursor.cursor.setColor(Color.BLUE);
      myCursor.cursor.fill();

    }

    public void init() {
        this.gameArea = new Rectangle(cellSize,cellSize, cols * cellSize , rows * cellSize);
        gameArea.setColor(Color.BLACK);
        this.gameArea.draw();

    }







Cell[][] positions=new Cell[cols+1][rows+1];

    public void gridOfSquares() {
        for (int i = 1; i <rows+1 ; i++) {


            for (int j = 1; j < cols+1 ; j++) {

                positions[i][j] =new Cell(i,j);
                positions[i][j].rectangle.draw();

            }


        }
    }
public void keySetup() {

    Keyboard keyboard1 = new Keyboard(new keyboardHandler(this));


    KeyboardEvent moveRight = new KeyboardEvent();
    moveRight.setKey(KeyboardEvent.KEY_RIGHT);
    moveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
    keyboard1.addEventListener(moveRight);


    KeyboardEvent moveLeft = new KeyboardEvent();
    moveLeft.setKey(KeyboardEvent.KEY_LEFT);
    moveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
    keyboard1.addEventListener(moveLeft);


    KeyboardEvent moveDown = new KeyboardEvent();
    moveDown.setKey(KeyboardEvent.KEY_DOWN);
    moveDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
    keyboard1.addEventListener(moveDown);


    KeyboardEvent moveUp = new KeyboardEvent();
    moveUp.setKey(KeyboardEvent.KEY_UP);
    moveUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
    keyboard1.addEventListener(moveUp);


    KeyboardEvent paint = new KeyboardEvent();
    paint.setKey(KeyboardEvent.KEY_SPACE);
    paint.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
    keyboard1.addEventListener(paint);


    KeyboardEvent clear = new KeyboardEvent();
    clear.setKey(KeyboardEvent.KEY_C);
    clear.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
    keyboard1.addEventListener(clear);


    KeyboardEvent save = new KeyboardEvent();
    save.setKey(KeyboardEvent.KEY_S);
    save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
    keyboard1.addEventListener(save);


    KeyboardEvent load = new KeyboardEvent();
    load.setKey(KeyboardEvent.KEY_L);
    load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
    keyboard1.addEventListener(load);





}

    @Override
    public String toString() {

        StringBuilder strBuilder = new StringBuilder();
        for (int row = 1; row < rows+1; row++) {
            for (int col = 1; col < cols+1; col++) {
                strBuilder.append(positions[row][col]);
            }
            strBuilder.append("\n");
        }

        return strBuilder.toString();

    }
    public void stringToGrid(String grid) {

        int index = 0 ;

        for (int row = 1; row < rows+1; row++) {
            for (int col = 1; col < cols+1; col++) {

                Cell cell = positions[row][col];

                if (grid.charAt(index) == '0') {
                    cell.rectangle.draw();
                    cell.setPainted(false);
                } else {
                    cell.rectangle.fill();
                    cell.setPainted(true);
                }

                index++;
            }
            index++; // skip "\n" on each line
        }

    }
















}
