import java.util.Scanner;
public class StudentGradeCalculator
{
    // Function to calculate average grade
    public static double calculateAverage(double[] grades)
    {
        double sum = 0;
        for (double grade : grades)
        {
            sum += grade;
        }
        return sum / grades.length;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Student Grade Calculator");
        System.out.print("Enter the number of grades to be entered: ");
        int numberOfGrades = sc.nextInt();

        double[] grades = new double[numberOfGrades];

        for (int i = 0; i < numberOfGrades; i++)
        {
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades[i] = sc.nextDouble();
        }
        // Calculating average
        double average = calculateAverage(grades);
        // Displaying average
        System.out.println("\nAverage Grade: " + average);

        sc.close();
    }
}