public class cylinder extends circle
{
    /**************************************************************************/
    // Public
    /**************************************************************************/

    /**************************************************************************/
    // Constructors
    /**************************************************************************/

    // constructor with no parameters
    public cylinder()
    {
        // calling delegated constructor with default values
        this(0, 0, 0.0, 0.0);
    }

    // constructor with four parameters
    public cylinder(int x, int y, double r, double h)
    {
        // calling constructor from superclass with three parameters 
        super(x, y, r);

        // calling set_height() method to set height to h
        set_height(h);
    }

    /**************************************************************************/
    // Methods
    /**************************************************************************/

    // override is for the compiler to ensure that the method that is being 
    // overriden is in fact the same signature as in the superclass

    @Override // overriding get_name() method from the circle class 
    public String get_name()
    {
        return "Cylinder";
    }

    @Override // overriding get_area() method from the circle class  
    public double get_area()
    {
        // returning area of cylinder (= 2*pi*r^2 + 2*pi*r*h)
        // calling get_area() from superclass to get area of circle (=pi*r^2)
        // calling get_radius() from superclass (returns radius r)
        return 2 * super.get_area() + 2*Math.PI*get_radius() * h;
    }

    @Override // overriding get_volume() method from the point class 
    public double get_volume() 
    {
        // returning area of cylinder (= pi*r^2*h)
        // calling get_area() from superclass to get area of circle (=pi*r^2)
        return super.get_area() * h;
    }

    @Override // overriding toString() method from the circle class 
    public String toString()
    {
        // calling toString() method from superclass as the implementation for
        // x, y and r is already done
        return super.toString() + "; H = " + h;
    } 

    /***************************Setters and Getters****************************/

    // set method for height of cylinder
    public void set_height(double h_val)
    {
        // setting h (height) to 0 if h_val < 0
        // if not setting h to h_val
        if(h_val < 0)
        {
            System.out.println("Height cannot be less than 0. Therefore, setting height to 0.\n");
            h = 0;
        }
        else
        {
            h = h_val;
        }
    }

    // get method for height of cylinder
    public double get_height()
    {
        return h;
    }

    /**************************************************************************/
    // Private
    /**************************************************************************/

    /**************************************************************************/
    // Fields
    /**************************************************************************/
    private double h;

}

