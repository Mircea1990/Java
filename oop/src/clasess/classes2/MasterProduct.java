package clasess.classes2;

public class MasterProduct extends Product {

	private boolean isAvailableForLease;

	@Override
	public boolean isAvailableInStock() {
		return getRemainigAmountInStock() > 0;
	}

}
