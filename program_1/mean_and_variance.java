import java.util.*;

public class mean_and_variance
{
    /**************************************************************************/
    // Constructors
    /**************************************************************************/ 

    // constructor with no parameter
    public mean_and_variance()
    {
        data = null;
    }

    // constructor with parameter my_data
    public mean_and_variance(float my_data[])
    {
        data = my_data;
    }

    /**************************************************************************/
    // Methods
    /**************************************************************************/ 

    // calculating mean
    public float mean()
    {   
        // sum variable holds the sum of all elements in the data array
        float sum = 0;

        // for loop to add all the elements in the data array
        for(int i = 0; i < data.length; i++)
        {   
            // storing the sum of all elements in sum variable
            sum = sum + data[i];
        }

        // data_mean holds the mean of all elements in the data array
        float data_mean = sum / data.length;
        return data_mean;
    }

    // calculating variance 
    public float variance()
    {
        // calling mean method above to get mean of elements 
        float data_mean = mean();
        
        // variance = squared_diff_sum/n
        // squared_diff_sum is the sum of the expression [(x[i] - mean)^2] 
        // from i = 0 to (num_of_elements - 1) 
        float squared_diff_sum = 0;

        // for loop to calculate squared_diff_sum
        for (int i = 0; i < data.length; i++)
        {
            squared_diff_sum += ((data[i] - data_mean) * (data[i] - data_mean));
        }
        
        // data_variance holds the variance for the data array
        float data_variance = squared_diff_sum / data.length; 
        
        return data_variance;
    }

    // overrides Object toString method 
    @Override 
    public String toString() 
    {   
        // out holds the string representation of the data field
        String out = new String();

        // ask about string format
        // string format - data[i] + " " --> repeated for all elements
        for(int i = 0; i < data.length; i++)
        {
            out += data[i] + " ";
        }
        
        return out;
    }

    // get_data_no_from_keyboard
    // - this method will get the number of data elements from the 
    // keyboard and checks to see if the number of data elements
    // is equal to or greater than 2, and if not ask the user 
    // until it is
    // - since this method is used by get_data_set_from_keyboard
    // can set access specifier to private
    private static int get_data_no_from_keyboard(Scanner input)
    {
        // holds the number of elements in data array field
        int num_of_elements = 0;

        while(true) 
        {
            System.out.printf("For mean and variance of random data set, use:\n\tjava mean_and_variance n u\n\t*n: number of elements in the data set\n\t*u: upper bound of the numbers in the data set\n\n");
            System.out.printf("Enter number of elements: ");
            
            // using try and catch block for exception handling
            try
            {
                // get integer from stdin 
                // input can only be an integer more than 2
                // nextInt() method throws an exception if input is not integer
                num_of_elements = input.nextInt();
                
                // check if num_of_elements is less than 2
                // if so print error message and ask user to enter again
                if (num_of_elements < 2)
                {
                    System.out.printf("The number of data should be >=2 !\n");
                    continue; // continue looping
                }
                // num_of_elements is >= 2, hence exit while loop
                break;
            }

            // exception handling when input is not an integer
            catch (InputMismatchException e)
            {   
                // buffer contains invalid input which is not cleared
                // clearing the buffer to continue execution of program
                input.nextLine();

                System.out.printf("%s\n", e);
            }
        }
        
        return num_of_elements;
    }

    // get_data_set_from_keyboard
    // this method will get the data set from the keyboard
    public void get_data_set_from_keyboard(Scanner input)
    {
        // get the number of elements for the data array
        int num_of_elements = get_data_no_from_keyboard(input);

        // data is a float array with size num_of_elements
        data = new float[num_of_elements];

        // for loop to get elements for data array from stdin
        for(int i = 0; i < num_of_elements; )
        {
            System.out.printf("data[%d]: ", i);
            
            // using try and catch block for exception handling
            try
            {
                // nextFloat() throws an exception
                // input has to be a float 
                data[i] = input.nextFloat();

                // array index is incremented only if valid input is entered
                i++;
            }
            // exception handling when input is not a flaot
            catch(InputMismatchException e)
            {
                // buffer contains invalid input which is not cleared
                // clearing the buffer to continue execution of program
                input.nextLine();
                System.out.printf("%s\n", e);
            }
        }
    }

    // get_random_data_set
    public void get_random_data_set (int num_of_elements, int upper_bound) 
    { 
        // create array with size num_of_elements
        data = new float[num_of_elements];

        // rand is a random object
        Random rand = new Random();

        // for loop to get a random data set 
        for(int i = 0; i < data.length; i++)
        {
            // multiplying result from nextFloat() by upper_bound
            // This is because the result from nextFloat() is 
            // between 0.0 and 1.0
            // So to have a range of [0, upper_bound)
            // result from nextFloat() is multiplied with upper_bound
            data[i] = rand.nextFloat()*upper_bound;
        }
    }

    /**************************************************************************/
    // Fields
    /**************************************************************************/ 
    private float data[];

    /**************************************************************************/
    // Main
    /**************************************************************************/ 
    
    public static void main(String args[])
    {
        // mean and variance object instance 
        mean_and_variance mv = new mean_and_variance();
        
        // if no arguements given when program is called get 
        // data from keyboard
        // else if there are 2 arguements given when the program
        // is called then get random data
        // else print error message and exit program
        if(args.length == 0)
        {
            Scanner input = new Scanner(System.in);
            mv.get_data_set_from_keyboard(input);
            input.close();
        }
        else if(args.length == 2)
        {
            // using try and catch block for exception handling
            try
            {   
                // parseInt() can throw an exception 
                // input must be a parsable integer  
                int num_of_elements = Integer.parseInt(args[0]);
                int upper_bound = Integer.parseInt(args[1]);

                // number of elements must be 0 or more
                // upper bound cannot be 0
                // checking if both conditions are satisfied
                if(num_of_elements <= 0 || upper_bound == 0)
                {
                    System.out.printf("Incorrect number of arguments, try again\n");

                    // exiting the program since conditions are not met
                    System.exit(0);
                }

                mv.get_random_data_set(num_of_elements, upper_bound);
            }
            // exception handling when input is not a parsable integer
            catch(NumberFormatException e)
            {
                System.out.printf("%s\n", e);

                // exiting the program since valid input must be passed
                System.exit(0);
            }
        }
        else 
        {
            System.out.printf("Incorrect number of arguments, try again\n");
            System.exit(0);
        }
    
        System.out.printf("The mean and variance of the following numbers are:\n");
        System.out.printf("Numbers: %s\n", mv.toString());
        System.out.printf("Mean: %f Variance: %f\n", mv.mean(), mv.variance());
    }
}