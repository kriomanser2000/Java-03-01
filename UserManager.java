import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserManager
{
    private static final Map<String, String> users = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {
        while (true)
        {
            System.out.println("\nMenu:");
            System.out.println("1. Add new user");
            System.out.println("2. Delete user");
            System.out.println("3. Check if the user exists");
            System.out.println("4. Change the login of an existing user");
            System.out.println("5. Change the password of an existing user");
            System.out.println("6. Exit");
            System.out.print("Select action: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice)
            {
                case 1 -> addUser();
                case 2 -> deleteUser();
                case 3 -> checkUser();
                case 4 -> changeLogin();
                case 5 -> changePassword();
                case 6 ->
                {
                    System.out.println("Exiting.");
                    return;
                }
                default -> System.out.println("Incorrect. try again.");
            }
        }
    }
    private static void addUser()
    {
        System.out.print("Enter the login of the new user: ");
        String login = scanner.nextLine();
        if (users.containsKey(login))
        {
            System.out.println("A user with this login already exists.");
        }
        else
        {
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            users.put(login, password);
            System.out.println("User added successfully.");
        }
    }
    private static void deleteUser()
    {
        System.out.print("Enter the user login to delete: ");
        String login = scanner.nextLine();
        if (users.remove(login) != null)
        {
            System.out.println("User deleted successfully.");
        }
        else
        {
            System.out.println("User with this login was not found.");
        }
    }
    private static void checkUser()
    {
        System.out.print("Enter your login for verification: ");
        String login = scanner.nextLine();
        if (users.containsKey(login))
        {
            System.out.println("The user exists.");
        }
        else
        {
            System.out.println("User with this login was not found.");
        }
    }
    private static void changeLogin()
    {
        System.out.print("Enter your current login: ");
        String currentLogin = scanner.nextLine();
        if (users.containsKey(currentLogin))
        {
            System.out.print("Enter a new login: ");
            String newLogin = scanner.nextLine();
            if (users.containsKey(newLogin))
            {
                System.out.println("New login already exists. The operation is not possible.");
            }
            else
            {
                String password = users.remove(currentLogin);
                users.put(newLogin, password);
                System.out.println("Login changed successfully.");
            }
        }
        else
        {
            System.out.println("User with this login was not found.");
        }
    }
    private static void changePassword()
    {
        System.out.print("Enter your user login to change your password: ");
        String login = scanner.nextLine();
        if (users.containsKey(login))
        {
            System.out.print("Enter a new password: ");
            String newPassword = scanner.nextLine();
            users.put(login, newPassword);
            System.out.println("Password changed successfully.");
        }
        else
        {
            System.out.println("User with this login was not found.");
        }
    }
}
