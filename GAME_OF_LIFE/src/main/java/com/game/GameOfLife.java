package com.game;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GameOfLife extends Application {
    private Scene scene;
    private Cell[][] cells;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Conway's Game Of Life");
        stage.setHeight(Config.WINDOW_HEIGHT);
        stage.setWidth(Config.WINDOW_WIDTH);
        stage.setResizable(false);
        onCreate();
        stage.setScene(scene);
        stage.show();

        Thread thread = new Thread(() -> {
            while (true) {
                Platform.runLater(action1);
                try {
                    Thread.sleep(Config.DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(action2);
            }
        });
        thread.setDaemon(true);
        thread.start();


    }

    private void onCreate() {
        GridPane gridPane = new GridPane();
        cells = new Cell[Config.COLUMNS][Config.ROWS];
        for (int i = 0; i < Config.COLUMNS; i++) {
            for (int k = 0; k < Config.ROWS; k++) {
                Cell cell = new Cell();
                cells[i][k] = cell;
                gridPane.add(cell, i, k);
            }
        }
        cells[1][4].cellStatus = CellStatus.LIVE;
        cells[6][6].cellStatus = CellStatus.LIVE;
        Group root = new Group(gridPane);
        scene  = new Scene(root);
    }


    private Runnable action1 = () -> {
                for (int i = 0; i < Config.COLUMNS; i++) {
                    for (int k = 0; k < Config.ROWS; k++) {
                        cells[i][k].firstStep();
                    }
                }

    };

    private Runnable action2 = () -> {
        for (int i = 0; i < Config.COLUMNS; i++) {
            for (int k = 0; k < Config.ROWS; k++) {
                cells[i][k].secondStep();
            }
        }
    };

    public static void main(String[] args) {
        Application.launch();
    }
}
