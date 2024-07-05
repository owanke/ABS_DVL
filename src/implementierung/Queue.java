package implementierung;
import schnittstellen.*;

public class Queue implements IQueue
{

    private List liste;
    final static int MAXSIZE = 7;
    
    public Queue()
    {
        liste = new List();
    }
    
    @Override
    public IList getDVL()
    {
        return liste;
    }

    @Override
    public int getSize()
    {
        return liste.length();
    }

    @Override
    public boolean isEmpty()
    {
        return (this.getSize()==0);
    }

    @Override
    public boolean isFull()
    {
        return (this.getSize()>=MAXSIZE);
    }

    @Override
    public int dequeue()
    {
     // if list is empty
        if (getSize()==0)
        {
            return -1;
        }
        
        ListElement position = (ListElement)liste.getHead().getSuccessor();
        liste.deleteFirstOf(position.getValueElement());
        return position.getValueElement().getValue();
    }

    @Override
    public void enqueue(int value)
    {
        if (!isFull() && value>=0)
        {
            liste.insertAtTheEnd(new ValueElement("new", value));
        }
        
    }

    @Override
    public int front()
    {
        if (getSize()==0)
        {
            return -1;
        }
        
        ListElement position = (ListElement)liste.getHead().getSuccessor();
       
        
        return position.getValueElement().getValue();
    }

}
