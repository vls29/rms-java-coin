package uk.co.vsf.coin;

import java.util.List;

import uk.co.vsf.coin.domain.Coin;

public interface Mint {

	/**
	 * Return a list of coins that are in common circulation.  This excludes commemorative coins.
	 * @return list of coins in common circulation
	 */
	List<Coin> getCoinsInCirculation();
	
	/**
	 * Returns a list of coins that are classed as legal tender.  This includes commemorative coins but excludes the 25p crown.
	 * @return list of legal tender coins
	 */
	List<Coin> getLegalTenderCoins();
}
