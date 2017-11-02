package Ch17_JavaFX;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Ross on 02.11.2017.
 */
public class JavaFXFileComp extends Application {
    TextField tfFirst;
    TextField tfSecond;

    Button btnComp;

    Label labFirst, labSecond;
    Label labResult;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Compare Files");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 180, 180);
        primaryStage.setScene(myScene);

        tfFirst = new TextField();
        tfSecond = new TextField();
        tfFirst.setPrefColumnCount(12);
        tfSecond.setPrefColumnCount(12);
        tfFirst.setPromptText("Enter file name");
        tfSecond.setPromptText("Enter file name");

        btnComp = new Button("Compare");

        labFirst = new Label("First file: ");
        labSecond = new Label("Second file: ");
        labResult = new Label("");

        tfFirst.setOnAction((e) -> btnComp.fire());
        tfSecond.setOnAction((e) -> btnComp.fire());

        btnComp.setOnAction((ae) -> {
            int i = 0, j = 0;
            if (tfFirst.getText().equals("")) {
                labResult.setText("First file name missing.");
                return;
            }
            if (tfSecond.getText().equals("")) {
                labResult.setText("Second file name missing.");
                return;
            }

            try (FileInputStream f1 = new FileInputStream(tfFirst.getText());
                 FileInputStream f2 = new FileInputStream(tfSecond.getText())) {
                do {
                    i = f1.read();
                    j = f2.read();
                    if (i != j) break;
                } while (i != -1 && j != -1);

                if (i != j) {
                    labResult.setText("Files are not the same.");
                } else
                    labResult.setText("Files compare equal");
            } catch (IOException exc) {
                labResult.setText("File Error");
            }

        });

        rootNode.getChildren().addAll(labFirst, tfFirst, labSecond, tfSecond, btnComp, labResult);
        primaryStage.show();
    }
}
