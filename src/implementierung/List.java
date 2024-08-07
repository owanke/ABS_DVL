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
        }
  
        
        
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
        else  // if new value is last element set predecessor of head to new value
        {
            this.head.setPredecessor(newValue);
        }
        

        // update Head if pos = 1
        if (pos == 1)
        {
            this.head.setSuccessor(newValue);
        }
    }
    
   
    public int length()
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
        int listLength = this.length();
        if ((pos == 0) || (pos < 0))
        {
            return null;
        }
        
        if (pos <= listLength)
        {
            return getListElementAt(pos).getValueElement();
        }
        else
        {
            return null;
        }
        
        
    }

    private IListElement getListElementAt(int pos)
    {
        ListElement position=this.head;
        ListElement posPredecessor=position;
        
        
        int listLength = this.length();

        
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
        }
        
        
        return position;
    }
    
    @Override
    public int getFirstPosOf(IValueElement value)
    {
        int listLength = this.length();
        ListElement position = (ListElement) this.head.getSuccessor();
        ListElement posPredecessor = position;

        if (value == null)
        {
            return -1;
        }
        
        // find first pos of

        // default bei keiner Übereinstimmung ist -1
        int firstPos = -1;
        for (int i = 1; i <= listLength; i++)
        {
            if (valueStimmtUeberein(position.getValueElement(), value)) // falls
                                                                        // das
                                                                        // ValueElement
                                                                        // vorkommt
            {
                firstPos = i;
                break;
            }
            posPredecessor = position;
            position = (ListElement) position.getSuccessor();

        }

        return firstPos;
    }
    
    private boolean valueStimmtUeberein(IValueElement value1, IValueElement value2)
    {
        boolean stimmtUeberein=false;
        
        if (value1.getName() == value2.getName())
        {
            stimmtUeberein = true;
        }
        System.out.println("" + value1.toString() + " stimmt überein mit " + value2.toString() + ": " + stimmtUeberein);
        return stimmtUeberein;
    }

    @Override
    public void deleteFirstOf(IValueElement value)
    {
        int listLength = this.length();
        
        // find element position
        int pos = -1;
        if (value != null)
        {
            pos = this.getFirstPosOf(value);
        }
        
        if (pos >=1)
        {
         // get element at that position
            ListElement position=(ListElement)this.getListElementAt(pos);
            System.out.println("deleteFirstOf Item: " + position.getValueElement().toString());
            // reconnect predecessor and successor
            ListElement predecessor = (ListElement)position.getPredecessor();
            ListElement successor = (ListElement)position.getSuccessor();
            predecessor.setSuccessor(successor);
            if (successor != null)
            {
                successor.setPredecessor(predecessor);
            }
            else
            {
                predecessor.setSuccessor(null);
            }
            
            
            // if deleted last object, adjust head predecessor, and successor
            if (pos == listLength)
            {
                this.head.setPredecessor(position.getPredecessor());

            }
            
        }
        if (this.length() == 0)
        {
            this.head.setPredecessor(null);
        }
       
    }

    @Override
    public void deleteAllOf(IValueElement value)
    {
        // as long as there are value elements in the list, deleteFirstOf value
        while (value != null && (this.getFirstPosOf(value) != -1))
        {
            this.deleteFirstOf(value);
        }
        
    }

    @Override
    public boolean member(IValueElement value)
    {
        
        return (this.getFirstPosOf(value) != -1);
    }

    @Override
    public void reverse()
    {
       
        ListElement position = (ListElement)this.head.getSuccessor();
        int listLength = this.length();
        
        // check if Liste leer
        if (listLength == 0)
        {
            return;
        }
        
        // fix head predecessor
        this.head.setPredecessor(position);
        
        
        // reverse connections for each element
        for (int i=1; i<=listLength;i++)
        {
            swapConnections(position);
            if (position.getPredecessor()!=null)
            {
                position = (ListElement)position.getPredecessor();
            }
        }
        
        // fix head successor
        this.head.setSuccessor(position);
        
        // fix first element predecessor
        this.head.getSuccessor().setPredecessor(this.head);
        
        // fix new last element
        head.getPredecessor().setSuccessor(null);
       
        
        
    }
    
    private void swapConnections(ListElement position)
    {
        ListElement holder;
        holder = (ListElement)position.getSuccessor();
        position.setSuccessor(position.getPredecessor());
        position.setPredecessor(holder);

    }
    
   
    
    public String toString()
    {
        ListElement position;
        String printString="";
        
        position = (ListElement)this.head.getSuccessor();
        System.out.println("Head: " + position.getValueElement().getName());
        int listLength = this.length();
        
        for (int i = 1; i<listLength;i++)
        {
            printString= printString + "i= " + i + " Name: " + this.getElementAt(i).getName();
        }
        
        return printString;
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
