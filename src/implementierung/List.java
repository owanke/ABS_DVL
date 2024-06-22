package implementierung;
import schnittstellen.*;

public class List implements IList
{
    private ListElement head;
    

    public List()
    {
        this.head = new ListElement(new ValueElement("Dummy (Kopf)",0));  
    }
    
    @Override
    public IListElement getHead()
    {
        return this.head;
    }

    @Override
    public void insertAtTheEnd(IValueElement value)
    {
        ListElement newValue = new ListElement(validValue(value));
        
        // case: Liste leer
        // head.pre: null
        // head.succc: null
        
        // Ziel: head.pre = newValue
        //       head.succ = new Value
        if (this.head.getPredecessor() == null)
        {
            this.head.setSuccessor(newValue);
            this.head.setPredecessor(newValue);
            newValue.setPredecessor(this.head);
            newValue.setSuccessor(null);
            
        }
        else
        {
            // durchlaufe Elemente von head bis successor null ist. Das ist
            // dann die letze Position
            ListElement position=this.head;
            ListElement nextPosition=null;
            
            while (position.getSuccessor() !=null)
            {
                nextPosition = (ListElement)position.getSuccessor();
                position = nextPosition;
            }
        
            
            // hänge newValue an die letzte Position als Successor
            position.setSuccessor(newValue);
            newValue.setPredecessor(position);
            this.head.setPredecessor(newValue);
        }
        
        
        
        
       
    }

    @Override
    public void insertAtPos(int pos, IValueElement value)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public IValueElement getElementAt(int pos)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getFirstPosOf(IValueElement value)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void deleteFirstOf(IValueElement value)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAllOf(IValueElement value)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean member(IValueElement value)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void reverse()
    {
        // TODO Auto-generated method stub
        
    }
    
    public String toString()
    {
        return "toDo";
    }
    
    private IValueElement validValue(IValueElement valueToCheck)
    {
        IValueElement validatedValue = valueToCheck;
        if (validatedValue == null)
        {
            validatedValue = new ValueElement("Default",0);
        }
        return validatedValue;
    }
    
}
