package simplegraphics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import simplegraphics.grid.Cell;
import simplegraphics.grid.Cursor;
import simplegraphics.grid.Grid;

public class Controller implements KeyboardHandler {

    Grid grid;
    Cursor cursor;

    public Controller() {
        this.grid = new Grid();
        initKeyboard();
    }

    public void initKeyboard() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(space);

        KeyboardEvent spaceR = new KeyboardEvent();
        spaceR.setKey(KeyboardEvent.KEY_SPACE);
        spaceR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(spaceR);

        KeyboardEvent delete = new KeyboardEvent();
        delete.setKey(KeyboardEvent.KEY_D);
        delete.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(delete);

        KeyboardEvent save = new KeyboardEvent();
        save.setKey(KeyboardEvent.KEY_S);
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(save);

        KeyboardEvent load = new KeyboardEvent();
        load.setKey(KeyboardEvent.KEY_L);
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(load);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                grid.cursorOperations(Directions.RIGHT);
                break;
            case KeyboardEvent.KEY_LEFT:
                grid.cursorOperations(Directions.LEFT);
                break;
            case KeyboardEvent.KEY_DOWN:
                grid.cursorOperations(Directions.DOWN);
                break;
            case KeyboardEvent.KEY_UP:
                grid.cursorOperations(Directions.UP);
                break;
            case KeyboardEvent.KEY_SPACE:
                grid.setPainting(true);
                grid.paintCell();
                break;
            case KeyboardEvent.KEY_D:
                grid.eraseGrid();
                break;
            case KeyboardEvent.KEY_S:
                grid.saveToFile();
                break;
            case KeyboardEvent.KEY_L:
                grid.readFromFile();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        grid.setPainting(false);
    }
}
