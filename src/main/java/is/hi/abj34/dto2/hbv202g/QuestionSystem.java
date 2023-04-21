package is.hi.abj34.dto2.hbv202g;

import java.util.ArrayList;
import java.util.List;

public class QuestionSystem {
    private static ArrayList<Category> categories = new ArrayList<Category>();
    private static ArrayList<Question> questions = new ArrayList<Question>();

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

    public static List<Question> getQuestions(){
        return new ArrayList<Question>(questions);
    }
}
