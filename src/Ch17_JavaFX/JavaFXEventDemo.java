package Ch17_JavaFX;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by Ross on 02.11.2017.
 */
public class JavaFXEventDemo extends Application {
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Use JavaFX Buttons and Events");
        FlowPane rootNode = new FlowPane(10, 10);
        //Центрируем элементы управления на сцене
        rootNode.setAlignment(Pos.CENTER);

        //создать сцену
        Scene myScene = new Scene(rootNode, 300, 100);
        //создать метку
        response = new Label("Push a Button");
        Button btnUp = new Button("Run");
        Button btnDown = new Button("Exit");


        //обработка событий для кнопки Up анонимным классом
        btnUp.setOnAction((event) -> response.setText("You pressed Run."));
        //лямбда выражение
        btnDown.setOnAction((event) -> Platform.exit());

        rootNode.getChildren().addAll(btnUp, btnDown, response);
        //установить сцену на платформе
        primaryStage.setScene(myScene);
        primaryStage.show();

    }
}
