package is.hi.abj34.dto2.hbv202g;

import java.util.List;

public class Category {
    private String name;
    private int questionsCount;

    public Category(String name) throws EmptyStringException {
        if(name == null || name.trim() == "") throw new EmptyStringException("Category name can't be empty");
        this.name = name;
        this.questionsCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getQuestionsCount() {
        return questionsCount;
    }

    // Update questionCount
    public void updateQuestionCount(){
        this.questionsCount++;
    }
}
