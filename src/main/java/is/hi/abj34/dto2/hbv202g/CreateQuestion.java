package is.hi.abj34.dto2.hbv202g;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateQuestion {

    static String title = "";
    static String answer = "";
    static ArrayList<String> wrongAnswers = new ArrayList<String>();
    static String category = "";
    

    public static void view() {
        System.out.println("##############################");
        System.out.println("Please fill in all fields: ");
        System.out.println("1. Question: " + title);
        System.out.println("2. Answer: " + answer);
        System.out.println("3. Wrong answers: " + wrongAnswers);
        System.out.println("4. Category: " + category);
        System.out.println("5. Back to main menu");

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch(choice) {
            case 1:
                System.out.println("##############################");
                System.out.print("Enter the question: ");
                title = input.next();
                view();
                break;
            case 2:
                System.out.println("##############################");
                System.out.print("Enter the right answer: ");
                answer = input.next();
                view();
                break;
            case 3:
                String line = "temp";
                while(!line.equals("")) {
                    System.out.println("##############################");
                    System.out.print("Enter a wrong answers(at least 2): " + wrongAnswers);
                    System.out.println("Type a blank line to finish");
                    line = input.next();
                    if ( !line.equals("") ) {
                        wrongAnswers.add(line);
                    }
                }
                view();
                break;
            case 4:
                // TODO setja inn öll category sem eru til, til að geta valið úr
                System.out.println("##############################");
                System.out.print("Category: ");
                category = input.next();
                view();
                break;
            case 5:
                App.mainMenu();
            default:
                System.out.println("Invalid choice");
                view();
        }
    }
}