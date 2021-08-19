class student_record_ordered_list extends ordered_list
{
    /**************************************************************************/
    // Public
    /**************************************************************************/

    /**************************************************************************/
    // Constructors
    /**************************************************************************/

    // constructor with no parameter 
    public student_record_ordered_list()
    {
        // calling constructor from superclass with one parameter 
        super("\nStudent record ordered list");
    }
    
    // constructor with one parameter 
    public student_record_ordered_list(String list_name)
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
        String student_1 = ((student_record)obj_1).surname + " " + ((student_record)obj_1).name;

        String student_2 = ((student_record)obj_2).surname + " " + ((student_record)obj_2).name;

        // returning the comparison with subtraction of two objects which are of
        // type string using compareTo method
        return student_1.compareTo(student_2);
    }
}