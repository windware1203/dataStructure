package sample;

import javafx.application.Application;

import javafx.stage.Stage;

public class Switch{
    public static void switchWindow(Stage window, Application app) {
        try {
            app.start(window);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
