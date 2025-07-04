import java.time.*;


public class MayExpireShippableProduct extends Product implements Shippable {
    private LocalDate expiryDate;
    private double weight;
	public MayExpireShippableProduct(String name, double price, int quantity,LocalDate expiryDate,
			double weight) {
		super(name, price, quantity);
		this.expiryDate=expiryDate;
		this.weight=weight;
	}

	@Override
	public boolean isExpired() {
		return expiryDate.isBefore(LocalDate.now());
	}

	@Override
	public boolean isShippable() {
		return true;
	}

	
	public double getWeight() {
		return weight;
	}
    
}
