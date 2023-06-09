package is.hi.abj34.dto2.hbv202g;

import java.util.Map;

public class Question {
    String title;

    Map<String, Boolean> options;

    Category category;

    public Question(String title, Map<String,Boolean> options, Category category) throws EmptyOptionsMapException, NoCategoryException {
        this.title = title;
        if(options.size() < 2) throw new EmptyOptionsMapException("Question needs to have at least two options");
        this.options = options;
        if(category == null) throw new NoCategoryException("Question needs to be in a category");
        this.category = category;
        category.updateQuestionCount();
    }

    public String getTitle() {
        return title;
    }

    public Map<String, Boolean> getOptions() {
        return options;
    }

    public Category getCategory() {
        return category;
    }

    public String getStringedCategory() {
        return category.getName();
    }
}
