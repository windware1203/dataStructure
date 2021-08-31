package sample;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ControllerGaming
{
    @FXML
    private Label label_topic;

    public Label getLabel_topic()
    {
        return label_topic;
    }

    public void setLabel_topic(Label label_topic)
    {
        this.label_topic = label_topic;
    }

    public ControllerGaming() { }
}
