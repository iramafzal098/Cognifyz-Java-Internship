import java.util.Scanner;
public class TemperatureConverter
{
    public static double celsiusToFahrenheit(double celsius)
    {
        return (celsius * 9 / 5) + 32;
    }
    public static double fahrenheitToCelsius(double fahrenheit)
    {
        return (fahrenheit - 32) * 5 / 9;
    }


    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int choice;

        do
        {
            System.out.println("\nTemperature Converter");
            System.out.println("1.Celsius to Fahrenheit");
            System.out.println("2.Fahrenheit to Celsius");
            System.out.println("3.Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            switch (choice)
            {

                case 1:

                    System.out.print("Enter temperature in Celsius: ");
                    double celsius = sc.nextDouble();

                    double fahrenheit = celsiusToFahrenheit(celsius);

                    System.out.println("Converted Temperature: " + fahrenheit + " °F");
                    break;

                case 2:

                    System.out.print("Enter temperature in Fahrenheit: ");
                    double fahrenheitInput = sc.nextDouble();

                    double celsiusResult = fahrenheitToCelsius(fahrenheitInput);

                    System.out.println("Converted Temperature: " + celsiusResult + " °C");
                    break;

                case 3:

                    System.out.println("Program Closed.");
                    break;

                default:

                    System.out.println("Invalid choice!! Please try again.");
            }

        } while (choice != 3);

        sc.close();
    }
}

