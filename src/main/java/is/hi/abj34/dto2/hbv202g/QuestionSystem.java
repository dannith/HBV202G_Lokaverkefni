package is.hi.abj34.dto2.hbv202g;

import java.util.ArrayList;
import java.util.List;

public class QuestionSystem {
    private static ArrayList<Category> categories = new ArrayList<>();
    private static ArrayList<Question> questions = new ArrayList<>();

    public QuestionSystem() {
        //this.categories = new ArrayList<>();
    }


    /// Input/Output methods 
    // Add Category - while loop um hvað þú vilt velja
    public static void addCategory(Category category){
        boolean valid = true;
        for(Category cat : categories){
            if(cat.getName().equalsIgnoreCase(category.getName().toLowerCase())) valid = false;
        }
        if(valid) categories.add(category);
    }

    public static List<Category> getCategories(){
        return new ArrayList<Category>(categories);
    }

    public static void addQuestion(Question question) {
        questions.add(question);
    }

    public static void updateQuestionCount(List<Category> questionCategories) {
        for(Category category : categories)
            for(Category questionCategory : questionCategories)
                if(category.getName().equals(questionCategory.getName()))
                    category.updateQuestionCount();
    }

    // Add Question and options

    // Choose category and how many questions to answer - sér java file - Filtering.java

    // Display question or choose what questions will be asked - Sama of fyrir ofan - Filtering.java

    // Answer question and whether right - sér java file - Answering.java

    // Scores for questions - Sama og fyrir ofan - Answering.java

}
