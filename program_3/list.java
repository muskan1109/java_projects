public class list 
{
    /**************************************************************************/
    // Public
    /**************************************************************************/

    /**************************************************************************/
    // Constructors
    /**************************************************************************/ 
    
    // constructor with no parameter    
    public list()
    { 
        this(new String("List")); 
    }

    // constructor with one parameter
    public list(String list_name) 
    { 
        // empty list 
        // therefore setting both nodes to null
        first_node = last_node = null; 

        name = list_name; 
    }

    /**************************************************************************/
    // Methods
    /**************************************************************************/ 

    // method to insert Object at front of list 
    public void insert_at_front(Object new_data)
    {
        // checking if list is empty
        if(first_node == null)
        {
            // creating and setting first and last node to the same instance
            first_node = last_node = new list_node(new_data, null);
        }
        else 
        {
            // creating new node and setting next node as current first_node 
            list_node new_first_node = new list_node(new_data, first_node);

            // setting first_node as the newly created node 
            first_node = new_first_node;
        }
    }

    // method to insert Object at back of list
    public void insert_at_back(Object new_data)
    {
        // checking if list is empty
        if(first_node == null)
        {
            // creating and setting first and last node to the same instance
            first_node = last_node = new list_node(new_data, null);
        }
        else 
        {
            // creating new node 
            list_node new_last_node = new list_node(new_data, null);

            // setting next node of current last_node as new last_node 
            last_node.next = new_last_node;

            // setting last_node to the newly created last_node
            last_node = new_last_node;
        }
    }

    // method to remove Object from front of list 
    public Object remove_from_front() 
    {   
        // checking if list is empty
        if(first_node == null)
        {
            return null;
        }
        
        // extracting the first_node data
        Object removed_data = first_node.data;
        
        // if one node only in list, then setting first and last node as null
        if(first_node == last_node)  
        {
            first_node = last_node = null;
        }
        else 
        {
            // if more than one node in list, setting first_node to the current 
            // element for next node 
            first_node = first_node.next;
        }

        return removed_data;
    }

    // method to remove Object from back of list 
    public Object remove_from_back() 
    {   
        // checking if list is empty
        if(first_node == null) 
        {
            return null;
        }
        
        // extracting the last_node data
        Object removed_data = last_node.data;
        
        // if one node only in list, then setting first and last node as null
        if(first_node == last_node)  
        {
            first_node = last_node = null;
        }  
        else 
        {
            // if more than one node in list, setting first_node to the current 
            list_node current = first_node;
            
            // traverse through the list just before the last node
            while(current.next != last_node)
            {
                current = current.next;
            }

            // setting last node as the current node, which was the node before 
            // last and setting it's next to null
            last_node = current;
            current.next = null;
        }
        
        return removed_data;
    
    }

    // allowing one to get a “handle” to navigate through the list in a loop
    public list_node get_first() 
    {
        return first_node;
    }
    
    @Override
    public String toString () 
    { 
        // print list content to string
        String output = new String();
        list_node current = first_node;
        
        //output = name + ":\n"; 
        output = name;
        
        while(current != null) 
        {
            output += " " + current.data;
            current = current.next;
        }
        
        return output;
    }

    /**************************************************************************/
    // Fields
    /**************************************************************************/

    // first_node holds the first node
    public list_node first_node;

    // last_node holds the last node
    public list_node last_node;


    /**************************************************************************/
    // Protected
    /**************************************************************************/

    /**************************************************************************/
    // Fields
    /**************************************************************************/

    // name holds list name
    protected String name;

} 
