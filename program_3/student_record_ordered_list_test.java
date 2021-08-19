import java.util.*;
import java.io.*;


public class student_record_ordered_list_test 
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
                
                // clearing buffer (for \n)
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

    // method to ensure that a user enters a float
    // uses try and catch block for exception handling
    public static float get_float_terminal(Scanner input, String prompt)
    {
        // user_input holds the input given by the user 
        float user_input = 0;
        
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

                // nextFloat() can throw an exception 
                user_input = input.nextFloat();

                // clearing buffer (for \n)
                input.nextLine();

                // if user enters a float, exit is set to true to break out of while loop
                // if user does not enter a float, the next statement is not executed
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
    
    public static String get_valid_names_terminal(Scanner input, String prompt)
    {
        // user_input holds the input given by the user 
        String user_input;

            
        // printing message to the user
        System.out.printf("%s", prompt);

        user_input = input.nextLine();

        // while loop which continues to loop until user enters an integer
        while(user_input.matches("^[a-zA-Z]+$") == false)
        {
            System.out.println("Sorry, that's not valid! Please enter alphabets only.");
            
            System.out.printf("%s", prompt);
            
            user_input = input.nextLine();
        }

        return user_input;
    }

    public static void main(String[] args)
    {
        // creating new object of scnanner class, to get user input
        Scanner input = new Scanner(System.in);
        

        // creating new object of student_record_ordered_list class
        student_record_ordered_list student_records_list = new student_record_ordered_list();

        // surname stores surname of student 
        String surname;

        // name stores name of student 
        String name;

        // student_no stores student number of student 
        int student_no;

        // average_mark stores average mark of student 
        float average_mark;

        // allowing the scope for try and catch block so that it can be closed 
        // for NumberFormatException 
        Scanner input_file = null;
        
        try
        {
            File data_file = new File("student_records.txt");

            // Scanner(data_file) can throw an exception 
            input_file = new Scanner(data_file);
            
            // reading first line from file to indicate number of nodes in list
            long num_of_nodes = Integer.parseInt(input_file.nextLine());

            // reading four lines in each iteration which corresponds to the 
            // data in a list node 
            for(long i = 0; i < num_of_nodes; i++)
            {
                surname = input_file.nextLine();
                name = input_file.nextLine();
                student_no = Integer.parseInt(input_file.nextLine());
                average_mark = Float.parseFloat(input_file.nextLine());

                // after reading four lines, it gets inserted in the list as a node 
                student_records_list.insert(new student_record(surname, name, student_no, average_mark));
            }
            // closing scanner object for this file
            input_file.close();
        }
        catch(FileNotFoundException e) 
        {
            System.out.println("File does not exist!");
        }
        catch(NumberFormatException e)
        {
            System.out.println("Cannot read from file any further due to file corruption");
            // closing scanner object for this file
            input_file.close();
        }
        
        // infinite while loop
        while(true)
        {
            // menu 
            System.out.println("\nMENU");
            System.out.println("----");
            System.out.println("1. Introduce a student record");
			System.out.println("2. Remove a student record (based on surname, name)");
			System.out.println("3. Print a student record");
			System.out.println("4. Print all student records in the list");
			System.out.println("5. Exit");
			
            // option that user enters
            int option = get_integer_terminal(input, "\nEnter option: ");           

            switch(option)
            {
                case 1: // Introduce a student record

                    // asking user for surname                    
                    surname = get_valid_names_terminal(input, "\nSurname of student: ");

                    // asking user for name
                    name = get_valid_names_terminal(input, "\nName of student: ");

                    // asking user for student number
                    student_no = get_integer_terminal(input, "\nStudent number of student: ");

                    // asking user for average mark
                    average_mark = get_float_terminal(input, "\nAverage mark of student: ");
                    
                    // making sure user enters a number between 0 and 100
                    while(average_mark < 0 || average_mark > 100)
                    {
                        System.out.println("Sorry, average mark must be within 0 and 100!");
                       
                        // asking user again for average mark
                        average_mark = get_float_terminal(input, "\nAverage mark of student: ");
                    }

                    // inserting student record in the list
                    student_records_list.insert(new student_record(surname, name, student_no, average_mark));

                    break;

                case 2: // Remove a student record
                    
                    // if list is empty, print error message
                    if(student_records_list.first_node == null)
                    {
                        System.out.println("\nSorry, nothing to remove! The list is empty.");
                        break;
                    }

                    // asking user for surname
                    System.out.print("\nSurname of student: ");
                    surname = input.nextLine();

                    // asking user for name
                    System.out.print("Name of student: ");
                    name = input.nextLine();

                    // attempt to remove student from student_records_list
                    // if such a student does not exist, print error message
                    if(student_records_list.remove(new student_record(surname, name, 0, 0)) == null) 
                    {
                        System.out.println("\nOops! No such student record exists.");
                    } 
                    else 
                    {
                        // if such a student exists, print removed message
                        System.out.println("\nRemoved!");
                    }
                    
                    break;

                case 3: // print a particular student record
                    
                    // if list is empty in the beginning, print error message
                    if(student_records_list.first_node == null)
                    {
                        System.out.println("\nSorry, nothing to print! The list is empty.");
                        break;
                    }

                    // asking user for surname
                    System.out.print("\nSurname of student: ");
                    surname = input.nextLine();

                    // asking user for name
                    System.out.print("Name of student: ");
                    name = input.nextLine();

                    // using binary_find() to find the student record
                    list_node searched_node = student_records_list.binary_find(new student_record(surname, name, 0, 0)); 

                    // if such a student exists, it means searched_node is not null
                    if(searched_node != null) 
                    {
                        System.out.println(searched_node.data.toString());
                    } 
                    else 
                    {
                        System.out.println("Sorry, this student record does not exist.");
                    }
                    
                    break;

                case 4: // print all student records

                    // if list is empty, print error message
                    if(student_records_list.first_node == null)
                    {
                        System.out.println("\nSorry, nothing to print! The list is empty.");
                        break;
                    }
                    System.out.println(student_records_list);
                    
                    break;
                
                case 5: // exit the program

                    System.out.println("\nSaving...");
                    
                    try 
                    {
                        // FileWriter can throw an IOException if the file 
                        // cannot be opened for some reason
                        FileWriter fileWriter = new FileWriter("student_records.txt");

                        // PrintWriter can throw a FileNotFound exception if the
                        // file cannot be opened for some reason
                        PrintWriter output = new PrintWriter(fileWriter);

                        // using get_size() to get the size of the list and 
                        // saving it as the first line in the .txt file 
                        output.println(student_records_list.get_size());

                        // setting current node to first_node in the list  
                        list_node current = student_records_list.first_node;
                        
                        // while loop continue as loing as current node is not null
                        // meaning the list is not empty
                        while(current != null)
                        {
                            // setting data in current node to current_data  
                            student_record current_data = (student_record)current.data;

                            // writing surname in the .txt file
                            output.println(current_data.surname);

                            // writing name in the .txt file
                            output.println(current_data.name);

                            // writing student number in the .txt file
                            output.println(current_data.student_no);

                            // writing average mark in the .txt file
                            output.println(current_data.average_mark);

                            // setting current to next node in the list 
                            current = current.next;
                        }

                        // closing the PrintWriter object
                        output.close();
                    } 
                    catch(IOException e) 
                    {
                        System.out.println("Cannot save because file cannot open");
                    }
                    
                    // closing scanner class
                    input.close();

                    System.out.println("\nExiting...");

                    // exiting from program
                    System.exit(0);

                default: // when the user enters an integer other that 1, 2, 3, 4, 5
                    System.out.println("\nPlease enter a number between 1 and 5.");
                    
                    break;
            }
        }
    }
}
