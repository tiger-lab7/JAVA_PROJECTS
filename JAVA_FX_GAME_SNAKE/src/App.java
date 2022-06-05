import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;

import java.awt.*;

public class App extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }
    private static int WIDTH = 500;
    private static int HEIGTH = 400;

    @Override
    public void start(Stage stage) {


        StackPane stackPane = new StackPane();
        Canvas canvas = new Canvas(WIDTH, HEIGTH);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        canvas.setFocusTraversable(true);
        //canvas.setOnKeyPressed();

        stackPane.getChildren().add(canvas);
        Scene scene = new Scene(stackPane);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Snake");
        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
