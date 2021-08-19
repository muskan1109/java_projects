class student_record 
{   
    /**************************************************************************/
    // Public
    /**************************************************************************/

    /**************************************************************************/
    // Constructors
    /**************************************************************************/

    // constructor with four parameters
    public student_record(String surname, String name, int student_no, float average_mark)
    {
        this.surname = surname;
        this.name = name;
        this.student_no = student_no;
        this.average_mark = average_mark;
    }

    @Override
    public String toString()
    {
        return "Surname: " + surname + ", Name: " + name + ", Student Number: " + student_no + ", Average marks: " + average_mark + "\n";
    }

    /**************************************************************************/
    // Fields
    /**************************************************************************/
    
    // surname holds surname of user 
    public String surname;

    // name holds name of user
    public String name;
    
    // student_no holds student number of user
    public int student_no;

    // average_mark holds average mark of user
    public float average_mark;
}