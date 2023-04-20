package is.hi.abj34.dto2.hbv202g;

import java.awt.desktop.SystemEventListener;
import java.util.*;

public class CreateQuestion {

    private static String breaker = "##############################";

    static String title = "";
    static String answer = "";
    static ArrayList<String> wrongAnswers = new ArrayList<String>();
    static Category questionCategory;

    public static void view() {
        System.out.println(breaker);
        System.out.println("Please fill in all fields: ");
        System.out.println("1. Question: " + title);
        System.out.println("2. Answer: " + answer);
        System.out.println("3. Wrong answers: " + wrongAnswers);
        System.out.println("4. Category: " + questionCategory);
        if(validateQuestion()) System.out.println("5. Confirm and create question");
        else System.out.println("5. ....: ");
        System.out.println("6. Back to main menu");

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        String choice = scanner.next().trim();
        switch(choice) {
            case "1":
                titleView(scanner);
                view();
                break;
            case "2":
                answerView(scanner);
                view();
                break;
            case "3":
                wrongAnswersView(scanner);
                view();
                break;
            case "4":
                categoryView(scanner);
                view();
                break;
            case "5":
                if(!validateQuestion()) System.out.println("Please fill in fields 1 - 4: ");
                else{
                    try{
                        confirmQuestion();
                    } catch (EmptyCategoryListException | EmptyOptionsMapException e) {
                        System.out.println(e.getMessage());
                    }
                }
                App.createMenu();
                break;
            case "6":
                App.mainMenu();
                break;
            default:
                System.out.println("Invalid choice");
                view();
        }
    }

    private static void confirmQuestion() throws EmptyCategoryListException, EmptyOptionsMapException {
        Map<String, Boolean> questionChoices = new HashMap<>();
        questionChoices.put(answer, true);
        for(String wrong : wrongAnswers) questionChoices.put(wrong, false);
        Question question = new Question(title, questionChoices, questionCategory);
        QuestionSystem.addQuestion(question);
    }

    private static boolean validateQuestion() {
        return !(title.equals("") || answer.equals("") || wrongAnswers.size() == 0 || questionCategory == null);
    }


    private static void titleView(Scanner s) {
        System.out.println(breaker);
        System.out.print("Enter the question: ");
        while(title.equals("")) title = s.next().trim();
    }
    private static void answerView(Scanner s) {
        System.out.println(breaker);
        System.out.print("Enter the right answer: ");
        while(answer.equals("")) answer = s.next().trim();
    }
    private static void wrongAnswersView(Scanner s) {
        System.out.println(breaker);
        System.out.print("Enter an incorrect answer: ");
        String wrongAnswer = "";
        while(wrongAnswer.equals("") || wrongAnswers.contains(wrongAnswer)) wrongAnswer = s.next().trim();
        wrongAnswers.add(wrongAnswer);
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
        questionCategory = category;
    }
}