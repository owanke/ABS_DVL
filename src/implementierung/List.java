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
        ListElement position=this.head;
        ListElement posPredecessor=position;
        
        
        int listLength = this.length();
       
        // if Liste leer, hänge neues Element an
        if (listLength == 0)
        {
            this.insertAtTheEnd(value);
            return;
        }
        
        // wenn an letzter Position
        if (pos == listLength+1)
        {
            this.insertAtTheEnd(value);
            return;
        }
        
        // check for null
        if (value == null)
        {
            value = new ValueElement("Default",0);
        }
        
        // check for pos < 1
        if (pos<1)
        {
            pos=1;
        }
        
        // check if pos > length
        if (pos > listLength+1)
        {
            pos = listLength+1;
        }
        
        // circle to pos
        int i;
        for (i=0; i<pos; i++)
        {
            posPredecessor = position;
            position = (ListElement)position.getSuccessor();
            System.out.println("i: " + i);
        }
        
        System.out.println("position: " + i);
        
        
        // create newValue
        ListElement newValue = new ListElement(value);
        newValue.setPredecessor(posPredecessor);
        newValue.setSuccessor(position);
        
        // insert Element
        posPredecessor.setSuccessor(newValue);
        // check if inserted at last position
        if (position != null)
        {
            position.setPredecessor(newValue);
        }
        else
        {
            this.head.setPredecessor(newValue);
        }
        
        
      
     
      
        // if new value is last element set predecessor of head to new value
     
       
        // update Head if pos = 1
        if (pos == 1)
        {
            this.head.setSuccessor(newValue);
        }
    }
    
    private int length()
    {
        ListElement position;
        int length = 1;
        
        // falls leere Liste
        if (this.head.getSuccessor() == null)
        {
            length = 0;
            return length;
        }
        
        
        position = (ListElement)this.head.getSuccessor();
        while (position.getSuccessor() != null)
        {
            position = (ListElement)position.getSuccessor();
            length++;
        }
        return length;
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
