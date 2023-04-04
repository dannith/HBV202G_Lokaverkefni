package is.hi.abj34.dto2.hbv202g;

import java.util.List;
import java.util.Map;

public class Question {
    String title;

    Map<String, Boolean> options;

    List<Category> categories;

    public Question(String title, Map<String,Boolean> options, List<Category> categories) throws EmptyOptionsMapException, EmptyCategoryListException {
        this.title = title;
        if(options.size() < 2) throw new EmptyOptionsMapException("Question needs to have at least two options");
        this.options = options;
        if(categories.size() == 0) throw new EmptyCategoryListException("Question needs to have categories");
        this.categories = categories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, Boolean> getOptions() {
        return options;
    }

    public void addOption(String option, Boolean value) {
        this.options.put(option, value);
    }
}
