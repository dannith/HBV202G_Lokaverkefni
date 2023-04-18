package is.hi.abj34.dto2.hbv202g;

import java.util.List;
import java.util.Scanner;

public class Quiz {

    //List af questions
    static String breaker = "##############################";

    private static int rightAnswers = 0;

    public static void takeQuiz(List<Question> questions) {
        Scanner input = new Scanner(System.in);

        System.out.println(breaker);
        for(int i = 0; i < questions.size(); i++) {
            System.out.println(i + ". " + questions.get(i).getTitle());
            int correctAnswer = 0;
            int questionNumber = 1;
            for (String key : questions.get(i).getOptions().keySet()) {
                if(questions.get(i).getOptions().get(key) == true) {
                    correctAnswer = questionNumber;
                }
                System.out.println(questionNumber + ". " + key);
            }
            int choice = input.nextInt();
            String attempt = getRightAnswers(correctAnswer, choice);
            System.out.println(attempt);
        }

        System.out.println(breaker);
        System.out.println("Your score is " + rightAnswers + " out of " + questions.size());
        System.out.println("Returning to main menu");
        App.mainMenu();
    }

    public static String getRightAnswers(int correct, int choice) {
        if (correct == choice) {
            rightAnswers++;
            return "Correct!";
        }
        return "Wrong!";
    }
    
}