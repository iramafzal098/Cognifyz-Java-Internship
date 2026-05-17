import java.util.Scanner;
public class PalindromeChecker
{
    // Function to check palindrome
    public boolean isPalindrome(String s)
    {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            //Ignore non-alphanumeric from left
            if (!Character.isLetterOrDigit(s.charAt(i)))
            {
                i++;
            }
            //Ignore non-alphanumeric from right
            else if (!Character.isLetterOrDigit(s.charAt(j)))
            {
                j--;
            }

            // Compare characters ignoring case
            else if (Character.toLowerCase(s.charAt(i)) !=
                    Character.toLowerCase(s.charAt(j)))
            {
                return false;
            }

            // Move both pointers
            else
            {
                i++;
                j--;
            }
        }

        return true;
    }


    public static void main(String[] args)
    {
        // Take input from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        // Create object
        PalindromeChecker obj = new PalindromeChecker();
        boolean result = obj.isPalindrome(s);
        System.out.println("Is Palindrome: " + result);

        sc.close();
    }
}