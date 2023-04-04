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
                CreateQuestionaire.setup();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private static void answerQuestions() {
    }

    private static void createMenu() {

        Scanner input = new Scanner(System.in);

        System.out.println("#########################");
        System.out.println("1. Create Category");
        System.out.println("2. Create Question");
        System.out.println("3. Back to main menu");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                CreateCategory.setup();
                break;
            case 2:
                CreateQuestion.setup();
                break;
            case 3:
                mainMenu();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}