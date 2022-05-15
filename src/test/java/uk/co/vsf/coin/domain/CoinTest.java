package uk.co.vsf.coin.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CoinTest {

	@Test
	@DisplayName("Cannot set a negative coin value")
	void constructCoinWithNegativeValueThrowsException() {
		assertThrows(IllegalArgumentException.class, () -> new BaseCoin(-1));
	}

	@Test
	@DisplayName("Cannot set coin value to zero")
	void constructCoinWithZeroValueThrowsException() {
		assertThrows(IllegalArgumentException.class, () -> new BaseCoin(0));
	}

	@Test
	@DisplayName("getDenomination() returns constructor input")
	void getCoinDenominationReturnsConstructorInput() {
		int value = 5;
		Coin coin = new BaseCoin(value);
		assertEquals(5, coin.getDenomination());

		value = 10;
		Coin coin2 = new BaseCoin(value);
		assertEquals(10, coin2.getDenomination());

		assertNotEquals(coin.getDenomination(), coin2.getDenomination());
	}

	@Test
	@DisplayName("Five pence coin is greater than a one pence coin")
	void compareCoins_FiveIsGreaterThanOnePence() {
		Coin fivePence = new BaseCoin(5);
		Coin onePence = new BaseCoin(1);

		assertEquals(1, fivePence.compareTo(onePence));
	}

	@Test
	@DisplayName("One pence coin is less than a ten pence coin")
	void compareCoins_OnePenceIsLessThanTenPence() {
		Coin onePence = new BaseCoin(1);
		Coin tenPence = new BaseCoin(10);

		assertEquals(-1, onePence.compareTo(tenPence));
	}

	@Test
	@DisplayName("toString() 1p")
	void toStringOnePence() {
		assertEquals("1p", new BaseCoin(1).toString());
	}

	@Test
	@DisplayName("toString() 2p")
	void toStringTwoPence() {
		assertEquals("2p", new BaseCoin(2).toString());
	}

	@Test
	@DisplayName("toString() £1")
	void toStringOnePound() {
		assertEquals("£1", new BaseCoin(100).toString());
	}

	@Test
	@DisplayName("toString() £2")
	void toStringTwoPound() {
		assertEquals("£2", new BaseCoin(200).toString());
	}
}
