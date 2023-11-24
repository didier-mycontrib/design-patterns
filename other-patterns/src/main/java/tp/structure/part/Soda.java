package tp.structure.part;

public class Soda implements Drink {
	private String kind;
	private Double price;
	
	
	public Soda() {
		super();
	}
	public Soda(String kind, Double price) {
		super();
		this.kind = kind;
		this.price = price;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Soda [kind=" + kind + ", price=" + price + "]";
	}

	

}
