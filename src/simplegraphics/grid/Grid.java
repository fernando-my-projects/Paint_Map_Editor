package simplegraphics.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import simplegraphics.Directions;
import simplegraphics.Values;

import java.io.*;

import static simplegraphics.Values.*;

public class Grid {

    private int rows = ROWS;
    private int cols = COLS;
    private Cell[][] cells;
    Cursor cursor;
    private boolean painting;

    public Grid() {
        createGrid();
        drawMenu();
        this.cursor = new Cursor();
    }

    public void createGrid() {
        cells = new Cell[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    public void eraseGrid() {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                cells[i][j].eraseCell();
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void cursorOperations(Directions directions) {
        switch (directions) {
            case RIGHT:
                cursor.moveRight();
                break;
            case LEFT:
                cursor.moveLeft();
                break;
            case DOWN:
                cursor.moveDown();
                break;
            case UP:
                cursor.moveUp();
                break;
        }
        if (painting) {
            paintCell();
        }
    }

    public void paintCell() {
        Cell cell = getCell(cursor.getX(), cursor.getY());
        if (cell.isPainted()) {
            cell.eraseCell();
        } else {
            cell.paint();
        }
    }

    public void setPainting(boolean painting) {
        this.painting = painting;
    }

    public void saveToFile() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILEPATH));
            for (int i = 0; i < cols; i++) {
                for (int j = 0; j < rows; j++) {
                    if (cells[i][j].isPainted()) {
                        bufferedWriter.write("1\n");
                        continue;
                    }
                    bufferedWriter.write("0\n");
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Message: "+e.getMessage());
        }
    }

    public void readFromFile() {
        String result = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FILEPATH));
            for(int i=0; i<cols; i++){
                for(int j=0; j<rows; j++){
                    result = bufferedReader.readLine();
                    if(result.equals("1")){
                        cells[i][j].setPainted(true);
                        cells[i][j].paint();
                    }
                    cells[i][j].setPainted(false);
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Message: "+e.getMessage());
        } catch (IOException ex) {
            System.out.println("Message: "+ex.getMessage());
        }
    }

    public void drawMenu(){
        Rectangle rectangleMenu = new Rectangle(PADDING, PADDING*2 + ROWS* CELL_SIZE, COLS*CELL_SIZE, PADDING*9);
        rectangleMenu.setColor(Color.LIGHT_GRAY);
        rectangleMenu.fill();
        Text space = new Text(PADDING*2, PADDING*3+ROWS*CELL_SIZE, "SPACE BAR -> paint and delete");
        Text right = new Text(PADDING*2, PADDING*4+ROWS*CELL_SIZE+space.getHeight(), "RIGHT ARROW -> move right");
        Text left = new Text(PADDING*2, PADDING*5+ROWS*CELL_SIZE+right.getHeight()*2, "LEFT ARROW -> move left");
        Text down = new Text(PADDING*3+right.getWidth(), PADDING*4+ROWS*CELL_SIZE+space.getHeight(), "DOWN ARROW -> move down");
        Text up = new Text(PADDING*3+left.getWidth(), PADDING*5+ROWS*CELL_SIZE+right.getHeight()*2, "UP ARROW -> move up");
        space.draw();
        right.draw();
        left.draw();
        down.draw();
        up.draw();
    }


}
