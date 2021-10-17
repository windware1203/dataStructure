package sample;

public class Student
{
    private Integer Math,Chinese,Avg,SeatNumber = -1,Rank;
    private String Name = "";

    public Student(Integer seatNumber, String name,Integer math, Integer chinese)
    {
        setMath(math);
        setChinese(chinese);
        setSeatNumber(seatNumber);
        setName(name);
        setAvg((math+chinese)/2);
    }
    public String StringOutput()
    {
        return  getSeatNumber().toString() + ",\t\t\t" + getName() + ",\t\t" + getMath().toString() + ",\t\t" + getChinese().toString() + "\t\t" +getAvg().toString() +"\t\n";
    }

    public Integer getRank()
    {
        return Rank;
    }

    public void setRank(Integer rank)
    {
        Rank = rank;
    }

    public Integer getAvg()
    {
        return Avg;
    }

    public void setAvg(Integer avg)
    {
        Avg = avg;
    }

    public Integer getMath()
    {
        return Math;
    }

    public void setMath(Integer math)
    {
        Math = math;
    }

    public Integer getChinese()
    {
        return Chinese;
    }

    public void setChinese(Integer chinese)
    {
        Chinese = chinese;
    }

    public Integer getSeatNumber()
    {
        return SeatNumber;
    }

    public void setSeatNumber(Integer seatNumber)
    {
        SeatNumber = seatNumber;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        Name = name;
    }

}
