import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Number Guessing - CodSoft Game\n");
        System.out.println("I am thinking of a number between 1 and 100");

        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int attemptsAllowed = 10;
        int attempts = 0;

        System.out.println("You have " + attemptsAllowed + " attempts");

        Scanner sc = new Scanner(System.in);

        while (attempts < attemptsAllowed) {
            System.out.print("Attempt number " + (attempts + 1) + ": Guess a number: ");
            int userGuessedNumber;

            // Input validation
            try {
                userGuessedNumber = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            attempts++;

            if (userGuessedNumber == numberToGuess) {
                System.out.println("You guessed " + numberToGuess + " correctly in " + attempts + " attempt(s)!");
                break;
            } else if (userGuessedNumber > numberToGuess) {
                System.out.println("Try a lower number.");
            } else {
                System.out.println("Try a higher number.");
            }

            if (attempts == attemptsAllowed) {
                System.out.println("You've used all your attempts. The correct number was " + numberToGuess + ".");
            }
        }

        sc.close();
    }
}
