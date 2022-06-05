package com.game;

import javafx.scene.paint.Color;

public class Config {
    static double WINDOW_HEIGHT = 400.;
    static double WINDOW_WIDTH = 800.;
    static double CELL_SIZE = 10.;
    static int COLUMNS = (int) (WINDOW_WIDTH / CELL_SIZE);
    static int ROWS = (int) (WINDOW_HEIGHT / CELL_SIZE);
    static int DELAY = 1000;

    public static Color getColor(CellStatus cellStatus) {
        return switch(cellStatus) {
            case NONE -> Color.BLACK;
            case LIVE -> Color.CORAL;
            case BORN -> Color.AQUA;
            case DEAD -> Color.DARKGRAY;
        };
    }
}
