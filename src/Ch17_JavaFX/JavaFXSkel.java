package Ch17_JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by Ross on 02.11.2017.
 */
public class JavaFXSkel extends Application {
    public static void main(String[] args) {
        System.out.println("Запуск приложения JavaFX");

        //запустить приложение вызвав метод launch()
        launch(args);
    }

    //Переопределить метод init()
    @Override
    public void init() {
        System.out.println("В теле метода init()");
    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("В теле метода start()");

        //Установить заголовок окна приложения
        primaryStage.setTitle("Каркас приложения JavaFX");

        //создать корневой узел. Используем плавающую компоновку
        FlowPane rootNode = new FlowPane();
        //создаем сцену
        Scene myScene = new Scene(rootNode, 300, 200);

        //установить сцену на платформу
        primaryStage.setScene(myScene);
        //отобразить сцену с платформой
        primaryStage.show();
    }

    @Override
    public void stop() {
        System.out.println("В теле метода stop()");
    }
}
