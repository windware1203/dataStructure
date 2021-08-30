package sample;

import javafx.fxml.*;
import javafx.scene.control.*;
import java.lang.*;


public class Controller
{
    @FXML
    private TextField text_name;
    @FXML
    private Label label_easy, label_advanced;
    @FXML
    private RadioButton box_easy,box_advanced;



    public TextField getText_name()
    {
        return text_name;
    }

    public void setText_name(TextField text_name)
    {
        this.text_name = text_name;
    }

    public Label getLabel_easy()
    {
        return label_easy;
    }

    public void setLabel_easy(Label label_easy)
    {
        this.label_easy = label_easy;
    }

    public Label getLabel_advanced()
    {
        return label_advanced;
    }

    public void setLabel_advanced(Label label_advanced)
    {
        this.label_advanced = label_advanced;
    }

    public RadioButton getBox_easy()
    {
        return box_easy;
    }

    public void setBox_easy(RadioButton box_easy)
    {
        this.box_easy = box_easy;
    }

    public RadioButton getBox_advanced()
    {
        return box_advanced;
    }

    public void setBox_advanced(RadioButton box_advanced)
    {
        this.box_advanced = box_advanced;
    }
}
