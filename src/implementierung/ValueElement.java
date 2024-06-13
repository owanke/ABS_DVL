package implementierung;
import schnittstellen.*;
import helper.*;


public class ValueElement implements IValueElement
{
    private String name;
    private int value;
    
    public ValueElement(String name, int value)
    {
        this.name=Validator.validString(name);
        this.value=value;
    }
    
    public void setName(String name)
    {
        this.name=Validator.validString(name);
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setValue(int value)
    {
        this.value=value;
    }
    
    public int getValue()
    {
        return this.value;
    }
    
    public String toString()
    {
        return "Name: " + this.name + " value: " + this.value;
    }
    
//    private String validString(String theStringToCheck)
//    {
//        String validString = theStringToCheck;
//        if (theStringToCheck == null)
//        {
//            validString = "Darf nicht null sein.";
//        }
//        return validString;
//    }
    
}
