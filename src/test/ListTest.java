package test;
import implementierung.*;


public class ListTest
{

    public static void main(String[] args)
    {
        List liste=new List();
        
        liste.insertAtTheEnd(new ValueElement("ElemToDelete",4711));
        liste.deleteFirstOf(new ValueElement("ElemToDelete", 4711));
        
        System.out.println("Stop");
       

    }

}
