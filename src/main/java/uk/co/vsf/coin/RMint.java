package uk.co.vsf.coin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import uk.co.vsf.coin.domain.BaseCoin;
import uk.co.vsf.coin.domain.Coin;

public class RMint implements Mint {
	private static Mint INSTANCE;

	private final List<Coin> coinsInCirculation;
	private final List<Coin> commemorativeCoins;

	{
		Coin[] coinsInCirculation = new Coin[] { new BaseCoin(1), new BaseCoin(2), new BaseCoin(5), new BaseCoin(10),
				new BaseCoin(20), new BaseCoin(50), new BaseCoin(100), new BaseCoin(200) };

		this.coinsInCirculation = Arrays.asList(coinsInCirculation);

		Coin[] commemorativeCoins = new Coin[] { new BaseCoin(500), new BaseCoin(5000), new BaseCoin(2000),
				new BaseCoin(10000) };
		
		this.commemorativeCoins = Arrays.asList(commemorativeCoins);
	}

	private RMint() {

	}

	@Override
	public List<Coin> getCommonCoinsInCirculation() {
		return new CopyOnWriteArrayList<>(this.coinsInCirculation);
	}

	public static Mint getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RMint();
		}

		return INSTANCE;
	}

	@Override
	public List<Coin> getLegalTenderCoins() {
		List<Coin> allCoins = new ArrayList<Coin>(commemorativeCoins);
		allCoins.addAll(coinsInCirculation);
		return allCoins;
	}
}
