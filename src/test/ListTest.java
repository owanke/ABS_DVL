package test;
import implementierung.*;


public class ListTest
{

    public static void main(String[] args)
    {
        List liste=new List();
        
        liste.insertAtTheEnd(new ValueElement("1",1));
        liste.insertAtTheEnd(new ValueElement("2",2));

        liste.reverse();
       

        
        System.out.println(liste.toString());
       

    }

}
