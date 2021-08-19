public class circle extends point
{
    /**************************************************************************/
    // Public
    /**************************************************************************/
    
    /**************************************************************************/
    // Constructors
    /**************************************************************************/

    // constructor with no parameters
    public circle()
    {
        // calling delegated constructor with default values
        this(0, 0, 0.0); 
    }

    // constructor with three parameters
    public circle(int x, int y, double r)
    {
        // calling constructor from superclass with two parameters 
        super(x,y); 

        // calling set_radius() method to set r appropriately
        set_radius(r);
    }

    /**************************************************************************/
    // Methods
    /**************************************************************************/
    
    @Override // overriding get_name() method from the point class 
    public String get_name()
    {
        return "Circle";
    }

    @Override // overriding get_area() method from the point class 
    public double get_area()
    {
        // returning area of a circle (which is pi*r^2)
        return Math.PI * r * r;
    }

    // circle has no volume therefore the implementation in point class is
    // valid and there is no need to override it

    @Override // overriding toString() method from point class  
    public String toString()
    {
        // calling toString() method from superclass as the implementation for
        // x and y is already done
        return "C = " + super.toString() + "; R = " + r;
    }


    /***************************Setters and Getters****************************/

    // set method for radius of circle
    public void set_radius(double r_val)
    {
        // setting r (radius) to 0 if r_val is less than 0
        // if not, setting r to r_val
        if(r_val < 0)
        {
            System.out.println("Radius cannot be less than 0. Therefore, setting radius to 0.\n");
            r = 0;
        }
        else
        {
            r = r_val;
        }
    }
    
    // get method for radius of circle
    public double get_radius()
    {
        return r;
    }

    /**************************************************************************/
    // Private
    /**************************************************************************/

    /**************************************************************************/
    // Fields
    /**************************************************************************/
     private double r; 
}
