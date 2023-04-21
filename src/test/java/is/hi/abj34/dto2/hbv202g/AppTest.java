package is.hi.abj34.dto2.hbv202g;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    private String title;

    private String categoryName;
    private Category category;
    private Map<String, Boolean> options;

    private Question question;

    @Before
    public void initOptions(){
        options = new HashMap<>();
    }

    @Test(expected = EmptyOptionsMapException.class)
    public void testNoOptionsQuestion() throws EmptyStringException, NoCategoryException, EmptyOptionsMapException {
        title = "Hvað heitir þú?";
        category = new Category("Nöfn");
        question = new Question(title, options, category);
    }

    @Test(expected = EmptyOptionsMapException.class)
    public void testOneOptionQuestion() throws EmptyStringException, NoCategoryException, EmptyOptionsMapException {
        title = "Hvað heitir þú?";
        category = new Category("Nöfn");
        options.put("Rétt Svar", true);
        question = new Question(title, options, category);
    }

    @Test(expected = NoCategoryException.class)
    public void testNoCategoryQuestion() throws NoCategoryException, EmptyOptionsMapException {
        title = "Hvað heitir þú?";
        options.put("Rétt Svar", true);
        options.put("Rangt Svar", true);
        category = null;
        question = new Question(title, options, category);
    }

    @Test
    public void testCategoryQuestionCountIncrease() throws EmptyStringException, NoCategoryException, EmptyOptionsMapException {
        title = "Hvað heitir þú?";
        category = new Category("Nöfn");
        options.put("Rétt Svar", true);
        options.put("Rangt Svar", true);
        int questionCountBefore = category.getQuestionsCount();

        question = new Question(title, options, category);
        assertNotEquals(questionCountBefore, category.getQuestionsCount());
    }

    @Test(expected = EmptyStringException.class)
    public void testEmptyNameCategory() throws EmptyStringException {
        categoryName = "";
        category = new Category(categoryName);
    }

    @Test(expected = EmptyStringException.class)
    public void testWhitespaceNameCategory() throws EmptyStringException {
        categoryName = "     ";
        category = new Category(categoryName);
    }

    @Test(expected = EmptyStringException.class)
    public void testNullNameCategory() throws EmptyStringException {
        categoryName = null;
        category = new Category(categoryName);
    }
}
