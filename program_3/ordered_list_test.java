import java.util.*;

public class ordered_list_test 
{
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
                
                // clearing buffer (\n)
                input.nextLine();

                // if user enters an integer, exit is set to true to break out of while loop
                // if user does not enter an integer, the next statement is not executed
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

    public static void main(String[] args) 
    {
        // creating new object of scnanner class, to get user input
		Scanner input = new Scanner(System.in);

		// creating new object of integer_ordered_list class
		integer_ordered_list integer_list = new integer_ordered_list();
		
		// creating new object of string_ordered_list class
		string_ordered_list string_list = new string_ordered_list();

        // infinite loop 
		while(true) 
        {
			// printing menu for user
			System.out.println("MENU");
			System.out.println("----");
			System.out.println("1. Insert number/string");
			System.out.println("2. Remove number/string");
			System.out.println("3. Print the appropriate list");
			System.out.println("4. Exit");

			// user_input holds the input given by the user in option 1, 2, 3
			String user_input;

			// option holds the menu option chosen by the user
			int option = get_integer_terminal(input, "\nEnter an option: ");

			switch(option) 
			{
				case 1: // asking user to enter number/string to insert 

					// printing message to user 
					System.out.print("\nEnter a number/string to insert: ");
					
					user_input = input.nextLine();

					// using try and catch block for exception handling, if and 
					// when parsing fails
					try 
					{
						// user_input_int holds the parsed user_input if successful
						// parseInt() can throw an exception 
						int user_input_int = Integer.parseInt(user_input);

						// if parseInt() does not throw an exception, it means 
						// user entered a number

						// attempting to insert number in integer list
						// if number already exists in integer list then false 
						// returned else true
						if(integer_list.insert(user_input_int) == false)
						{
							System.out.println("\nThis number already exists!\n");
						}
						else
						{
							System.out.println("\nNumber inserted!\n");
						}
					}
					catch(NumberFormatException e) 
					{
						// if parseInt() throws an exception, it means user 
						// entered string 

						// attempting to insert number in string list
						// if string already exists in string list then false 
						// returned else true
						if(string_list.insert(user_input) == false)
						{
							System.out.println("\nThis string already exists!\n");
						}
						else
						{
							System.out.println("\nString inserted!\n");
						}
					}

					break;

				case 2: // asking user to enter number/string to remove

					// checking if both lists are empty
					// if yes, break out of case 2 if both lists are empty
					if(integer_list.first_node == null && string_list.first_node == null)
					{
						System.out.println("\nSorry, nothing to remove. Both lists are empty.\n");
						break;
					}

					// if both lists are not empty, user is asked to enter number/string to remove
					System.out.print("\nEnter a number/string to remove: ");
					user_input = input.nextLine();

					// using try and catch block for exception handling
					try 
					{
						// user_input_int holds the parsed user_input if successful
						// parseInt() can throw an exception 
						int user_input_int = Integer.parseInt(user_input);

						// checking if integer list is empty
						if(integer_list.first_node == null)
						{
							System.out.println("\nSorry, nothing to remove. The integer list is empty!\n");
						}
						else // when integer list is not empty
						{	
							// attempting to remove integer from list 
							// if the integer input by the user exists in integer
							// list, then returns null otherwise it is removed
							if(integer_list.remove(user_input_int) == null)
							{
								System.out.println("\nThis number does not exist in the integer list.\n");
							}
							else
							{
								System.out.println("\nRemoved number successfully!\n");
							}
						}
					} 
					catch(NumberFormatException e)
					{
						// if parseInt() does throws an exception, it means user
						// entered string

						// checking if string list is empty
						if(string_list.first_node == null)
						{
							System.out.println("\nSorry, nothing to remove. The string list is empty\n");
						}
						else
						{	// if the string input by the user exists in string 
							// list, then null is returned otherwise it is removed
							if(string_list.remove(user_input) == null)
							{
								System.out.println("\nThis string does not exist in the string list.\n");
							}
							else
							{
								System.out.println("\nRemoved string successfully!\n");
							}
						}
					}
				
					break;
				
				case 3: // printing the appropriate list

					// checking if both lists are empty
					// if yes, break out of case 2 if both lists are empty
					if(integer_list.first_node == null && string_list.first_node == null)
					{
						System.out.println("\nSorry, nothing to print. Both lists are empty.\n");
						break;
					}

					// checking if integer list is empty	
					if(integer_list.first_node == null)
					{
						System.out.println("\nThe integer list is empty.\n");
					}
					else // printing integer list if it is not empty
					{
						System.out.println("\n" + integer_list.toString() + "\n");
					}

					// checking if string list is empty
					if(string_list.first_node == null)
					{
						System.out.println("The string list is empty.\n");
					}
					else // printing string list if it is not empty
					{
						System.out.println(string_list.toString() + "\n");
					}
					
					break;
				
				case 4: // exiting from the program
					System.out.println("\nExiting...");

					// closing scanner class
					input.close();

					// exiting 
					System.exit(0);
			
				default: // when the user enters an integer other that 1, 2, 3, 4
					System.out.println("\nPlease enter a number between 1 and 4.");
					break;
			}
		}
	}
}