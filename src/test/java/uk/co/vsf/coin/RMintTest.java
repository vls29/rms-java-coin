package uk.co.vsf.coin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import uk.co.vsf.coin.domain.BaseCoin;
import uk.co.vsf.coin.domain.Coin;

public class RMintTest {

	@Test
	@DisplayName("getCoinsInCirculation() returns all of the common coins in circulation")
	void getCoinsInCirculation() {
		Mint mint = RMint.getInstance();

		List<Coin> expected = new ArrayList<>();
		expected.add(new BaseCoin(1));
		expected.add(new BaseCoin(2));
		expected.add(new BaseCoin(5));
		expected.add(new BaseCoin(10));
		expected.add(new BaseCoin(20));
		expected.add(new BaseCoin(50));
		expected.add(new BaseCoin(100));
		expected.add(new BaseCoin(200));
		
		List<Coin> result = mint.getCoinsInCirculation();
		assertTrue(expected.containsAll(result));
		assertEquals(8, result.size());
	}
	

	@Test
	@DisplayName("getLegalTenderCoins() returns all of the common coins in circulation plus the commemorative coins")
	void getLegalTenderCoins() {
		Mint mint = RMint.getInstance();

		List<Coin> expected = new ArrayList<>();
		expected.add(new BaseCoin(1));
		expected.add(new BaseCoin(2));
		expected.add(new BaseCoin(5));
		expected.add(new BaseCoin(10));
		expected.add(new BaseCoin(20));
		expected.add(new BaseCoin(50));
		expected.add(new BaseCoin(100));
		expected.add(new BaseCoin(200));
		expected.add(new BaseCoin(500));
		expected.add(new BaseCoin(2000));
		expected.add(new BaseCoin(5000));
		expected.add(new BaseCoin(10000));
		
		List<Coin> result = mint.getLegalTenderCoins();
		assertTrue(expected.containsAll(result));
		assertEquals(12, result.size());
	}
}
