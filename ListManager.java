import java.util.ArrayList;
import java.util.Scanner;

public class ListManager
{
    private static ArrayList<Integer> list = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("Enter nums with space: ");
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");
        for (String number : numbers)
        {
            try
            {
                list.add(Integer.parseInt(number));
            }
            catch (NumberFormatException e)
            {
                System.out.println("Incorrect: " + number);
            }
        }
        boolean running = true;
        while (running)
        {
            showMenu();
            int choice = getUserChoice();
            switch (choice)
            {
                case 1 -> addElement();
                case 2 -> removeElement();
                case 3 -> showList();
                case 4 -> checkElement();
                case 5 -> replaceElement();
                case 0 ->
                {
                    System.out.println("Exit.");
                    running = false;
                }
                default -> System.out.println("Incorrect. Try again.");
            }
        }
    }
    private static void showMenu()
    {
        System.out.println("\nMenu:");
        System.out.println("1. Add element in list");
        System.out.println("2. Delete element from list");
        System.out.println("3. Show list");
        System.out.println("4. Check if the value is in the list");
        System.out.println("5. Change a value in a list");
        System.out.println("0. Exit");
        System.out.print("Select action: ");
    }
    private static int getUserChoice()
    {
        try
        {
            return Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException e)
        {
            System.out.println("Enter num.");
            return -1;
        }
    }
    private static void addElement()
    {
        System.out.print("Enter num for adding: ");
        try
        {
            int element = Integer.parseInt(scanner.nextLine());
            list.add(element);
            System.out.println("Element added.");
        }
        catch (NumberFormatException e)
        {
            System.out.println("Incorrect.");
        }
    }
    private static void removeElement()
    {
        System.out.print("Enter index for deleting: ");
        try
        {
            int index = Integer.parseInt(scanner.nextLine());
            if (index >= 0 && index < list.size())
            {
                list.remove(index);
                System.out.println("Element removed.");
            }
            else
            {
                System.out.println("Incorrect index.");
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("Incorrect.");
        }
    }
    private static void showList()
    {
        System.out.println("List: " + list);
    }
    private static void checkElement()
    {
        System.out.print("Enter the value to check: ");
        try
        {
            int element = Integer.parseInt(scanner.nextLine());
            if (list.contains(element))
            {
                System.out.println("The value is present in the list.");
            }
            else
            {
                System.out.println("The value is not in the list.");
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("Incorrect.");
        }
    }
    private static void replaceElement()
    {
        System.out.print("Enter index to replace: ");
        try
        {
            int index = Integer.parseInt(scanner.nextLine());
            if (index >= 0 && index < list.size())
            {
                System.out.print("Enter new value: ");
                int newValue = Integer.parseInt(scanner.nextLine());
                list.set(index, newValue);
                System.out.println("Value replaced.");
            }
            else
            {
                System.out.println("Incorrect index.");
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("Incorrect.");
        }
    }
}
