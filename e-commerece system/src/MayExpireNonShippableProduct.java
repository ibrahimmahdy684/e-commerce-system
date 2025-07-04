import java.time.LocalDate;


public class MayExpireNonShippableProduct extends Product {
    private LocalDate expiryDate;
	public MayExpireNonShippableProduct(String name, double price, int quantity,LocalDate expiryDate) {
		super(name, price, quantity);
		this.expiryDate=expiryDate;
	}

	@Override
	public boolean isExpired() {
		return expiryDate.isBefore(LocalDate.now());
	}

	@Override
	public boolean isShippable() {
		return false;
	}

	

}
