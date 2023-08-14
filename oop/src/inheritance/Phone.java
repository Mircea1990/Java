package inheritance;

public class Phone extends Product {

	public Phone() {
		super("Nokia");
		System.out.println("Phone constructor");
	}

	public void ring() {
		System.out.println("Ring!");
	}

	@Override
	public Product[] listVaiants() {

		throw new UnsupportedOperationException();
	}

	public int calculateAmountOfVariants() {
		return super.listVaiants().length;
	}

}
