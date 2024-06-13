package implementierung;
import schnittstellen.*;

public class List implements IList
{
    private ListElement head;
    private List list;
    

    public List()
    {
       
    }
    
    @Override
    public IListElement getHead()
    {
        return this.head;
    }

    @Override
    public void insertAtTheEnd(IValueElement value)
    {
        // TODO Auto-generated method stub
        
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
    
}
