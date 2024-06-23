package test;
import implementierung.*;


public class ListTest
{

    public static void main(String[] args)
    {
        List liste=new List();
        liste.insertAtTheEnd(new ValueElement("Value 1",1));
        liste.insertAtTheEnd(new ValueElement("Value 2",2));
        liste.insertAtPos(3334343, new ValueElement("inserted Value",3));
       

    }

}
