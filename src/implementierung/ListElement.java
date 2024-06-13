package implementierung;
import helper.Validator;
import schnittstellen.*;


public class ListElement implements IListElement
{
    private IValueElement valueElement;
    private IListElement predecessor;
    private IListElement successor;
    
    public ListElement(IValueElement element)
    {
        if (element != null)
        {
            this.valueElement = element;
        }
        else
        {
            this.valueElement = new ValueElement("Defalut", 0);
        }
    }
    
  

    public IValueElement getValueElement()
    {
        
        return this.valueElement;
      
    }


    public void setValueElement(IValueElement value)
    {
        if (value != null)
        {
            this.valueElement = value;
        }
        
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
