package Ch17_JavaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by Ross on 02.11.2017.
 */
public class CheckboxDemo extends Application {

    CheckBox cbSmartphone;
    CheckBox cbTablet;
    CheckBox cbNotebook;
    CheckBox cbDesktop;

    Label response;
    Label selected;

    String computers;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Demonstrate Check Boxes");

        FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 230, 200);
        primaryStage.setScene(myScene);
        Label heading = new Label("What Computers Do You Own?");
        response = new Label("");
        selected = new Label("");
        cbSmartphone = new CheckBox("Smartphone");
        cbSmartphone.setAllowIndeterminate(true);
        cbTablet = new CheckBox("Tablet");
        cbNotebook = new CheckBox("Notebook");
        cbDesktop = new CheckBox("Desktop");

        rootNode.getChildren().addAll(heading, cbSmartphone, cbTablet,
                cbNotebook, cbDesktop, response, selected);
        primaryStage.show();

        //обработка событий для флажков
        cbSmartphone.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (cbSmartphone.isIndeterminate())
                    response.setText("Smartphone state is indeterminate");
                else if (cbSmartphone.isSelected())
                    response.setText("Smartphone was just selected");
                else
                    response.setText("Smartphone was just cleared");

                showAll();
            }
        });
        cbTablet.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (cbTablet.isSelected())
                    response.setText("Tablet was just selected");
                else
                    response.setText("Tablet was just cleared");

                showAll();
            }
        });
        cbNotebook.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (cbNotebook.isSelected())
                    response.setText("Notebook was just selected");
                else
                    response.setText("Notebook was just cleared");

                showAll();
            }
        });
        cbDesktop.setOnAction((event) -> {
            if (cbSmartphone.isSelected())
                response.setText("Desktop was just selected");
            else
                response.setText("Desktop was just cleared");

            showAll();
        });
    }

    void showAll() {
        computers = "";
        if (cbSmartphone.isSelected()) computers += "Smartphone ";
        if (cbTablet.isSelected()) computers += "Tablet ";
        if (cbNotebook.isSelected()) computers += "Notebook ";
        if (cbDesktop.isSelected()) computers += "Desktop ";
        selected.setText("Computers selected: " + computers);
    }
}
