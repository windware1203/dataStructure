package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class ControllerLoader
{
    @FXML
    private Button ButtonRead;
    @FXML
    private Label LabelOutput, ErrorMessage,LabelAna,LabelSearch;
    @FXML
    private TextField TextFind;
    @FXML
    private RadioButton SAvg,Sa,SName,SNum;

    private ArrayList<Student> StudentArray= new ArrayList<>();
    private String SortType = "IS", SortBody = "Math";
    private Boolean SortCrease = true;//ture = Increase
    private String AnaType = "Math";
    private String FindType = "Name";
    private Integer StudentNum = 0;
    private Boolean File = false;
    private Integer rank = -1;

    public void init()//Initialization
    {
        getErrorMessage().setVisible(false);
        getErrorMessage().setText("");
    }

    public void setIS()     //Insertion  Sort
    {
        setSortType("IS");
    }
    public void setHS()     //Heap Sort
    {
        setSortType("HS");
    }
    public void setQS()     //Quick Sort
    {
        setSortType("QS");
    }
    public void setSortMath()
    {
        setSortBody("Math");
    }
    public void setSortChi()
    {
        setSortBody("Chi");
    }
    public void setSortName()
    {
        setSortBody("Name");
    }
    public void setSortNum()
    {
        setSortBody("Num");
    }
    public void setSortAvg()
    {
        setSortBody("Avg");
    }

    public void setSortIn()
    {
        setSortCrease(true);
    }
    public void setSortDe()
    {
        setSortCrease(false);
    }

    public void setAnaMath()
    {
        setAnaType("Math");
    }
    public void setAnsChi()
    {
        setAnaType("Chi");
    }
    public void setFindName()
    {
        setFindType("Name");
    }
    public void setFindNum()
    {
        setFindType("Num");
    }

    public void refresh()
    {
        StringBuilder output = new StringBuilder();
        for(Student a:StudentArray)
        {
            output.append(a.StringOutput());
        }
        LabelOutput.setText(output.toString());
    }

    public void readFile()
    {
        int temp = 0;
        StudentArray.clear();
        try
        {
            FileReader fr = new FileReader("src/sample/yyy.txt");
            BufferedReader br = new BufferedReader(fr);
            while (br.ready())
            {
                String line = br.readLine();
                String[] element = line.split(",");
                getStudentArray().add(new Student(   Integer.parseInt(element[0]),element[1],
                                                Integer.parseInt(element[2]),
                                                Integer.parseInt(element[3]) ));
                temp++;
                refresh();
            }
            setStudentNum(temp);
            setFile(true);
            fr.close();
        }
        catch (Exception e)
        {
                  getErrorMessage().setText(e.getMessage());
                  getErrorMessage().setVisible(true);
        }

    }
    public void IS()//insertion Sort
    {
        switch (getSortBody())
        {
            case "Math":
                for(int i =1;i < getStudentNum();i++)
                {
                    Student temp = getStudentArray().get(i);
                    int j = i - 1;
                    while ((temp.getMath() < getStudentArray().get(j).getMath()) && (j >= 0))
                    {
                        getStudentArray().set(j+1, getStudentArray().get(j));
                        j--;
                        if(j<0)break;
                    }
                    getStudentArray().set(j+1,temp);
                }
                break;
            case "Chi":
                for(int i =1;i < getStudentNum();i++)
                {
                    Student temp = getStudentArray().get(i);
                    int j = i - 1;
                    while ((temp.getChinese() < getStudentArray().get(j).getChinese()) && (j >= 0))
                    {
                        getStudentArray().set(j+1, getStudentArray().get(j));
                        j--;
                        if(j<0)break;
                    }
                    getStudentArray().set(j+1,temp);
                }
                break;
            case "Num":
                for(int i =1;i < getStudentNum();i++)
                {
                    Student temp = getStudentArray().get(i);
                    int j = i - 1;
                    while ((temp.getSeatNumber() < getStudentArray().get(j).getSeatNumber()) && (j >= 0))
                    {
                        getStudentArray().set(j+1, getStudentArray().get(j));
                        j--;
                        if(j<0)break;
                    }
                    getStudentArray().set(j+1,temp);
                }
                break;
            case "Name":
                for(int i =1;i < getStudentNum();i++)
                {
                    Student temp = getStudentArray().get(i);
                    int j = i - 1;
                    while ((temp.getName().compareTo(getStudentArray().get(j).getName()) < 0 ) && (j >= 0))
                    {
                        getStudentArray().set(j+1, getStudentArray().get(j));
                        j--;
                        if(j<0)break;
                    }
                    getStudentArray().set(j+1,temp);
                }
                break;
            case "Avg":
                for(int i =1;i < getStudentNum();i++)
                {
                    Student temp = getStudentArray().get(i);
                    int j = i - 1;
                    while ((temp.getAvg() < getStudentArray().get(j).getAvg()) && (j >= 0))
                    {
                        getStudentArray().set(j+1, getStudentArray().get(j));
                        j--;
                        if(j<0)break;
                    }
                    getStudentArray().set(j+1,temp);
                }
                break;
        }
        if(!getSortCrease()) Collections.reverse(getStudentArray());//Increase or Decrease
        refresh();
    }
    public void HS(Boolean sortCrease)
    {//todo

    }
    public void QS(String sortBody,Boolean sortCrease)
    {//todo

    }
    public void Sort()
    {
        if(!getFile())readFile();
        switch (getSortType())
        {
            case "IS":
                IS();
                break;
            case "HS":
                HS(getSortCrease());
                break;
            case "QS":
                QS(getSortBody(),getSortCrease());
                break;
        }
    }
    public void Analyze()
    {
        if(!getFile())readFile();
        ArrayList<Integer> arr = new ArrayList<>();
        switch (getAnaType())
        {
            case "Math":
                for(int i = 0; i < getStudentNum();i++)
                {
                    arr.add(getStudentArray().get(i).getMath());
                }
                break;
            case "Chi":
                for(int i = 0; i < getStudentNum();i++)
                {
                    arr.add(getStudentArray().get(i).getChinese());
                }
                break;
        }
        Collections.sort(arr);
        int min = arr.get(0);
        Collections.reverse(arr);
        int max = arr.get(0);

        //compute avg
        int avg = 0;
        for (int i: arr)
        {
            avg += i;
        }
        avg /= getStudentNum();

        //compute Standard Deviation
        int Sdev = 0;
        for (int i: arr)
        {
            Sdev += Math.pow(i,2) ;
        }
        Sdev /= getStudentNum();

        Sdev -= Math.pow(avg,2);
        final double sqrt = Math.sqrt(Sdev);

        getLabelAna().setText(getAnaType() + "\n" + "Min: " + min + " , " +"Max: " + max + "\n"
        + "Average: " + avg + "\n"
        + "Standard Deviation: \n" + sqrt);
    }
    public void BinFind()
    {
        if(!getFile())readFile();
        /*
        setSortBody("Avg");
        setSortCrease(true);
        getSAvg().setSelected(true);
        getSa().setSelected(true);
        IS();
        */
        Student target = null;
        switch (getFindType())
        {
            case "Name":
                setSortBody("Name");
                setSortCrease(true);
                getSName().setSelected(true);
                getSa().setSelected(true);
                IS();
                try
                {
                    target = FindName(getStudentArray(), getTextFind().getText() ,0,getStudentNum()-1);
                    getLabelSearch().setText(target.StringOutput());
                }
                catch (Exception e)
                {
                    getLabelSearch().setText("NOT FOUND");
                }

                break;
            case "Num":
                setSortBody("Num");
                setSortCrease(true);
                getSNum().setSelected(true);
                getSa().setSelected(true);
                IS();
                try
                {
                    target = FindNum(getStudentArray(), getTextFind().getText() ,0,getStudentNum()-1);
                    getLabelSearch().setText(target.StringOutput());
                }
                catch (Exception e)
                {
                    getLabelSearch().setText("NOT FOUND");
                }

                break;
        }

    }
    public Student FindName(ArrayList<Student> arr,String name,int left,int right)
    {
        if(left > right)return null;

        int mid = (left+right)/2;
        if(arr.get(mid).getName().equals(name))
        {
            return arr.get(mid);
        }
        if(arr.get(left).getName().equals(name))
        {
            return arr.get(left);
        }
        if(arr.get(right).getName().equals(name))
        {
            return arr.get(right);
        }
        else if(arr.get(mid).getName().compareTo(name) < 0)
            return FindName(arr,name,mid+1,right);
        else if(arr.get(mid).getName().compareTo(name) > 0)
            return FindName(arr,name,left,mid-1);

        return null;
    }
    public Student FindNum(ArrayList<Student> arr,String number,Integer left,Integer right)
    {
        Integer num = Integer.parseInt(number);
        if(left > right)return null;

        int mid = (left+right)/2;
        if(arr.get(mid).getSeatNumber().equals(num))
        {
            return arr.get(mid);
        }
        if(arr.get(left).getSeatNumber().equals(num))
        {
            return arr.get(left);
        }
        if(arr.get(right).getSeatNumber().equals(num))
        {
            return arr.get(right);
        }
        else if(arr.get(mid).getSeatNumber().compareTo(num) < 0)
            return FindNum(arr,number,mid+1,right);
        else if(arr.get(mid).getSeatNumber().compareTo(num) > 0)
            return FindNum(arr,number,left,mid-1);
        return null;
    }


    public RadioButton getSName()
    {
        return SName;
    }

    public void setSName(RadioButton SName)
    {
        this.SName = SName;
    }

    public RadioButton getSNum()
    {
        return SNum;
    }

    public void setSNum(RadioButton SNum)
    {
        this.SNum = SNum;
    }

    public Integer getRank()
    {
        return rank;
    }

    public void setRank(Integer rank)
    {
        this.rank = rank;
    }

    public RadioButton getSa()
    {
        return Sa;
    }

    public void setSa(RadioButton sa)
    {
        Sa = sa;
    }

    public RadioButton getSAvg()
    {
        return SAvg;
    }

    public void setSAvg(RadioButton SAvf)
    {
        this.SAvg = SAvf;
    }

    public TextField getTextFind()
    {
        return TextFind;
    }

    public void setTextFind(TextField textFind)
    {
        TextFind = textFind;
    }

    public Integer getStudentNum()
    {
        return StudentNum;
    }

    public void setStudentNum(Integer studentNum)
    {
        StudentNum = studentNum;
    }

    public Button getButtonRead()
    {
        return ButtonRead;
    }

    public void setButtonRead(Button buttonRead)
    {
        ButtonRead = buttonRead;
    }

    public Boolean getFile()
    {
        return File;
    }

    public void setFile(Boolean file)
    {
        File = file;
    }

    public Label getLabelAna()
    {
        return LabelAna;
    }

    public void setLabelAna(Label labelAna)
    {
        LabelAna = labelAna;
    }

    public String getAnaType()
    {
        return AnaType;
    }

    public void setAnaType(String anaType)
    {
        AnaType = anaType;
    }

    public String getFindType()
    {
        return FindType;
    }

    public void setFindType(String findType)
    {
        FindType = findType;
    }

    public Label getLabelSearch()
    {
        return LabelSearch;
    }

    public void setLabelSearch(Label labelSearch)
    {
        LabelSearch = labelSearch;
    }

    public String getSortType()
    {
        return SortType;
    }

    public void setSortType(String sortType)
    {
        SortType = sortType;
    }

    public String getSortBody()
    {
        return SortBody;
    }

    public void setSortBody(String sortBody)
    {
        SortBody = sortBody;
    }

    public Boolean getSortCrease()
    {
        return SortCrease;
    }

    public void setSortCrease(Boolean sortCrease)
    {
        SortCrease = sortCrease;
    }

    public Label getLabelOutput()
    {
        return LabelOutput;
    }

    public void setLabelOutput(Label labelOutput)
    {
        LabelOutput = labelOutput;
    }

    public Label getErrorMessage()
    {
        return ErrorMessage;
    }

    public void setErrorMessage(Label errorMessage)
    {
        ErrorMessage = errorMessage;
    }

    public ArrayList<Student> getStudentArray()
    {
        return StudentArray;
    }

    public void setStudentArray(ArrayList<Student> studentArray)
    {
        StudentArray = studentArray;
    }
}
