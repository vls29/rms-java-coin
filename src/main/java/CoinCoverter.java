import java.util.Collections;
import java.util.List;
import java.util.Map;

import uk.co.vsf.coin.CoinChanger;
import uk.co.vsf.coin.Mint;
import uk.co.vsf.coin.RMint;
import uk.co.vsf.coin.domain.Coin;

public class CoinCoverter {

	public String convertToCoins(int amount) {
		if( amount < 1) {
			throw new IllegalArgumentException("Amount must be one or greater");
		}
		
		Mint mint = RMint.getInstance();
		List<Coin> coinsInCirculation = mint.getCoinsInCirculation();

		Map<Coin, Integer> change = CoinChanger.getInstance().getAmountAsChange(amount, coinsInCirculation);

		StringBuilder sb = new StringBuilder();
		change.keySet().stream().sorted(Collections.reverseOrder()).forEach(c -> {
			if(sb.length() > 0) {
				sb.append(", ");
			}
			sb.append(String.format("%d x %s", change.get(c),c.toString()));
		});

		return sb.toString();
	}

}
