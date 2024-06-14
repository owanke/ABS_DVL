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
            this.predecessor = this;
            this.successor = this;
        }
        else
        {
            this.valueElement = new ValueElement("Defalut", 0);
            this.predecessor = this;
            this.successor = this;
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
        if (this.predecessor == null)
        {
            return this;
        }
        else
        {
            return this.predecessor;
        }
    }

 
    public void setPredecessor(IListElement predecessor)
    {
        if (predecessor == null)
        {
            this.predecessor = this;
        }
        else
        {
            this.predecessor = predecessor;
        }
        
    }

   
    public IListElement getSuccessor()
    {
      
        return this.successor;
    }

   
    public void setSuccessor(IListElement successor)
    {
        if (successor != null)
        {
            this.successor = successor;
        }
    }

}
