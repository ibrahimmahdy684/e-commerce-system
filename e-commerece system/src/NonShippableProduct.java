
public class NonShippableProduct extends Product {

	public NonShippableProduct(String name, double price, int quantity) {
		super(name, price, quantity);
	}

	@Override
	public boolean isExpired() {
		return false;
	}

	@Override
	public boolean isShippable() {
		return false;
	}

}
