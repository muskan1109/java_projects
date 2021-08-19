public class point implements shape
{
    /**************************************************************************/
    // Public
    /**************************************************************************/
    
    /**************************************************************************/
    // Constructors
    /**************************************************************************/

    // constructor with no parameters 
    public point()
    {
        // calling delegated constructor with default values
        this(0, 0);
    }

    // constructor with two parameters 
    public point(int x_val, int y_val)
    {
        // setting the value of x 
        x = x_val;

        // setting the value of y
        y = y_val;
    }

    /**************************************************************************/
    // Methods
    /**************************************************************************/

    // override is for the compiler to ensure that we are overrding a superclass 
    // method in the subclass
    
    @Override // overriding get_name() method from the shape interface
    public String get_name()
    {
        return "Point";
    }

    @Override // overriding get_area() method from the shape interface
    public double get_area()
    {
        // point cannot have an area so returning 0
        return 0;
    }

    @Override // overriding get_volume() method from the shape interface
    public double get_volume()
    {
        // point cannot have a volume so returning 0
        return 0;
    }

    @Override // overriding toString() method from Object 
    public String toString()
    {
        return "[" + x + "," + y + "]"; 
    }

    /***************************Setters and Getters****************************/

    // get method for x-coordinate
    public int get_x()
    {
        return x;
    }

    // get method for y-coordinate
    public int get_y()
    {
        return y;
    }

    // set method for x-coordinate
    public void set_x(int x_val)
    {
        x = x_val;
    }

    // set method for y-coordinate
    public void set_y(int y_val)
    {
        y = y_val;
    }

    /**************************************************************************/
    // Private
    /**************************************************************************/

    /**************************************************************************/
    // Fields
    /**************************************************************************/
    private int x, y; 
}
