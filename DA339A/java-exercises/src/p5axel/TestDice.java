package p5axel;

public class TestDice {
	
	//Saknas kommentarer!

	public static void test(Dice dice, int nbrOfThrows) {
		int[] res = new int[dice.getSides()];

		for (int i = 0; i < nbrOfThrows; i++) {
			int value = dice.throwDice();
			res[value - 1]++;
		}
		for (int i = 0; i < res.length; i++) {
			TextWindow.println(i + 1 + "\t" + res[i]);
		}
	}

	public static void test(Player player, int nbrOfThrows) {

		if (checkCheater(player) == true) {
			Cheater chad = (Cheater) player;
			int[] cRes = new int[chad.getDice().getSides()];
			for (int i = 0; i < nbrOfThrows; i++) {
				int value = chad.throwDice();
				cRes[value - 1]++;
			}
			for (int i = 0; i < cRes.length; i++) {
				TextWindow.println(i + 1 + "\t" + cRes[i]);
			}

		} else {
			OrdinaryPlayer oliver = (OrdinaryPlayer) player;

			int[] oRes = new int[oliver.getDice().getSides()];
			for (int i = 0; i < nbrOfThrows; i++) {
				int value = oliver.throwDice();
				oRes[value - 1]++;
			}
			for (int i = 0; i < oRes.length; i++) {
				TextWindow.println(i + 1 + "\t" + oRes[i]);
			}

		}
	}

	public static void main(String[] args) {
		 TestDice.test(new SimpleDice(6), 1000000);
		 TextWindow.println();
		 TestDice.test(new SimpleDice(4), 1000000);
		 TextWindow.println("\n"+ "\t"+"new test" + "\n");

		TestDice.test(new OrdinaryPlayer("Rut", new SimpleDice(6)), 1000000);
		TextWindow.println();
		TestDice.test(new Cheater("Fuffe", new SimpleDice(6)), 1000000);
	}

	public static boolean checkCheater(Player p) {
		if (p instanceof Cheater) {
			return true;
		}
		return false;

	}

}
