package simplegraphics.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import simplegraphics.Values;

public class Cursor extends Cell{
    public Cursor() {
        super(0,0);
        rectangle.setColor(Color.CYAN);
        paint();
    }

    public void moveRight(){
        if(getX()< Values.COLS-1){
            x++;
            rectangle.translate(Values.CELL_SIZE, 0);
        }
    }

    public void moveLeft(){
        if(getX()>0){
            x--;
            rectangle.translate(-Values.CELL_SIZE,0);
        }
    }

    public void moveDown(){
        if(getY()<Values.ROWS-1){
            y++;
            rectangle.translate(0, Values.CELL_SIZE);
        }
    }

    public void moveUp(){
        if(getY()>0){
            y--;
            rectangle.translate(0, -Values.CELL_SIZE);
        }
    }
}
