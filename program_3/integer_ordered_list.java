class integer_ordered_list extends ordered_list
{

    /**************************************************************************/
    // Public
    /**************************************************************************/

    /**************************************************************************/
    // Constructors
    /**************************************************************************/

    // constructor with no parameters
    public integer_ordered_list()
    {
        // calling constructor from superclass with one parameter 
        super("Integer ordered list");
    }

    // constructor with a parameter
    public integer_ordered_list(String list_name)
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
        // type integer: 
        // obj_1 < obj_2 means returned value is less than 0
        // obj_1 > obj_2 means returned value is more than 0
        // obj_1 = obj_2 means returned value is equal to 0
        return ((Integer)obj_1).intValue() - ((Integer)obj_2).intValue();
    }
}