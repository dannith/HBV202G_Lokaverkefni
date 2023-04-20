package is.hi.abj34.dto2.hbv202g;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        mainMenu();
    }

    public static void mainMenu() {

        Scanner input = new Scanner(System.in);

        System.out.println("#########################");
        System.out.println("1. Create Questions or Categories");
        System.out.println("2. Take Quiz");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                createMenu();
                break;
            case 2:
               CreateQuestionaire.view();
                break;
            default:
                System.out.println("Invalid choice");
                mainMenu();
            }
    }

    public static void createMenu() {

        Scanner input = new Scanner(System.in);

        System.out.println("#########################");
        System.out.println("1. Create Category");
        if(QuestionSystem.getCategories().size() > 0)
            System.out.println("2. Create Question");
        else
            System.out.println("2. --------");
        System.out.println("3. Back to main menu");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                // Go to CreateCategory.java
                CreateCategory.view();
                break;
            case 2:
                // Go to CreateQuestion.java
                if(QuestionSystem.getCategories().size() > 0)
                    CreateQuestion.view();
                else
                    createMenu();
                break;
            case 3:
                mainMenu();
                break;
            default:
                System.out.println("Invalid choice");
                createMenu();
        }
    }
}