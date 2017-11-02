package Ch17_JavaFX;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by Ross on 02.11.2017.
 */
public class ListViewDemo extends Application {
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ListView Demo");
        FlowPane rootNode = new FlowPane(10, 10);
        //центрируем элементы управления на сцене
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 200, 120);
        primaryStage.setScene(myScene);
        response = new Label("Selected Computer Type");
        ObservableList<String> computerTypes =
                FXCollections.observableArrayList("Smartphone",
                "Tablet", "Notebook", "Desktop");
        //создаем список
        ListView<String> lvComputers = new ListView<>(computerTypes);
        //задаем предпочтительное значение высоты и ширины
        lvComputers.setPrefSize(100,70);
        //получаем модель выбора для списка
        MultipleSelectionModel<String> lvSelModel = lvComputers.getSelectionModel();

        lvSelModel.selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                response.setText("Computer selected is " + newValue);
            }
        });
        //добавляем компонентны на сцену
        rootNode.getChildren().addAll(lvComputers,response);
        primaryStage.show();
    }
}
