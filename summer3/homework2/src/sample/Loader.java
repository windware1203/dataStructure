package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Loader extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {

        Parent root = FXMLLoader.load(getClass().getResource("loader.fxml"));

        primaryStage.setTitle("Homework 3");
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();

    }


    public static void main(String[] args)
    {
        launch(args);
    }
}
