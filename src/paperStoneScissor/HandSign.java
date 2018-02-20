package paperStoneScissor;

import java.util.Random;

public enum HandSign {
	SCISSOR, PAPER, STONE;

	int [] arr = new int[5];
	
	 private static final HandSign[] VALUES = values();
	  private static final int SIZE = VALUES.length;
	  private static final Random RANDOM = new Random();

	  public static HandSign getRandomHandSign()  {
	    return VALUES[RANDOM.nextInt(SIZE)];
	  }
	
	
}
