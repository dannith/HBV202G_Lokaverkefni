package is.hi.abj34.dto2.hbv202g;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateCategory {

    public static void view() {
        System.out.println("##############################");
        System.out.println("Categories: ");
        List<Category> categories = QuestionSystem.getCategories();
        for(int i = 0; i < categories.size(); i++){
            System.out.println(categories.get(i).getName());
        }
        System.out.println("1. New Category");
        System.out.println("2. Back to main menu");

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        String choice = scanner.next().trim();
        switch (choice){
            case "1":
                newCategoryView(scanner);
                break;
            case "2":
                App.mainMenu();
                break;
            default:
                view();
                break;
        }
    }

    private static void newCategoryView(Scanner s){
        System.out.print("Name of new category: ");
        Category newCategory = null;
        boolean valid = true;
        try{
            newCategory = new Category(s.next());
        } catch (EmptyStringException e) {
            valid = false;
        }
        if(valid) QuestionSystem.addCategory(newCategory);
        view();
    }
}
