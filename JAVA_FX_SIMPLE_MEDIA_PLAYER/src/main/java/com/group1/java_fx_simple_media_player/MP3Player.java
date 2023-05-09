package com.group1.java_fx_simple_media_player;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MP3Player extends Application {
    MediaPlayer mediaPlayer;

    Label label = new Label("No file selected");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button openButton = new Button("Open");
        openButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                String filePath = file.getAbsolutePath();
                label.setText(filePath);
                Media media = new Media(new File(filePath).toURI().toString());
                mediaPlayer = new MediaPlayer(media);
                mediaPlayer.play();
            }
        });

        Button pauseButton = new Button("Pause");
        pauseButton.setOnAction(event -> {
            mediaPlayer.pause();
        });

        Button resumeButton = new Button("Resume");
        resumeButton.setOnAction(event -> {
            mediaPlayer.play();
        });

        Button stopButton = new Button("Stop");
        stopButton.setOnAction(event -> {
            mediaPlayer.stop();
        });

        Slider volumeSlider = new Slider(0, 100, 50);

        volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                mediaPlayer.setVolume((Double) new_val / 100);
            }
        });

       /* Button setVolume =  new Button("Set");
        setVolume.setOnAction(event -> {
            mediaPlayer.setVolume(volumeSlider.getValue() / 100);
        });*/

        BorderPane borderPane = new BorderPane();
        HBox buttons = new HBox(openButton, pauseButton, resumeButton, stopButton, volumeSlider);
        borderPane.setTop(buttons);
        borderPane.setCenter(label);
        BorderPane.setAlignment(label, Pos.CENTER);

        Scene scene = new Scene(borderPane, 650, 200);
        stage.setScene(scene);
        stage.setTitle("MP3 Player");
        stage.show();
    }

}
