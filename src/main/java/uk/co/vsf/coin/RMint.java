package uk.co.vsf.coin;

import java.util.Arrays;
import java.util.List;

import uk.co.vsf.coin.domain.BaseCoin;
import uk.co.vsf.coin.domain.Coin;

public class RMint implements Mint {
	private static Mint INSTANCE;

	private final List<Coin> coinsInCirculation;

	{
		Coin[] coins = new Coin[] { new BaseCoin(1), new BaseCoin(2), new BaseCoin(5), new BaseCoin(10),
				new BaseCoin(20), new BaseCoin(50), new BaseCoin(100), new BaseCoin(200) };

		coinsInCirculation = Arrays.asList(coins);
	}

	private RMint() {
		
	}

	@Override
	public List<Coin> getCoinsInCirculation() {
		return coinsInCirculation;
	}

	public static Mint getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RMint();
		}

		return INSTANCE;
	}
}
