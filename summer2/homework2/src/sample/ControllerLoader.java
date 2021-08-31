package sample;

import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ControllerLoader
{
    @FXML
    private TextField text_name;
    @FXML
    private Label label_easy, label_advanced,error_mes;
    @FXML
    private RadioButton box_easy,box_advanced;
    @FXML
    private Button submit;

    private Boolean isError = true;
    private String name = "";

    public void click_easy()
    {
        getLabel_easy().setUnderline(true);
        getLabel_easy().setTextFill(Color.RED);
        getLabel_advanced().setUnderline(false);
        getLabel_advanced().setTextFill(Color.BLACK);
        isError = false;
    }

    public void click_advanced()
    {
        getLabel_advanced().setUnderline(true);
        getLabel_advanced().setTextFill(Color.RED);
        getLabel_easy().setUnderline(false);
        getLabel_easy().setTextFill(Color.BLACK);
        isError = false;
    }

    public void submit_name()
    {
        try
        {
            setName(getText_name().getText());
        }
        catch (Exception e)
        {
            setError(false);
        }


        if(getError())
            getError_mes().setVisible(true);
        else
            Switch.switchWindow((Stage) submit.getScene().getWindow(), new Gaming(getName()));
    }

    public Label getError_mes()
    {
        return error_mes;
    }

    public void setError_mes(Label error_mes)
    {
        this.error_mes = error_mes;
    }

    public Boolean getError()
    {
        return isError;
    }

    public void setError(Boolean error)
    {
        isError = error;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Label getLabel_easy()
    {
        return label_easy;
    }

    public TextField getText_name()
    {
        return text_name;
    }

    public void setText_name(TextField text_name)
    {
        this.text_name = text_name;
    }

    public void setLabel_easy(Label label_easy)
    {
        this.label_easy = label_easy;
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

    public Button getSubmit()
    {
        return submit;
    }

    public void setSubmit(Button submit)
    {
        this.submit = submit;
    }

    public Label getLabel_advanced()
    {
        return label_advanced;
    }

}
