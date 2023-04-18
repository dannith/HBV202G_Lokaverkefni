package is.hi.abj34.dto2.hbv202g;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateQuestionaire {

    static String breaker = "##############################";

    private static int questionsToAnswer = 0;
    private static String chosenCategory;

    private static List<Category> categories = QuestionSystem.getCategories();
    //List<Question> questions = QuestionSystem.getQuestions();
    private static List<Question> questions = new ArrayList<Question>();
    
    public static void view() {
        System.out.println(breaker);
        System.out.println("1. How many questions will be asked?" + questionsToAnswer);
        System.out.println("2. Questions category?" + chosenCategory);
        System.out.println("3. Take quiz!");
        System.out.println("4. Back to main menu");

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch(choice) {
            case 1:
                System.out.println(breaker);
                System.out.println("How many questions will be asked?");
                questionsToAnswer = input.nextInt();
                view();
                break;
            case 2:
                System.out.println(breaker);
                System.out.println("Choose a category: ");
                for (int i = 0; i < categories.size(); i++) {
                    System.out.println(i + ". " + categories.get(i).getName() + " - includes " + categories.get(i).getQuestionsCount() + " questions");
                }
                String selection = input.next();
                if( !categories.contains(selection)) {
                    System.out.println("Invalid choice");
                } else {
                    chosenCategory = selection;
                }
                view();
                break;
            case 3:
                if(questionsToAnswer <= 0) {
                    System.out.println("Please choose at least 1 question");
                    view();
                } else if (!chosenCategory.isEmpty()) {
                    System.out.println("Please choose a category");
                    view();
                } else {
                    List<Question> quizQuestions = filtering(questionsToAnswer, chosenCategory);
                    Quiz.takeQuiz(quizQuestions);
                }
                break;
            case 4:
                App.mainMenu();
                break;
            default:
                System.out.println("Invalid choice");
                view();
                break;
        }
    }

    public static List<Question> filtering(int questionCount, String category) {
        // filter down questions by category and number of questions
        List<Question> filteredQuestions = new ArrayList<Question>();
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).getCategory().equals(category) && i < questionCount) {
                filteredQuestions.add(questions.get(i));
            }
        }
        return filteredQuestions;
    }
}
