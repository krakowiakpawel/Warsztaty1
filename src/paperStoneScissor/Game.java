package paperStoneScissor;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {

		int wins = 0;
		int ties = 0;
		int looses = 0;
		
		System.out.println("Witaj w grze! Wybierz: ");
		Scanner scan = new Scanner(System.in);
		System.out.println("pap - PAPER");
		System.out.println("sc - SCISSOR");
		System.out.println("st - STONE");
		System.out.println("q - quit");

		HandSign user = null;

		while (true) {
			String input = scan.nextLine();
			if (input.equals("sc")) {
				user = HandSign.SCISSOR;
			} else if (input.equals("pap")) {
				user = HandSign.PAPER;
			} else if (input.equals("st")) {
				user = HandSign.STONE;
			} else if (input.equals("q")) {
				break;
			} else {
				System.out.println("Błąd wyboru");
			}

			if (user != null) {
				HandSign comp = HandSign.getRandomHandSign();
				System.out.println("User choise: " + user);
				System.out.println("comp choise: " + comp);

				Result res = checkResult(user, comp);
				if (res == Result.WIN) {
					System.out.println("User wins!");
					wins++;
				} else if (res == Result.LOOSE) {
					System.out.println("User loose!");
					looses++;
				} else {
					System.out.println("Tie!");
					ties++;
				}
			}
			System.out.println("Wybierz st, sc, pap lub q");
		}
		System.out.println("The End");
		System.out.println("Wins: " + wins);
		System.out.println("Ties: " + ties);
		System.out.println("Looses: " + looses);

	}

	public static Result checkResult(HandSign user, HandSign comp) {

		Result rs = Result.LOOSE;

		if (user == comp) {
			rs = Result.TIE;
			return rs;
		} else if ((user == HandSign.PAPER && comp == HandSign.STONE)
				|| (user == HandSign.SCISSOR && comp == HandSign.PAPER)
				|| (user == HandSign.STONE && comp == HandSign.SCISSOR)) {
			rs = Result.WIN;
		}

		return rs;
	}

}
