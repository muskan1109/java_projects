import java.util.InputMismatchException;
import java.util.Scanner;

public class shape_test 
{
    // method implemented to print a shape's ID, name, area, volume
    public static void print_shape(shape current_shape, int index)
    {
        System.out.printf("Shape ID: %d\n", index + 1);
        System.out.println(current_shape.get_name() + " : " + 
                           current_shape.toString());
        System.out.println("Area: " + current_shape.get_area());
        System.out.println("Volume: " + current_shape.get_volume());
        System.out.println();
    }

    // method to ensure that a user enters an integer
    // uses try and catch block for exception handling
    public static int get_integer_terminal(Scanner input, String prompt)
    {
        // user_input holds the input given by the user 
        int user_input = 0;
          
        // using a flag to break out of the loop when necessary
        boolean exit = false;

        // while loop which continues to loop until user enters an integer
        while(exit == false)
        {
            // using try and catch block for exception handling 
            try
            {
                // printing message to the user 
                System.out.printf("%s", prompt);

                // nextInt() can throw an exception 
                user_input = input.nextInt();

                // if user enters an integer, exit is set to true to break out 
                // of while loop
                // if user does not enter an integer, the next statement is not 
                // executed
                exit = true;
            }
            catch(InputMismatchException e)
            {
                // clearing the buffer 
                input.nextLine();

                System.out.printf("%s\n", e);
            }
        }

        return user_input;         
    }

    
    // method to ensure that a user enters a double
    // uses try and catch block for exception handling
    public static double get_double_terminal(Scanner input, String prompt)
    {
        // user_input holds the input given by the user 
        double user_input = 0;
        
        // using a flag to break out of the loop when necessary
        boolean exit = false;

        // while loop which continues to loop until user enters an integer
        while(exit == false)
        {
            // using try and catch block for exception handling
            try
            {
                // printing message to the user
                System.out.printf("%s", prompt);

                // nextDouble() can throw an exception 
                user_input = input.nextDouble();

                // if user enters a double, exit is set to true to break out of 
                // while loop
                // if user does not enter a double, the next statement is not 
                // executed
                exit = true;
            }
            catch(InputMismatchException e)
            {
                // clearing the buffer 
                input.nextLine();

                System.out.printf("%s\n", e);
            }
        }

        return user_input;
    }

    public static void main(String args[])
    {
        // used to get input from stdin
        Scanner input = new Scanner(System.in);

        // shapes[] array of size 100 to hold the shapes created
        shape shapes[] = new shape[100];

        // shapes_index holds the index that has been filled till now 
        int shapes_index = 0;

        // option holds the menu option that the user wants to select
        int option = 0;

        // x holds the x-coordinate 
        int x = 0;

        // y holds the y-coordinate
        int y = 0;

        // r holds the radius 
        double r = 0.0;

        // h holds the height
        double h = 0.0;

        // using a flag to break out of the loop for the main program
        boolean exit = false;

        // while loop which continues to loop until user enters an integer
        while(exit == false)
        {
            // printing menu
            System.out.println("Menu");
            System.out.println("1. Create Point");
            System.out.println("2. Create Circle");
            System.out.println("3. Create Cylinder");
            System.out.println("4. Delete");
            System.out.println("5. Print out all objects");
            System.out.println("6. Exit");

            // method to ensure that a user enters an integer
            // uses try and catch block for exception handling            
            option = get_integer_terminal(input, "Enter option: ");

            // switch case for option 1 to 6
            switch(option)
            {
                // creating point
                case 1:     
                    // asking user to input x-coordinate of point
                    x = get_integer_terminal(input, "Enter x: ");

                    // asking user to input y-coordinate of point 
                    y = get_integer_terminal(input, "Enter y: ");
                    
                    // creating a point instance and storing it in shapes[]
                    shapes[shapes_index] = new point(x, y);

                    System.out.println("Creating point\n");

                    // calling print_shape() method to print the new point
                    print_shape(shapes[shapes_index], shapes_index);

                    // increment shapes_index by 1 (to store next shape)
                    shapes_index++;

                    break;

                // creating circle
                case 2:      
                    // asking user to input x-coordinate of circle
                    x = get_integer_terminal(input, "Enter x: ");

                    // asking user to input y-coordinate of circle
                    y = get_integer_terminal(input, "Enter y: ");

                    // asking user to input radius of circle
                    r = get_double_terminal(input, "Enter r: ");

                    // creating a circle instance and storing it in shapes[]
                    shapes[shapes_index] = new circle(x, y, r);

                    System.out.println("Creating circle\n");

                    // calling print_shape() method to print the new circle
                    print_shape(shapes[shapes_index], shapes_index);

                    // increment shapes_index by 1 (to store next shape)
                    shapes_index++;

                    break;
                
                // creating cylinder
                case 3:

                    // asking user to input x-coordinate of cylinder
                    x = get_integer_terminal(input, "Enter x: ");

                    // asking user to input y-coordinate of cylinder
                    y = get_integer_terminal(input, "Enter y: ");

                    // asking user to input x-coordinate of cylinder
                    r = get_double_terminal(input, "Enter r: ");

                    // asking user to input height of cylinder
                    h = get_double_terminal(input, "Enter h: ");

                    // creating a cylinder instance and storing it in shapes[]                    
                    shapes[shapes_index] = new cylinder(x, y, r, h);

                    System.out.println("Creating cylinder\n");

                    // calling print_shape() method to print the new cylinder
                    print_shape(shapes[shapes_index], shapes_index);

                    // increment shapes_index by 1 (to store next shape)
                    shapes_index++;

                    break;
                
                // deleting
                case 4:
                
                    // ensuring that deletion is done only when at least one 
                    // shape has been created
                    if(shapes_index == 0)
                    {
                        System.out.printf("No shapes have been created yet.\n");

                        // break out of case 4 if no shapes have been created
                        break;
                    }

                    // using a flag to break out of the loop when necessary
                    boolean delete_exit = false;

                    // while loop which continues to loop until user enters an 
                    // existing shape ID to delete
                    while(delete_exit == false)
                    {
                        // delete_shape_ID holds the ID of the shape that the 
                        // user wants to delete
                        int delete_shape_ID = get_integer_terminal(input, 
                                          "Enter the Shape ID to be deleted: ");

                        // valid index is between 0 and shapes_index - 1
                        // shape_id = index + 1
                        // valid shape_id is between 1 and shapes_index
                        if(delete_shape_ID >= 1 && delete_shape_ID <= shapes_index)
                        {
                            System.out.printf("Deleting shape ID %d\n", delete_shape_ID);

                            // delete the element that corresponds to (shape ID - 1)
                            shapes[delete_shape_ID - 1] = null;

                            // break out of the loop if delete_shape_ID is 
                            // between 1 and shapes_index
                            delete_exit = true;
                        }
                        else
                        {
                            System.out.printf("Please enter a shape ID between 1 and %d\n", shapes_index);
                        }
                    }

                    break;
                
                // printing all shapes
                case 5:                
                    
                    // ensuring that printing is done only when at least one 
                    // shape has been created
                    if(shapes_index == 0)
                    {
                        System.out.printf("No shapes have been created yet.\n");
                        break;
                    }

                    // traversing from 0 to shapes_index - 1 
                    for(int i = 0; i < shapes_index; i++)
                    {
                        // ensuring that printing is done only if the shape 
                        // exists (i.e. not null)
                        if(shapes[i] != null)
                        {
                            print_shape(shapes[i], i);
                        }
                    }
                    break;
                
                // exiting 
                case 6:
                    
                    // setting the flag to true because user wants to exit
                    exit = true;
                    System.out.printf("Exiting...\n");
                    break;

                default:
                    System.out.println("Please enter an integer between 1 and 6\n");
                    break;
            }
        }

        // closing scanner instance 
        input.close();
    }
}