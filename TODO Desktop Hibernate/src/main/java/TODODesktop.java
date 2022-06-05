import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.function.Supplier;


public class TODODesktop extends Application {

    private DBConnect dbConnect = DBConnect.getInstance();
    //private DAOHibernate dbConnect = new DAOHibernate();

    private Supplier<String> getDBEntry = () -> {
        StringBuilder dbEntry = new StringBuilder();
        dbConnect.getAllTasks().forEach(task -> {
            dbEntry.append(task.toString()).append("\n");
        });
        return dbEntry.toString();
    };

    public TODODesktop() throws SQLException {
    }


    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Using basic primaryStage, that received by arg
        primaryStage.setTitle("TODO List");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(500);
        primaryStage.setResizable(false); // Disable resize actions for the main window

        Text text = new Text(getDBEntry.get());
        text.setLayoutY(80);
        text.setLayoutX(100);
        text.setFont(Font.font("Tahoma", 21));
        text.setFontSmoothingType(FontSmoothingType.LCD);
        text.setFill(Paint.valueOf("blue"));

        TextField textField = new TextField();
        textField.setPrefColumnCount(50);
        textField.setOnKeyPressed(event -> { // Enter pressed in TextField handling
            if (event.getCode().equals(KeyCode.ENTER)
            ) {
                dbConnect.executeSql(textField.getText());
                text.setText(getDBEntry.get());
            }
        });

        Button clearButton = new Button("Clear");
        clearButton.setOnAction(event -> {
            textField.clear();
        });

        Button button = new Button("Execute SQL");
        //button.setAlignment(Pos.CENTER);
        button.setOnAction(event -> {
            dbConnect.executeSql(textField.getText());
            text.setText(getDBEntry.get());
        });

        // Первый параметр - простр-во между элементами
        HBox hBox = new HBox(15, clearButton, textField, button);
        hBox.setLayoutX(30);
        hBox.setLayoutY(30);

        //FlowPane flowPane = new FlowPane(Orientation.HORIZONTAL, 800, 20, textField, button);
        FlowPane flowPane2 = new FlowPane(Orientation.VERTICAL, 15, 15, text);
        flowPane2.setLayoutX(200);
        flowPane2.setLayoutY(110);

        Group primaryGroup = new Group(hBox, flowPane2); // Объединение в группу, поскольку
        Scene primaryScene = new Scene(primaryGroup);// Сцена принимает только 1 аргумент node
        primaryScene.setFill(Paint.valueOf("lightgray"));
        primaryStage.setScene(primaryScene);
        primaryStage.show(); // show должен быть в конце. когда все компоненты окна готовы

        Alert closeWindowAlert = new Alert(Alert.AlertType.CONFIRMATION);
        closeWindowAlert.setContentText("Really close?");

        // Посредством метода primaryStage.setOnCloseRequest обрабатывается закрытие окна приложения
        primaryStage.setOnCloseRequest(event -> {
            closeWindowAlert.showAndWait().ifPresent((btnType) -> {
                if (btnType == ButtonType.CANCEL) primaryStage.show();
                else dbConnect.closeConnection();
            });

        });
    }
}
