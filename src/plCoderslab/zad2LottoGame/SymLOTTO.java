package plCoderslab.zad2LottoGame;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SymLOTTO {
	public static void main(String[] args) {

		int inputNum[] = getData();
		// Drawing procedure
		System.out.println("Wylosowane liczby:");
		Integer[] arr = new Integer[49];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		Collections.shuffle(Arrays.asList(arr));
		Integer[] lottoNumTemp = Arrays.copyOf(arr, 6);
		int[] lottoNum = integerToInt(lottoNumTemp);
		Arrays.sort(lottoNum);
		System.out.println(Arrays.toString(lottoNum));
		// Drawing procedure end

		int hits = (checkResult(inputNum, lottoNum));

		if (hits < 1) {
			System.out.println("Słabo. Zagraj jeszcze raz");
		} else if (hits == 1) {
			System.out.println("Jedynka!");
		} else if (hits == 2) {
			System.out.println("Dwójka!");
		} else if (hits == 3) {
			System.out.println("Trójka!");
		} else if (hits == 4) {
			System.out.println("Czwórka");
		} else if (hits == 5) {
			System.out.println("Piątka!");
		} else if (hits == 6) {
			System.out.println("Szóstka");
		}

	}

	static int[] getData() { // Get data from User
		Scanner scan = new Scanner(System.in);
		int[] inputNum = new int[6];
		String liczebniki[] = { "pierwszą", "drugą", "trzecią", "czwartą", "piątą", "szóstą" };
		for (int i = 0; i < inputNum.length; i++) {
			System.out.println("Wpisz " + liczebniki[i] + " liczbę");
			inputNum[i] = checkDuplicate(inputNum, (checkLimits(getInt())));

		}
		Arrays.sort(inputNum);
		System.out.println("Twój typ to:");
		System.out.println(Arrays.toString(inputNum));

		return inputNum;

	}

	static int getInt() { // check if input is a number
		Scanner scan = new Scanner(System.in);
		int input = 0;
		while (true) {
			if (scan.hasNextInt()) {
				input = scan.nextInt();

				break;
			} else {
				System.out.println("Wpisz poprawną liczbę!");
				scan.nextLine();
			}
		}
		return input;
	}

	// change Integeer to int
	public static int[] integerToInt(Integer[] input) {
		int[] output = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			output[i] = input[i];

		}
		return output;
	}

	// check final result of game (hits 0-6)
	public static int checkResult(int userNum[], int lottoNum[]) {
		int hits = 0;
		for (int i = 0; i < userNum.length; i++) {
			if (Arrays.binarySearch(lottoNum, userNum[i]) > -1) {
				hits++;
			}
		}
		return hits;
	}

	// check if number is from range 1-49
	public static int checkLimits(int input) {

		while (true) {
			if (input < 1 || input > 49) {
				System.out.println("Poza zakresem! Spróbuj ponownie");
				input = getInt();
			} else {
				return input;
			}

		}
	}

	// check if number is not put again
	public static int checkDuplicate(int[] iputNum, int input) {
		while (true) {

			if (arrHasInt(iputNum, input)) {
				System.out.println("Było! Spróbuj ponownie");
				input = getInt();
			} else {
				return input;
			}
		}
	}

	// check if Arr contains int
	static boolean arrHasInt(int[] input, int num) {

		for (int i = 0; i < input.length; i++) {
			if (input[i] == num) {
				return true;
			}
		}
		return false;
	}

}
