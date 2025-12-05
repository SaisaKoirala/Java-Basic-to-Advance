import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name of the student: ");
        String name = sc.next();
        // 1. Input number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = sc.nextInt();

        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        // 2. Input marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = sc.nextInt();

            // Basic validation
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks. Please enter a value between 0 and 100.");
                i--; // Repeat the same subject input
                continue;
            }

            totalMarks += marks[i];
        }

        // 3. Calculate average percentage
        double average = (double) totalMarks / numSubjects;

        // 4. Grade calculation
        String grade;
        if (average >= 90) {
            grade = "A+";
        } else if (average >= 80) {
            grade = "A";
        } else if (average >= 70) {
            grade = "B";
        } else if (average >= 60) {
            grade = "C";
        } else if (average >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        // 5. Display results
        System.out.println("\n--- "+ name + "\'s Result ---");
        System.out.println("Total Marks: " + totalMarks + " out of " + (numSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", average);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}
