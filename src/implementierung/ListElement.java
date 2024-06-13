package implementierung;
import schnittstellen.*;


public class ListElement implements IListElement
{
    private IValueElement valueElement;
    private IListElement predecessor;
    private IListElement successor;
    
    public ListElement(IValueElement element)
    {
        this.valueElement = element;
    }
    
  

    public IValueElement getValueElement()
    {
        // todo: darf nicht null sein
        return this.valueElement;
    }


    public void setValueElement(IValueElement value)
    {
        this.valueElement = value;
        
    }

  
    public IListElement getPredecessor()
    {
      
        return this.predecessor;
    }

 
    public void setPredecessor(IListElement predecessor)
    {
        this.predecessor = predecessor;
        
    }

   
    public IListElement getSuccessor()
    {
       
        return this.successor;
    }

   
    public void setSuccessor(IListElement successor)
    {
        this.successor = successor;
        
    }
}
