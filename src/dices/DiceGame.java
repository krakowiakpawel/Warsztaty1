package dices;

import java.util.Random;
import java.util.Scanner;

public class DiceGame {
	public static void main(String[] args) {
		try {
			String input = getData().replaceAll(" ", "");
			// X
			String[] parts = input.split("D");
			int x = 1;
			int dIndex = input.indexOf('D');
			if (dIndex != 0) {
				x = Integer.parseInt(parts[0]);
			}
			// X

			// Z
			int z = 0;
			int plusIndex = input.indexOf('+');
			int minusIndex = input.indexOf('-');
			int zIndex = input.length();
			if ((plusIndex != -1) || (minusIndex != -1)) {
				zIndex = Math.max(plusIndex, minusIndex);

				String str = input.substring(zIndex + 1);
				if (plusIndex != -1) {
					z += Integer.parseInt(str);
				} else {
					z -= Integer.parseInt(str);
				}
			}
			// Z

			// Y
			int y = 1;
			String strY = input.substring(dIndex + 1, zIndex);
			y = Integer.parseInt(strY);
			int[] legalDice = { 3, 4, 6, 8, 10, 12, 20, 100 };
			boolean diceExists = arrHasInt(legalDice, y);
			// Y

			if (!(diceExists)) {
				System.out.println("Nie ma takiej kostki!");
			} else {
				System.out.println("Twój wynik to " + getFinalResult(x, y, z));
			}
		} catch (Exception e) {
			System.out.println("Błąd danych!");
		}

	}

	public static String getData() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Podaj dane");
		String result = scan.nextLine();
		scan.close();
		return result;
	}

	static int diceRoller(int range) {
		Random generator = new Random();
		int result = generator.nextInt(range) + 1;
		return result;
	}

	static int getFinalResult(int x, int y, int z) {
		int diceSum = 0;
		for (int i = 0; i < x; i++) {
			diceSum += diceRoller(y);
		}
		int finalResult = diceSum + z;
		return finalResult;
	}

	static boolean arrHasInt(int[] input, int num) {

		for (int i = 0; i < input.length; i++) {
			if (input[i] == num) {
				return true;
			}
		}
		return false;
	}

}
