package Ch17_JavaFX;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by Ross on 02.11.2017.
 */
public class TextFieldDemo extends Application {

    TextField tf;
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Demonstrate a TextField");
        FlowPane rootNode= new FlowPane(10,10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene= new Scene(rootNode,230,140);
        primaryStage.setScene(myScene);
        response = new Label("Enter Name: ");
        Button btnGetText = new Button("Get Name");
        tf = new TextField();
        //задать подсказку
        tf.setPromptText("Enter a name.");
        //задать предпочтительное значение столбцов
        tf.setPrefColumnCount(15);
        tf.setOnAction((ae)->response.setText("Enter pressed. Name is: " + tf.getText()));
        btnGetText.setOnAction((ae)->response.setText("Button pressed. Name is: " + tf.getText()));

        //Используем разделитель для лучшей организации вывода
        Separator separator = new Separator();
        separator.setPrefWidth(180);
        rootNode.getChildren().addAll(tf,btnGetText,separator,response);
        primaryStage.show();
    }
}
