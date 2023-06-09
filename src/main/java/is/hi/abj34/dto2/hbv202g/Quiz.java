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
            System.out.println("Question " + (i+1) + ". " + questions.get(i).getTitle());
            int correctAnswer = 0;
            int questionNumber = 1;
            for (String key : questions.get(i).getOptions().keySet()) {
                if(Boolean.TRUE.equals(questions.get(i).getOptions().get(key))) {
                    correctAnswer = questionNumber;
                }
                System.out.println(questionNumber + ". " + key);
                questionNumber++;
            }
            int choice = input.nextInt();
            String attempt = getRightAnswers(correctAnswer, choice);
            System.out.println(attempt);
        }

        System.out.println(breaker);
        System.out.println("Your score is " + rightAnswers + " out of " + questions.size());
        System.out.println("Returning to main menu");
        clearAllValues();
        App.mainMenu();
    }

    private static String getRightAnswers(int correct, int choice) {
        if (correct == choice) {
            rightAnswers++;
            return "Correct!";
        }
        return "Wrong!";
    }

    private static void clearAllValues() {
        rightAnswers = 0;
    }
    
}