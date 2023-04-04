package is.hi.abj34.dto2.hbv202g;

import java.util.List;

public class Category {
    private String name;

    private int questionsCount;

    public Category(String name, int questionsCount) {
        this.name = name;
        this.questionsCount = questionsCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuestionsCount() {
        return questionsCount;
    }

    // Update questionCount

    // Raise questionCount
}
