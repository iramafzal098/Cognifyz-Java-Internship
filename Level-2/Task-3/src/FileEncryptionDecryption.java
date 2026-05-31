import java.io.*;
import java.util.Scanner;

public class FileEncryptionDecryption
{

    public static String encryptText(String text)
    {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++)
        {
            result.append((char)(text.charAt(i) + 3));
        }

        return result.toString();
    }

    public static String decryptText(String text)
    {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++)
        {
            result.append((char)(text.charAt(i) - 3));
        }

        return result.toString();
    }

    public static String readFile(String filePath) throws IOException
    {
        StringBuilder data = new StringBuilder();

        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;

        while ((line = reader.readLine()) != null)
        {
            data.append(line).append("\n");
        }

        reader.close();

        return data.toString();
    }

    public static void writeFile(String filePath, String content) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

        writer.write(content);

        writer.close();
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        try
        {
            System.out.println("File Encryption / Decryption");

            System.out.print("Enter file path: ");
            String filePath = sc.nextLine();

            System.out.print("Enter E for Encryption or D for Decryption: ");
            char choice = sc.next().toUpperCase().charAt(0);

            String originalData = readFile(filePath);

            String finalData;
            String outputFile;

            if (choice == 'E')
            {
                finalData = encryptText(originalData);
                outputFile = "encrypted_output.txt";

                writeFile(outputFile, finalData);

                System.out.println("File encrypted successfully.");
                System.out.println("Saved as: " + outputFile);
            }
            else if (choice == 'D')
            {
                finalData = decryptText(originalData);
                outputFile = "decrypted_output.txt";

                writeFile(outputFile, finalData);

                System.out.println("File decrypted successfully.");
                System.out.println("Saved as: " + outputFile);
            }
            else
            {
                System.out.println("Invalid choice.");
            }
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}