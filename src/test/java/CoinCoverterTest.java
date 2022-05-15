import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoinCoverterTest {

	@Test
	@DisplayName("Negative Number throws IllegalArgumentException")
	void convertNegativeNumber() {
		CoinCoverter coinCoverter = new CoinCoverter();
		assertThrows(IllegalArgumentException.class, () -> coinCoverter.convertToCoins(-1),
				"Should have thrown an IllegalArgumentException with a negative number input");
	}

	@Test
	@DisplayName("Converts 0001 penny to '1 x 1p'")
	void convertAPenny() {
		final int amount = 1;
		final String expectedOutput = "1 x 1p";
		CoinCoverter coinCoverter = new CoinCoverter();
		assertEquals(expectedOutput, coinCoverter.convertToCoins(amount),
				"Converts " + amount + " pennies to '" + expectedOutput + "'");
	}

	@Test
	@DisplayName("Converts 0123 pennies to '1 x £1, 1 x 20p, 1 x 2p, 1 x 1p'")
	void convertOnePoundTwentyThree() {
		final int amount = 123;
		final String expectedOutput = "1 x £1, 1 x 20p, 1 x 2p, 1 x 1p";
		CoinCoverter coinCoverter = new CoinCoverter();
		assertEquals(expectedOutput, coinCoverter.convertToCoins(amount),
				"Converts " + amount + " pennies to '" + expectedOutput + "'");
	}

	@Test
	@DisplayName("Converts 223 pennies to '1 x £2, 1 x 20p, 1 x 2p, 1 x 1p'")
	void convertTwoPoundsTwentyThree() {
		final int amount = 223;
		final String expectedOutput = "1 x £2, 1 x 20p, 1 x 2p, 1 x 1p";
		CoinCoverter coinCoverter = new CoinCoverter();
		assertEquals(expectedOutput, coinCoverter.convertToCoins(amount),
				"Converts " + amount + " pennies to '" + expectedOutput + "'");
	}

	@Test
	@DisplayName("Converts 574 pennies to '2 x £2, 1 x £1, 1 x 50p, 1 x 20p, 2 x 2p'")
	void convertFivePoundsSeventyFour() {
		final int amount = 574;
		final String expectedOutput = "2 x £2, 1 x £1, 1 x 50p, 1 x 20p, 2 x 2p";
		CoinCoverter coinCoverter = new CoinCoverter();
		assertEquals(expectedOutput, coinCoverter.convertToCoins(amount),
				"Converts " + amount + " pennies to '" + expectedOutput + "'");
	}

	@Test
	@DisplayName("Converts 949 pennies to '4 x £2, 1 x £1, 2 x 20p, 1 x 5p, 2 x 2p'")
	void convertNinePoundsFourtyNine() {
		final int amount = 949;
		final String expectedOutput = "4 x £2, 1 x £1, 2 x 20p, 1 x 5p, 2 x 2p";
		CoinCoverter coinCoverter = new CoinCoverter();
		assertEquals(expectedOutput, coinCoverter.convertToCoins(amount),
				"Converts " + amount + " pennies to '" + expectedOutput + "'");
	}

	@Test
	@DisplayName("Converts 799 pennies to '3 x £2, 1 x £1, 1 x 50p, 2 x 20p, 1 x 5p, 2 x 2p'")
	void convertSevenPoundsNinetyNine() {
		final int amount = 799;
		final String expectedOutput = "3 x £2, 1 x £1, 1 x 50p, 2 x 20p, 1 x 5p, 2 x 2p";
		CoinCoverter coinCoverter = new CoinCoverter();
		assertEquals(expectedOutput, coinCoverter.convertToCoins(amount),
				"Converts " + amount + " pennies to '" + expectedOutput + "'");
	}

	@Test
	@DisplayName("Converts 198 pennies to '1 x £1, 1 x 50p, 2 x 20p, 1 x 5p, 1 x 2p, 1 x 1p'")
	void convertOnePoundNinetyEight() {
		final int amount = 198;
		final String expectedOutput = "1 x £1, 1 x 50p, 2 x 20p, 1 x 5p, 1 x 2p, 1 x 1p";
		CoinCoverter coinCoverter = new CoinCoverter();
		assertEquals(expectedOutput, coinCoverter.convertToCoins(amount),
				"Converts " + amount + " pennies to '" + expectedOutput + "'");
	}

	@Test
	@DisplayName("Converts 65 pennies to '1 x 50p, 1 x 10p, 1 x 5p'")
	void convertSixtyFive() {
		final int amount = 65;
		final String expectedOutput = "1 x 50p, 1 x 10p, 1 x 5p";
		CoinCoverter coinCoverter = new CoinCoverter();
		assertEquals(expectedOutput, coinCoverter.convertToCoins(amount),
				"Converts " + amount + " pennies to '" + expectedOutput + "'");
	}

	@Test
	@DisplayName("Converts 10 pennies to '1 x 10p'")
	void convertTen() {
		final int amount = 10;
		final String expectedOutput = "1 x 10p";
		CoinCoverter coinCoverter = new CoinCoverter();
		assertEquals(expectedOutput, coinCoverter.convertToCoins(amount),
				"Converts " + amount + " pennies to '" + expectedOutput + "'");
	}

	@Test
	@DisplayName("Converts 1000 pennies to '5 x £2'")
	void convertTenPounds() {
		final int amount = 1000;
		final String expectedOutput = "5 x £2";
		CoinCoverter coinCoverter = new CoinCoverter();
		assertEquals(expectedOutput, coinCoverter.convertToCoins(amount),
				"Converts " + amount + " pennies to '" + expectedOutput + "'");
	}

}
