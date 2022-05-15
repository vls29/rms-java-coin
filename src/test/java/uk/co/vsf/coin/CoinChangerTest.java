package uk.co.vsf.coin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;

import uk.co.vsf.coin.domain.BaseCoin;
import uk.co.vsf.coin.domain.Coin;

public class CoinChangerTest {

	private CoinChanger changer = CoinChanger.getInstance();

	@Test
	void amountOnePence() {
		Coin expectedCoin = new BaseCoin(1);
		Map<Coin, Integer> result = changer.getAmountAsChange(1, RMint.getInstance().getCoinsInCirculation());
		assertTrue(result.containsKey(expectedCoin));
		assertEquals(1, result.get(expectedCoin));
	}

	@Test
	void amountFourPence() {
		Coin expectedCoin = new BaseCoin(2);
		Map<Coin, Integer> result = changer.getAmountAsChange(4, RMint.getInstance().getCoinsInCirculation());
		assertEquals(1, result.keySet().size());
		assertTrue(result.containsKey(expectedCoin));
		assertEquals(2, result.get(expectedCoin));
	}

	@Test
	void amountSixPence() {
		Coin expectedCoin1 = new BaseCoin(1);
		Coin expectedCoin2 = new BaseCoin(5);

		Map<Coin, Integer> result = changer.getAmountAsChange(6, RMint.getInstance().getCoinsInCirculation());
		assertEquals(2, result.keySet().size());

		assertTrue(result.containsKey(expectedCoin1));
		assertTrue(result.containsKey(expectedCoin2));

		assertEquals(1, result.get(expectedCoin1));
		assertEquals(1, result.get(expectedCoin2));
	}

	@Test
	void amountEightPence() {
		Coin expectedCoin1 = new BaseCoin(1);
		Coin expectedCoin2 = new BaseCoin(2);
		Coin expectedCoin3 = new BaseCoin(5);

		Map<Coin, Integer> result = changer.getAmountAsChange(8, RMint.getInstance().getCoinsInCirculation());
		assertEquals(3, result.keySet().size());

		assertTrue(result.containsKey(expectedCoin1));
		assertTrue(result.containsKey(expectedCoin2));
		assertTrue(result.containsKey(expectedCoin3));

		assertEquals(1, result.get(expectedCoin1));
		assertEquals(1, result.get(expectedCoin2));
		assertEquals(1, result.get(expectedCoin3));
	}

	@Test
	void amountNinePence() {
		Coin expectedCoin1 = new BaseCoin(2);
		Coin expectedCoin2 = new BaseCoin(5);

		Map<Coin, Integer> result = changer.getAmountAsChange(9, RMint.getInstance().getCoinsInCirculation());
		assertEquals(2, result.keySet().size());

		assertTrue(result.containsKey(expectedCoin1));
		assertTrue(result.containsKey(expectedCoin2));

		assertEquals(2, result.get(expectedCoin1));
		assertEquals(1, result.get(expectedCoin2));
	}

	@Test
	void amountSeventyEightPence() {
		Coin expectedCoin1 = new BaseCoin(1);
		Coin expectedCoin2 = new BaseCoin(2);
		Coin expectedCoin3 = new BaseCoin(5);
		Coin expectedCoin4 = new BaseCoin(20);
		Coin expectedCoin5 = new BaseCoin(50);

		Map<Coin, Integer> result = changer.getAmountAsChange(78, RMint.getInstance().getCoinsInCirculation());
		assertEquals(5, result.keySet().size());

		assertTrue(result.containsKey(expectedCoin1));
		assertTrue(result.containsKey(expectedCoin2));
		assertTrue(result.containsKey(expectedCoin3));
		assertTrue(result.containsKey(expectedCoin4));
		assertTrue(result.containsKey(expectedCoin5));

		assertEquals(1, result.get(expectedCoin1));
		assertEquals(1, result.get(expectedCoin2));
		assertEquals(1, result.get(expectedCoin3));
		assertEquals(1, result.get(expectedCoin4));
		assertEquals(1, result.get(expectedCoin5));
	}
}
