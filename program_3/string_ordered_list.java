class string_ordered_list extends ordered_list
{
	/**************************************************************************/
    // Public
    /**************************************************************************/

    /**************************************************************************/
    // Constructors
    /**************************************************************************/

	// constructor with no parameters 
	public string_ordered_list() 
    {
		// calling constructor from superclass with one parameter 
		super("String ordered list");
	}
	
	// constructor with one parameters 
	public string_ordered_list(String list_name) 
    {	
		// calling constructor from superclass with one parameter 
		super(list_name);
	}

    /**************************************************************************/
    // Protected
    /**************************************************************************/

    /**************************************************************************/
    // Methods
    /**************************************************************************/

	@Override
	protected int compare(Object obj_1, Object obj_2) 
    {
		// returning the comparison with subtraction of two objects which are of
        // type string using compareTo() method
		return ((String)obj_1).compareTo(((String)obj_2));
	} 
}