package simplegraphics.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import simplegraphics.Values;

public class Cell {

    public int x;
    public int y;
    public Rectangle rectangle;
    private int width = Values.CELL_SIZE;
    private int height = Values.CELL_SIZE;
    private boolean painted;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        rectangle = new Rectangle(x*width+Values.PADDING, y*height+Values.PADDING, width, height);
        rectangle.draw();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isPainted() {
        return painted;
    }

    public void setPainted(boolean painted) {
        this.painted = painted;
    }

    public void paint(){
        painted = true;
        rectangle.fill();
    }

    public void eraseCell(){
        painted = false;
        rectangle.setColor(Color.BLACK);
        rectangle.draw();
    }

}
