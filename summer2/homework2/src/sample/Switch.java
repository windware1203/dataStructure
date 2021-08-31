package sample;

import javafx.application.Application;

import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Switch{
    public static void switchWindow(Stage window, Application app) {
        try {
            app.start(window);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
