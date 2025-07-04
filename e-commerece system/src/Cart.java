import java.util.*;


public class Cart {
  private HashMap<Product,Integer> productList;
  
  public Cart(){
	  this.productList=new HashMap<>();
  }
  public HashMap<Product,Integer> getItems(){
	  return productList;
  }
  public boolean isEmpty(){
	  return productList.isEmpty();
  }
  public void addProduct(Product p,int amount){
	  if(p.getQuantity()<amount)
		  throw new IllegalArgumentException("Not enough quantity in stock");
	  else{
	  productList.put(p, productList.getOrDefault(p, 0)+amount);
	  p.reduceQuantity(amount);
	  }
  }
  public HashMap<Shippable,Integer> sendToShipment(){
	  HashMap<Shippable,Integer> res=new HashMap<>();
	  for(Map.Entry<Product, Integer> entry:productList.entrySet()){
		  if(entry.getKey().isShippable())
			  res.put((Shippable)entry.getKey(),res.getOrDefault((Shippable)entry.getKey(), 0)+entry.getValue());
	  }
	  return res;
  }
  public double calcSubTotal(){
	  double subTotal=0;
	  for(Product p:productList.keySet())
		  subTotal+=p.getPrice();
	  return subTotal;
  }
  public double calcShippingFees(){
	  HashMap<Shippable,Integer> temp=this.sendToShipment();
	  double fees=0;
	  for(Shippable p:temp.keySet())
		  fees+=(p.getWeight()*20);//Assume each kg costs 20 EGP 
	  return fees;
  }
}
