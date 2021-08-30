package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Gaming extends Application
{
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("Gaming.fxml"));

        primaryStage.setTitle("Homework 2");
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();
    }

}