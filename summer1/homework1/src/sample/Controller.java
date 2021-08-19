package sample;

import javafx.fxml.*;
import javafx.scene.control.*;
import java.lang.*;


public class Controller
{
    @FXML
    private TextField decimalNumber;
    @FXML
    private Label label_bin, label_oct, label_hex,warning;

    private Integer decimal_value_int;
    private Boolean floatPoint = false,minus = false;
    private Double decimal_Value_double;

    public void init()
    {
        this.decimal_value_int = 0;
        getLabel_bin().setText("0");
        getLabel_oct().setText("0");
        getLabel_hex().setText("0");
    }

    public void callAll()
    {
        getValueOfBinaryNumber();
        getValueOfOctalNumber();
        getValueOfHexNumber();
    }

    public void getValueOfDecimalNumber()
    {
        String numberString = getDecimalNumber().getText();
        boolean errorOrNot = false;
        try
        {
            if(numberString.isEmpty())
                throw new Exception("Empty String!");
            if(numberString.contains("-"))
                setMinus(true);
            if(numberString.contains("."))
            {
                setFloatPoint(true);
                String[] arr = numberString.split("\\.");
                setDecimal_value_int(Integer.parseInt(arr[0]));
                setDecimal_Value_double(Double.parseDouble(numberString));

           }
            else setDecimal_value_int(Integer.parseInt(numberString));
        }
        catch (Exception e)
        {
            errorOrNot = true;
        }
        finally
        {
            getWarning().setVisible(errorOrNot);
            
        }
    }

    public void getValueOfBinaryNumber()
    {
        getValueOfDecimalNumber();
        getLabel_bin().setText((getMinus())?"-"+computeValue(getFloatPoint(),2):computeValue(getFloatPoint(),2));
    }

    public void getValueOfOctalNumber()
    {
        getValueOfDecimalNumber();
        getLabel_oct().setText((getMinus())?"-"+computeValue(getFloatPoint(),8):computeValue(getFloatPoint(),8));
    }

    public void getValueOfHexNumber()
    {
        getValueOfDecimalNumber();
        getLabel_hex().setText((getMinus())?"-"+computeValue(getFloatPoint(),16):computeValue(getFloatPoint(),16));
    }

    public String computeValue(boolean floatPoint,int radix)
    {
        String result = "";
        char[] ch_ref = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        Integer temp_int = getDecimal_value_int();
        StringBuilder stringBuilderInt = new StringBuilder();
        StringBuilder stringBuilderFloat = new StringBuilder();
        double temp_double = getDecimal_Value_double();
        if(floatPoint)
        {
            if (temp_int==0) result += "0";
            else while (temp_int > 0)
            {
                stringBuilderInt.append(ch_ref[temp_int%radix]);
                temp_int /= radix;
            }
            result += stringBuilderInt.reverse().toString();
            result += ".";
            while(temp_double >= 1)
                temp_double--;

            while (temp_double > 0)
            {
                temp_double *= radix;
                stringBuilderFloat.append(ch_ref[(int)temp_double]);
                temp_double -= (int)temp_double;
            }
            result += stringBuilderFloat.toString();
        }
        else
        {
            while (temp_int > 0)
            {
                stringBuilderInt.append(ch_ref[temp_int%radix]);
                temp_int /= radix;
            }
            result = stringBuilderInt.reverse().toString();
        }

        return result;
    }

    public Double getDecimal_Value_double()
    {
        return decimal_Value_double;
    }

    public void setDecimal_Value_double(Double decimal_Value_double)
    {
        this.decimal_Value_double = decimal_Value_double;
    }

    public TextField getDecimalNumber()
    {
        return decimalNumber;
    }

    public Label getLabel_bin()
    {
        return label_bin;
    }

    public Label getLabel_oct()
    {
        return label_oct;
    }

    public Label getLabel_hex()
    {
        return label_hex;
    }

    public Label getWarning()
    {
        return warning;
    }

    public Integer getDecimal_value_int()
    {
        return decimal_value_int;
    }

    public void setDecimal_value_int(Integer decimal_value_int)
    {
        this.decimal_value_int = decimal_value_int;
    }

    public Boolean getFloatPoint()
    {
        return floatPoint;
    }

    public void setFloatPoint(Boolean floatPoint)
    {
        this.floatPoint = floatPoint;
    }

    public Boolean getMinus()
    {
        return minus;
    }

    public void setMinus(Boolean minus)
    {
        this.minus = minus;
    }
}
