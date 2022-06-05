package com.game;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends Pane {
    public CellStatus cellStatus;
    private final Rectangle rectangle;

    public Cell() {
        this.setWidth(Config.CELL_SIZE);
        this.setHeight(Config.CELL_SIZE);
        this.setStyle("-fx-background-color: red;");
        cellStatus = CellStatus.NONE;
        rectangle = new Rectangle(Config.CELL_SIZE,Config.CELL_SIZE, Config.getColor(cellStatus));
        this.getChildren().add(rectangle);
    }
    public void firstStep() {
        //cellStatus = cellStatus.firstStep(4);
        //rectangle.setFill(Config.getColor(cellStatus));
        this.getChildren().removeAll();
        Rectangle rectangle = new Rectangle(Config.CELL_SIZE,Config.CELL_SIZE, Color.YELLOW);
        this.getChildren().add(rectangle);
    }
    public void secondStep() {
        //cellStatus = cellStatus.secondStep();
        //rectangle.setFill(Config.getColor(cellStatus));
        this.getChildren().removeAll();
        Rectangle rectangle = new Rectangle(Config.CELL_SIZE,Config.CELL_SIZE, Color.BLACK);
        this.getChildren().add(rectangle);
    }
}
