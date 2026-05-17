import java.util.Random;
import java.util.Scanner;
public class RandomPasswordGenerator
{
    // Function to generate password
    public static String generatePassword(int length, String characters)
    {
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++)
        {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialCharacters = "!@#$%^&*";

        String characterPool = "";

        System.out.println("Random Password Generator");

        System.out.print("Enter desired password length: ");
        int length = sc.nextInt();

        System.out.print("Include uppercase letters? (true/false): ");
        boolean includeUppercase = sc.nextBoolean();

        System.out.print("Include lowercase letters? (true/false): ");
        boolean includeLowercase = sc.nextBoolean();

        System.out.print("Include numbers? (true/false): ");
        boolean includeNumbers = sc.nextBoolean();

        System.out.print("Include special characters? (true/false): ");
        boolean includeSpecial = sc.nextBoolean();

        // Building character pool
        if (includeUppercase)
        {
            characterPool += uppercase;
        }

        if (includeLowercase)
        {
            characterPool += lowercase;
        }

        if (includeNumbers)
        {
            characterPool += numbers;
        }

        if (includeSpecial)
        {
            characterPool += specialCharacters;
        }

        // Checking if no option selected
        if (characterPool.isEmpty())
        {
            System.out.println("No character type selected!");
            return;
        }

        // Generating password
        String password = generatePassword(length, characterPool);
        System.out.println("\nGenerated Password: " + password);

        sc.close();
    }
}