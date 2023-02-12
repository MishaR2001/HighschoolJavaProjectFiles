import java.util.Scanner;

/**
 * Plays the classic game Hangman
 * 
 * @author: Misha R and Greyson S
 */
public class Hangman2018 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to Hangman!");
		String wordToGuess = generateRandomWord();
		String wrongLetterGuesses = "";
		String correctLetterGuesses = "";
		String input = "";

		// write all the code for the following instructions...

		// In the game Hangman... the player has one wordToGuess.
		// The game will printWordToGuess by showing how many letters are in the word
		// as a series of blanks and correctLetterGuesses.
		// Example: _ I _ I _ G _ if wordToGuess is "VIKINGS"
		// and I and G have been input as guesses

		// The player will win if they input the wordToGuess correctly.
		// They do this by entering an all-caps word instead of a single letter.

		// The player will lose if they input more than 6 letter guesses OR
		// they input the wrong wordToGuess.

		// YOUR CODE GOES HERE
		while (wrongLetterGuesses.length() < 6) {
			printHangman(wrongLetterGuesses.length());
			printWordToGuess(wordToGuess, correctLetterGuesses);
			System.out.print("Enter a letter or guess the word: ");
			input = keyboard.nextLine();
			if (input.length() > 1) {
				if (input.equals(wordToGuess)) {
					System.out.print("CORRECT GUESS, YOU WIN!");
					break;
				} else {
					System.out.print("INCORRECT GUESS, YOU LOSE!");
					break;
				}
			}
			if (input.length() == 1 && wordToGuess.indexOf(input) == -1) {
				wrongLetterGuesses += input;
			} else if (input.length() == 1 && wordToGuess.indexOf(input) != -1) {
				correctLetterGuesses += input;
			}
			if (wrongLetterGuesses.length() == 6) {
				System.out.print("YOU LOSE!\n");
				printHangman(6);
				System.out.print("The answer is " + wordToGuess);
				break;
			}
		}

		// Write a loop that will continue until the player has attempted
		// 6 letter guesses (i.e. the length of String wrongLetterGuesses).

		// // Invoke (i.e. call) method printHangman with the number of
		// wrongLetterGuesses

		// // Invoke printWordToGuess method (i.e. call the printWordToGuess method)
		// // with arguments wordToGuess and correctLetterGuesses

		// // Print "Enter a letter or guess the word".
		// // Read an input String from the keyboard... keyboard.nextLine()
		//
		// // If input has more than one letter then check the following:
		// //// if input equals wordToGuess ..... print "CORRECT GUESS, YOU WIN!"
		// //// and break the loop, otherwise ..print "INCORRECT GUESS, YOU LOSE!"
		// //// and break the loop.
		//
		// // If input has only one letter and that letter is NOT in wordToGuess,
		// //// append the letter to wrongLetterGuesses.
		// // If input has only one letter and that letter IS in wordToGuess,
		// //// append the letter to correctLetterGuesses.
		// // If wrongLetterGuesses has 6 letters then
		// //// print "YOU LOSE!\n" and invoke printHangman(6) and break the loop

		// Write method printWordToGuess..

	}

	/**
	 * <pre>
	 * write a loop to System.out.print the wordToGuess letter by letter
	 * but actually prints a "_ " for any letter not in correctLetterGuesses 
	 *   (hint: use indexOf)
	 * </pre>
	 */
	public static void printWordToGuess(String wordToGuess, String correctLetterGuesses) {

		int len = wordToGuess.length();

		for (int i = 0; i < len; i++) {
			String letter = wordToGuess.substring(i, i + 1);
			if (correctLetterGuesses.indexOf(letter) != -1) {
				System.out.print(letter + " ");
			} else {
				System.out.print("_ ");
			}
		}

	}

	/**
	 * draws n pieces of the Hangman to the standard output
	 */
	public static void printHangman(int n) {

		if (n == 0) {
			System.out.println();
			System.out.println("+-----+  ");
			System.out.println("|        ");
			System.out.println("|        ");
			System.out.println("|        ");
			System.out.println("|________");
		}
		if (n == 1) {
			System.out.println();
			System.out.println("+-----+  ");
			System.out.println("|     0  ");
			System.out.println("|        ");
			System.out.println("|        ");
			System.out.println("|________");
		}
		if (n == 2) {
			System.out.println();
			System.out.println("+-----+  ");
			System.out.println("|     0  ");
			System.out.println("|     |  ");
			System.out.println("|        ");
			System.out.println("|________");
		}
		if (n == 3) {
			System.out.println();
			System.out.println("+-----+  ");
			System.out.println("|     0  ");
			System.out.println("|     |\\");
			System.out.println("|        ");
			System.out.println("|________");
		}
		if (n == 4) {
			System.out.println();
			System.out.println("+-----+  ");
			System.out.println("|     0  ");
			System.out.println("|    /|\\");
			System.out.println("|        ");
			System.out.println("|________");
		}
		if (n == 5) {
			System.out.println();
			System.out.println("+-----+  ");
			System.out.println("|     0  ");
			System.out.println("|    /|\\");
			System.out.println("|    /   ");
			System.out.println("|________");
		}

		if (n == 6) {
			System.out.println();
			System.out.println("+-----+  ");
			System.out.println("|     0  ");
			System.out.println("|    /|\\");
			System.out.println("|    / \\");
			System.out.println("|________");
			System.out.println("GAME OVER");
		}

		System.out.println("You have made " + n + " out of 6 incorrect guesses");
		// replace this with ascii hangman drawing

	}

	/**
	 * returns a random word .. all caps
	 */
	public static String generateRandomWord() {
		String words[] = { "NILES", "NORTH", "VIKINGS", "COMPUTER", "SCIENCE" };
		return words[(int) (Math.random() * words.length)];
	}
}
