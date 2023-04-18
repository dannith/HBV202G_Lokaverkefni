package is.hi.abj34.dto2.hbv202g;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateCategory {

    static ArrayList<String> categories = new ArrayList<String>();

    public static void view() {
        System.out.println("##############################");
        System.out.println("Categories: ");
        String line = "";
        for(int i = 0; i < categories.size(); i++){
            if(line.length() + categories.get(i).length() < 32) line += categories.get(i)+", ";
            else{
                System.out.println(line);
                line = "";
            }
        }
        if(line.length() > 0) System.out.println(line);
        System.out.println("1. New Category");
        System.out.println("2. Back to main menu");

        Scanner input = new Scanner(System.in).useDelimiter("\n");
        int choice = input.nextInt();
        switch (choice){
            case 1:
                System.out.print("Name of new category: ");
                String newCategory = input.next();
                if(!categories.contains(newCategory)) categories.add(newCategory);
                view();
                break;
            case 2:
                App.mainMenu();
                break;
        }
    }
}
