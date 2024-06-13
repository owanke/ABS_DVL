package helper;

public class Validator
{
    public static String validString(String theStringToCheck)
    {
        String validString = theStringToCheck;
        if (theStringToCheck == null)
        {
            validString = "Darf nicht null sein.";
        }
        return validString;
    }

}
