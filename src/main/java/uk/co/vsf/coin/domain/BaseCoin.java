package uk.co.vsf.coin.domain;

public class BaseCoin implements Coin {
	private final int denomination;

	/**
	 * 
	 * @param denomination in pence, e.g. 1p
	 * @throws IllegalArgumentException if the value is less than 1 pence
	 */
	public BaseCoin(final int denomination) {
		if (denomination < 1) {
			throw new IllegalArgumentException("The denomination of the coin must be 1 (pence) or greater");
		}
		this.denomination = denomination;
	}

	@Override
	public int getDenomination() {
		return denomination;
	}

	@Override
	public int compareTo(Coin o) {
		if (o == null) {
			return 1;
		}

		return Integer.compare(this.denomination, o.getDenomination());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + denomination;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseCoin other = (BaseCoin) obj;
		if (denomination != other.denomination)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		if(this.denomination < 100) {
			return this.denomination + "p";
		}
		return "£" + (this.denomination / 100);
	}
}
