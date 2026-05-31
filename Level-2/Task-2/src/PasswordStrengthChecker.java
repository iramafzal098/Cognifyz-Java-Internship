import java.util.Scanner;

public class PasswordStrengthChecker
{
    public static boolean containsCapital(String text)
    {
        for (int index = 0; index < text.length(); index++)
        {
            if (Character.isUpperCase(text.charAt(index)))
            {
                return true;
            }
        }

        return false;
    }

    public static boolean containsSmall(String text)
    {
        for (int index = 0; index < text.length(); index++)
        {
            if (Character.isLowerCase(text.charAt(index)))
            {
                return true;
            }
        }

        return false;
    }

    public static boolean containsDigit(String text)
    {
        for (int index = 0; index < text.length(); index++)
        {
            if (Character.isDigit(text.charAt(index)))
            {
                return true;
            }
        }

        return false;
    }

    public static boolean containsSymbol(String text)
    {
        for (int index = 0; index < text.length(); index++)
        {
            char currentCharacter = text.charAt(index);

            if (!Character.isLetterOrDigit(currentCharacter))
            {
                return true;
            }
        }

        return false;
    }

    public static int evaluatePassword(String text)
    {
        int points = 0;

        if (text.length() >= 8)
        {
            points++;
        }

        if (containsCapital(text))
        {
            points++;
        }

        if (containsSmall(text))
        {
            points++;
        }

        if (containsDigit(text))
        {
            points++;
        }

        if (containsSymbol(text))
        {
            points++;
        }

        return points;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Password Strength Checker");

        System.out.print("Enter your password: ");
        String userInput = sc.nextLine();

        int rating = evaluatePassword(userInput);

        System.out.println("\nPassword Report");
        System.out.println("Minimum Length Met: " + (userInput.length() >= 8));
        System.out.println("Has Capital Letter: " + containsCapital(userInput));
        System.out.println("Has Small Letter: " + containsSmall(userInput));
        System.out.println("Has Numeric Value: " + containsDigit(userInput));
        System.out.println("Has Special Symbol: " + containsSymbol(userInput));

        System.out.print("\nStrength Level: ");

        if (rating <= 2)
        {
            System.out.println("Weak");
        }
        else if (rating <= 4)
        {
            System.out.println("Medium");
        }
        else
        {
            System.out.println("Strong");
        }

        sc.close();
    }
}