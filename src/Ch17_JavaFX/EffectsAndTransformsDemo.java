package Ch17_JavaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.FlowPane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

/**
 * Created by Ross on 02.11.2017.
 */
public class EffectsAndTransformsDemo extends Application {
    double angle = 0.0;
    double scaleFactor = 0.4;
    double blurVal = 1.0;
    //создадим начальные объекты преобразований и эффектов
    Reflection reflection = new Reflection();
    BoxBlur blur = new BoxBlur(1.0, 1.0, 1);
    Rotate rotate = new Rotate();
    Scale scale = new Scale(scaleFactor, scaleFactor);

    Button btnRotate = new Button("Rotate");
    Button btnBlur = new Button("Blur off");
    Button btnScale = new Button("Scale");

    Label reflect = new Label("Reflection adds Visual Sparkle");

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Effects and Transforms");
        FlowPane rootNode = new FlowPane(20, 20);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 300, 120);
        primaryStage.setScene(myScene);

        btnRotate.getTransforms().add(rotate);
        btnScale.getTransforms().add(scale);

        reflection.setTopOpacity(0.7);
        reflection.setBottomOpacity(0.3);
        reflect.setEffect(reflection);//отражение для метки

        btnRotate.setOnAction((ae) -> {
            //при каждом нажатии кнопки она поворачивается
            //на 30 градусов вокруг центра
            angle += 15.0;
            rotate.setAngle(angle);
            rotate.setPivotX(btnRotate.getWidth() / 2);
            rotate.setPivotY(btnRotate.getHeight() / 2);
        });

        btnScale.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //при каждом нажатии кнопка меняет свой размер
                scaleFactor += 0.1;
                if (scaleFactor > 2.0) scaleFactor = 0.4;

                scale.setX(scaleFactor);
                scale.setY(scaleFactor);
            }
        });

        btnBlur.setOnAction((ae) -> {
            //изменяет степень размытия кнопки
            if (blurVal == 10.0) {
                blurVal = 1.0;
                btnBlur.setEffect(null);
                btnBlur.setText("Blur off");
            } else {
                blurVal++;
                btnBlur.setEffect(blur);
                btnBlur.setText("Blur on");
            }
            blur.setWidth(blurVal);
            blur.setHeight(blurVal);
        });

        rootNode.getChildren().addAll(btnRotate, btnScale, btnBlur, reflect);
        primaryStage.show();
    }
}
