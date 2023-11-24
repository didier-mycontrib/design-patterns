package tp.structure.part;

public class Icecream implements Dessert{
	private String flavour; //ex: "lemon" , "vanilla"
	private Double price;
	
	
	
	public Icecream(String flavour, Double price) {
		super();
		this.flavour = flavour;
		this.price = price;
	}
	
	
	
	
	public Icecream() {
		this("lemon",1.0);
	}




	@Override
	public String toString() {
		return "Icecream [flavour=" + flavour + ", price=" + price + "]";
	}
	public String getFlavour() {
		return flavour;
	}
	public void setFlavour(String flavour) {
		this.flavour = flavour;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
