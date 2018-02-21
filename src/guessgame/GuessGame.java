package guessgame;

import java.util.Random;
import java.util.Scanner;

public class GuessGame {
	public static void main(String[] args) {
		System.out.println("Witamy w grze");
		Random generator = new Random();
		int goal = generator.nextInt(100) + 1;
		goal = 55;
		int userGuess = userGuess();
		int count = 1;

		while (userGuess != goal) {

			if (userGuess == 666) {
				System.out.println("Oszukujesz!");
				break;
			} else if (userGuess > goal) {
				System.out.println("Za dużo!");
			} else {
				System.out.println("Za mało!");
			}
			userGuess = userGuess();
			count++;
		}
		if (userGuess != 666) {
		System.out.println("Sukces!");
		System.out.println("Ilość prób: " + count);
		} else {
			System.out.println("Koniec gry");
		}
			

	}

	static int userGuess() {
		System.out.println("Wpisz liczbę:");
		Scanner scan = new Scanner(System.in);
		String guess = scan.next();
		while (!(isNumeric(guess))) {
			System.out.println("To nie liczba! Wpisz ponownie ");
			guess = scan.next();
		}
		int guessInt = Integer.parseInt(guess);
		return guessInt;
	}

	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
// while (true){
// if (scan.hasNexInt()) {
// int input = scan.nextInt();
// } else {
// System.out.println("Wpisz liczbę!");
// scan.nextLine();
// }
// }