import java.util.Collections;
import java.util.List;
import java.util.Map;

import uk.co.vsf.coin.CoinChanger;
import uk.co.vsf.coin.Mint;
import uk.co.vsf.coin.RMint;
import uk.co.vsf.coin.domain.Coin;

public class CoinCoverter {

	/**
	 * Converts the input amount into a string representation of the amount as
	 * change.
	 * 
	 * @param amount in pence
	 * @return string representation of the amount as change, e.g. if the amount
	 *         input was 55, the response would be '1 x 50p, 1 x 5p'
	 * @throws IllegalArgumentException if the amount is less than 1 (pence)
	 */
	public String convertToCoins(int amount) {
		if (amount < 1) {
			throw new IllegalArgumentException("Amount must be one or greater");
		}

		return getChange(amount, false);
	}

	private String getChange(int amount, boolean includingCommemorative) {
		Mint mint = RMint.getInstance();
		
		List<Coin> coins = includingCommemorative ? mint.getLegalTenderCoins() : mint.getCoinsInCirculation();

		Map<Coin, Integer> change = CoinChanger.getInstance().getAmountAsChange(amount, coins);

		StringBuilder sb = new StringBuilder();
		change.keySet().stream().sorted(Collections.reverseOrder()).forEach(c -> {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			sb.append(String.format("%d x %s", change.get(c), c.toString()));
		});

		return sb.toString();
	}

	
	/**
	 * Converts the input amount into a string representation of the amount as
	 * change.
	 * 
	 * @param amount in pence
	 * @return string representation of the amount as change, e.g. if the amount
	 *         input was 55, the response would be '1 x 50p, 1 x 5p'
	 * @throws IllegalArgumentException if the amount is less than 1 (pence)
	 */
	public String convertToCoinsIncludingCommemorative(int amount) {
		if (amount < 1) {
			throw new IllegalArgumentException("Amount must be one or greater");
		}

		return getChange(amount, true);
	}
}
