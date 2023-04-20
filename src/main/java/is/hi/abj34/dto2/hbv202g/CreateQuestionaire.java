package is.hi.abj34.dto2.hbv202g;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateQuestionaire {

    static String breaker = "##############################";

    private static int questionsToAnswer = 0;
    private static String questionCategory;
    private static String chosenCategory;

    private static List<Question> questions = QuestionSystem.getQuestions();
    
    public static void view() {
        System.out.println(breaker);
        System.out.println("1. How many questions will be asked? - " + questionsToAnswer);
        System.out.println("2. Questions category? " + questionCategory);
        System.out.println("3. Take quiz!");
        System.out.println("4. Back to main menu");

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        String choice = scanner.next().trim();
        switch(choice) {
            case "1":
                System.out.println(breaker);
                System.out.println("How many questions will be asked?");
                String temp = scanner.next().trim();
                questionsToAnswer = Integer.parseInt(temp);
                view();
                break;
            case "2":
                categoryView(scanner);
                view();
                break;
            case "3":
                if(questionsToAnswer <= 0) {
                    System.out.println("Please choose at least 1 question");
                    view();
                } else if (chosenCategory.isEmpty()) {
                    System.out.println("Please choose a category");
                    view();
                } else {
                    List<Question> quizQuestions = filtering(questionsToAnswer, chosenCategory);
                    clearAllValues();
                    Quiz.takeQuiz(quizQuestions);
                }
                break;
            case "4":
                clearAllValues();
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
            if (questions.get(i).getStringedCategory().equals(category) && i < questionCount) {
                filteredQuestions.add(questions.get(i));
            }
        }
        return filteredQuestions;
    }

    private static void categoryView(Scanner s) {
        System.out.println(breaker);
        System.out.println("Select a category:");

        List<Category> categories = QuestionSystem.getCategories();

        for(int i = 0; i < categories.size(); i++){
            System.out.println( (i + 1) + ": " + categories.get(i).getName());
        }

        int choice = 0;
        try{
            choice = Integer.parseInt(s.next().trim());
        } catch (NumberFormatException e){
            return;
        }

        if(choice < 1 || choice > categories.size()) return;
        Category category = categories.get(choice - 1);
        questionCategory = category.toString();
        chosenCategory = category.getName();
    }

    private static void clearAllValues() {
        questionCategory = "";
        chosenCategory = "";
        questionsToAnswer = 0;
    }
}
