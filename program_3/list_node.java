public class list_node 
{
    /**************************************************************************/
    // Constructors
    /**************************************************************************/

    // constructor with no parameters (hence default values for fields) 
    public list_node() 
    {
        data = null;
        next = null;
    }

    // constructor with two parameters parameters
    public list_node(Object new_data, list_node new_next) 
    {
        data = new_data;
        next = new_next;
    }   

    /**************************************************************************/
    // Fields
    /**************************************************************************/
    
    // data holds reference to the data of the current node 
    public Object data; 

    // list_node holds reference to the next node in the linked list 
    public list_node next;   
}    

