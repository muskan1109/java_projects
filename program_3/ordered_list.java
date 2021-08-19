public abstract class ordered_list extends list
{
	/**************************************************************************/
    // Public
    /**************************************************************************/

	/**************************************************************************/
    // Constructors
    /**************************************************************************/

	// constructor with no parameters
    public ordered_list() 
	{
		// calling delegated constructor with one parameter
		this("Ordered list");
	}

	// constructor with one parameter 	
	public ordered_list(String list_name) 
	{
		// calling constructor from superclass with one parameter 
		super(list_name);

		// num_of_nodes set to 0 as list is empty in the beginning
		this.num_of_nodes = 0;
	}

	/**************************************************************************/
    // Methods
    /**************************************************************************/
	
	// method to compare two objects
	// set as abstract as comparisons will be different for different Objects
	protected abstract int compare(Object obj_1, Object obj_2);
	
	// find the list node which contain the object data
	public list_node find(Object data) 
    {
		// setting current_node to beginning of list 
		list_node current_node = first_node;

		// traverse through list until end of list is not reached and data is 
		// less than data in current_node 
		while(current_node != null && compare(current_node.data, data) < 0) 
		{
			current_node = current_node.next;
		}
		
		// checking if current_node is null (hence end of list) OR current_node 
		// data is is greater than data
		if(current_node == null || compare(current_node.data, data) > 0)
		{
			return null;
		}
		else
		{
			return current_node;
		}
	}
	
	// method to find Object using binary search
	public list_node binary_find(Object data)
	{
		// thinking of list as an array but not converting to an array
		// left is equal to 0
		long left = 0;
		
		// right is equal to 1 less than the num_of_nodes
		long right = num_of_nodes - 1;
		
		// while left is less than or equal to right then continue the search
		while(left <= right)
		{
			// calculate new mid value
			long mid = (right + left)/2;
			
			// set the mid_node to first_node always
			list_node mid_node = first_node;

			// go up to the specified mid point
			for(long i = 0; i < mid; i++)
			{
				mid_node = mid_node.next;
			}

			// if data is equal to mid_node data then return mid_node
			if(compare(mid_node.data, data) == 0)
			{
				return mid_node;
			}
			else if(compare(mid_node.data, data) < 0) 
			{
				// if data is less than mid_node data then update left 
				left = mid + 1;
			}
			else
			{
				// if data is greater than mid_node data then update right
				right = mid - 1;
			}
		}

		// if data is not found then return null
		return null;
	}
	
	//  new_data into the list at appropriate position
	public boolean insert(Object new_data) 
    {
		// if new_data already exists return null
		if(binary_find(new_data) != null)
		{
			return false;
		}

		// if list is empty call insert_at_front() from superclass
		if(first_node == null)
		{
			super.insert_at_front(new_data);
		}
		else if(compare(first_node.data, new_data) > 0) // if new data is less than first_node data
		{
			super.insert_at_front(new_data);
		}
		else if(compare(last_node.data, new_data) < 0) // if new data is greater than last_node data
		{
			super.insert_at_back(new_data);
		}
		else // otherwise, data has to be inserted in the middle of the list
		{
			// set current_node to first_node
			list_node current_node = first_node;
			
			// set previous_node to null 
			list_node previous_node = null;
			
			// find the appropriate position by traversing through list until end 
			// of list is not reached and data is less than data in current_node 
			while(current_node != null && compare(current_node.data, new_data) < 0) 
			{
				// update previous and current node for next iteration
				previous_node = current_node;
				current_node = current_node.next;
			}
			
			// create new_node to insert the new data
			list_node new_node = new list_node(new_data, null);

			// set the previous_node next and new_node next appropriately
			previous_node.next = new_node;
			new_node.next = current_node;
		}

		// increment number of nodes
		num_of_nodes++;
		return true;
	}
	
	// remove an object from the list
	public Object remove(Object data) 
	{
		// empty list, therefore nothing to remove so return null
		if(first_node == null)
		{
			return null;
		}

		// checking if data of first_node is equal to data
		if(compare(first_node.data, data) == 0)
		{
			// decrementing num_of_nodes by 1 because a node will be removed
			num_of_nodes--;
			// call remove_from_front() from superclass method
			return super.remove_from_front();
		}
		else if(compare(last_node.data, data) == 0) // if data of last_node is equal to data
		{	
			// decrementing num_of_nodes by 1 because a node will be removed
			num_of_nodes--;

			// call remove_from_back() from superclass method
			return super.remove_from_back();
		}
		else // otherwise, the data is proably in the middle of the list
		{	
			// setting currentnode to the first node 
			list_node current_node = first_node;

			// setting previous node to null
			list_node previous_node = null;

			// find the appropriate position by traversing through list until end 
			// of list is not reached and data is less than data in current_node
			while(current_node != null && compare(current_node.data, data) < 0) 
			{
				// update previous and current node for next iteration
				previous_node = current_node;
				current_node = current_node.next;
			}
			
			// checking if current_node is null (hence end of list) OR current_node 
			// data is is greater than data
			if(current_node == null || compare(current_node.data, data) > 0)
			{
				return null;
			}
			else // otherwise, data exists in the list
			{
				// decrementing num_of_nodes by 1 because a node will be removed
				num_of_nodes--;

				// setting previous_node's next to current_node's next
				previous_node.next = current_node.next;
				
				return current_node.data;
			}
		}
	}
	
	// method to get the size of the list using num_of_nodes
	public long get_size()
	{
		return num_of_nodes;
	}


	// ensuring that insert_at_front cannot be used
	@Override
	public void insert_at_front(Object new_data)
	{
		System.out.println("Method unavailable.");
	}

	// ensuring that insert_at_back cannot be used
	@Override
	public void insert_at_back(Object new_data)
	{
		System.out.println("Method unavailable.");
	}
    
	/**************************************************************************/
    // Private
    /**************************************************************************/

	/**************************************************************************/
    // Fields
    /**************************************************************************/

	// num_of_nodes holds the number of nodes in list
	private long num_of_nodes; 
}