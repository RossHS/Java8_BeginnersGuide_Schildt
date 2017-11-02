package Ch17_JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by Ross on 02.11.2017.
 */
public class JavaFXLabelDemo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Use a JavaKX label.");
        FlowPane rootNode = new FlowPane();
        Scene myScene = new Scene(rootNode, 300, 200);
        primaryStage.setScene(myScene);
        Label myLabel = new Label("JavaFX is a powerful GUI");
        //добавить метку в граф сцены
        rootNode.getChildren().add(myLabel);

        primaryStage.show();
    }
}
