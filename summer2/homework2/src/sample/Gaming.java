package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Gaming extends Application
{
    private String name = "";

    public Gaming(String name)
    {
        this.name = name;
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("Gaming.fxml"));

        primaryStage.setTitle(" Hi player: " + name);
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();
    }

}