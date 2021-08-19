import java.util.*;

public class v_dice_thrower
{

    /**************************************************************************/
    // Constructors
    /**************************************************************************/ 

    public v_dice_thrower(int num_of_sides_val, int num_of_throws_val)
    {
        num_of_sides = num_of_sides_val;
        num_of_throws = num_of_throws_val;
    }

    /**************************************************************************/
    // Methods
    /**************************************************************************/ 

    // simulate virtual dice thrower
    public void sim_v_dice_thrower()
    {
        // creating an array to store frequency of each side when it is rolled
        // size of array = num_of_sides
        int freq_of_sides[] = new int[num_of_sides];

        // creating an instance of Random() to generate a random number
        // between 0 and num_of_sides - 1
        Random rand = new Random();
        

        // using for loop to store the frequency of each side that is rolled
        for(int i = 0; i < num_of_throws; i++)
        {
            // rolled_num holds the number of the side that is rolled 
            // generated to be a random number from 0 to num_of_sides - 1
            int rolled_num = rand.nextInt(num_of_sides);

            // incrementing the frequency of rolled_num each time it is rolled
            freq_of_sides[rolled_num] += 1;
        }

        System.out.printf("Side\tFrequency\n");

        // using for loop to output the frequency of each side when it is rolled
        for(int i = 0; i < num_of_sides; i++)
        {
            System.out.printf("%d\t%d\n", i + 1, freq_of_sides[i]);
        }
    }

    /**************************************************************************/
    // Fields
    /**************************************************************************/
    
    // num_of_sides holds the number of side in the dice
    private int num_of_sides;

    // num_of_throws holds the number of times the dice is thrown
    // it is the number of times the virtual dice thrower must be simulated
    private int num_of_throws;
    
    /**************************************************************************/
    // Main
    /**************************************************************************/
    
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);

        int num_of_sides = 0;

        while(true)
        {
            // using try and catch block for exception handling
            try
            {
                System.out.printf("Enter number of sides: ");

                // get integer from stdin
                // nextInt() method throws an exception if input is not integer
                num_of_sides = input.nextInt();

                // first checking if number of sides is less that 2 
                // if so print error message and ask user to enter again
                if (num_of_sides < 2)
                {
                    System.out.println("Number of sides must be 2 or more");
                    continue; // continue looping
                }
                break;
            }

            // exception handling when input is not an integer
            catch(InputMismatchException e)
            {
                // buffer contains invalid input which is not cleared yet
                // clearing the buffer to continue execution of program
                input.nextLine();

                System.out.printf("%s\n", e);
            }
        }

        int num_of_throws = 0;

        while(true)
        {
            // using try and catch block for exception handling
            try
            {
                System.out.printf("Enter number of throws: ");

                // get integer from stdin 
                // nextInt() method throws an exception if input is not integer
                num_of_throws = input.nextInt();

                // number of throws must be a multiple of number of sides 
                // checking if number of throws is not a multiple of num of 
                // sides 
                // if so print error message and ask user to enter again
                if (num_of_throws % num_of_sides != 0)
                {
                    System.out.println("Number of throws must be a multiple of number of sides");
                    continue; // continue looping
                } 
                else if(num_of_throws <= 0)
                {
                    System.out.println("Number of sides has to be greater than 0 AND a multiple of number of sides");
                    continue; // continue looping
                }
                
                break;
            }
            // exception handling when input is not an integer
            catch(InputMismatchException e)
            {
                // buffer contains invalid input which is not cleared
                // clearing the buffer to continue execution of program
                input.nextLine();

                System.out.printf("%s\n", e);
            }
        }

        // virtual dice thrower instance 
        v_dice_thrower v_dice = new v_dice_thrower(num_of_sides, num_of_throws);
        
        // calling virtual dice simulator using sim_v_dice_thrower() method
        v_dice.sim_v_dice_thrower();

        // close scanner object
        input.close();
    }
}