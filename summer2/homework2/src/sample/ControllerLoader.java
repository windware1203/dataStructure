package sample;

import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class ControllerLoader
{
    @FXML
    private Pane login;
    @FXML
    private TextField text_name;
    @FXML
    private Label label_easy, label_advanced,error_mes;
    @FXML
    private RadioButton box_easy,box_advanced;
    @FXML
    private Button submit;

    @FXML
    private Pane gaming;
    @FXML
    private Label label_name,label_level,label_hint,lable_level_description;
    @FXML
    private TextField answer;

    private Boolean isError = true;
    private String name = "";
    private Boolean level;

    public void click_easy()
    {
        getLabel_easy().setUnderline(true);
        getLabel_easy().setTextFill(Color.RED);
        getLabel_advanced().setUnderline(false);
        getLabel_advanced().setTextFill(Color.BLACK);
        setError(false);
        setLevel(false);
    }

    public void click_advanced()
    {
        getLabel_advanced().setUnderline(true);
        getLabel_advanced().setTextFill(Color.RED);
        getLabel_easy().setUnderline(false);
        getLabel_easy().setTextFill(Color.BLACK);
        setError(false);
        setLevel(true);
    }

    public void submit_name()
    {
        try
        {
            setName(getText_name().getText());
            getLabel_name().setText(getName());
            getLabel_level().setText(level?"Advanced":"Easy");
            getLable_level_description().setText(level?"0~9+A`Z non case-sensitive":"0-9 merely");
        }
        catch (Exception e)
        {
            setError(false);
        }

        setError(name.length() <= 0);

        if(!isError)
        {
            getLogin().setVisible(false);
            getGaming().setVisible(true);
        }
        else
            getError_mes().setVisible(true);

    }

    public Pane getLogin()
    {
        return login;
    }

    public Label getLabel_hint()
    {
        return label_hint;
    }

    public Label getLable_level_description()
    {
        return lable_level_description;
    }

    public TextField getAnswer()
    {
        return answer;
    }

    public Label getLabel_name()
    {
        return label_name;
    }

    public Pane getGaming()
    {
        return gaming;
    }



    public Label getError_mes()
    {
        return error_mes;
    }


    public void setLevel(Boolean level)
    {
        this.level = level;
    }

    public Label getLabel_level()
    {
        return label_level;
    }

    public Boolean getError()
    {
        return isError;
    }

    public Boolean getLevel()
    {
        return level;
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
