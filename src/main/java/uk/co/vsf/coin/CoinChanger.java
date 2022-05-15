package uk.co.vsf.coin;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.co.vsf.coin.domain.Coin;

public class CoinChanger {
	private static CoinChanger INSTANCE;

	private CoinChanger() {

	}

	public static CoinChanger getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CoinChanger();
		}

		return INSTANCE;
	}

	/**
	 * Returns the minimum map of coins that make up the amount passed in
	 * 
	 * @param amount    to convert to coins
	 * @param coinTypes list of coins for example the ones in circulation
	 * @return coin type(s) and count of those types
	 */
	public Map<Coin, Integer> getAmountAsChange(final int amount, final List<Coin> coinTypes) {
		final Map<Coin, Integer> change = new HashMap<>();
		final Remainder remainder = new Remainder(amount);

		coinTypes.stream().sorted(Collections.reverseOrder()).forEach(c -> {
			if (remainder.isGreaterThanZero()) {
				if (c.getDenomination() <= remainder.getValue()) {
					int count = remainder.divideAndRemainder(c.getDenomination());
					change.put(c, count);
				}
			}
		});
		return change;
	}

	private class Remainder {
		private BigInteger value;

		public Remainder(int value) {
			this.value = BigInteger.valueOf(value);
		}

		public int divideAndRemainder(int divider) {
			BigInteger[] divideAndRemainder = value.divideAndRemainder(BigInteger.valueOf(divider));
			this.value = divideAndRemainder[1];
			return divideAndRemainder[0].intValue();
		}

		public int getValue() {
			return this.value.intValue();
		}

		public boolean isGreaterThanZero() {
			return this.value.compareTo(BigInteger.ZERO) > 0;
		}
	}
}
