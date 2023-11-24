package tp.structure.part;

public class Burger implements MainCourse {
	
	private String label;
	private Double price;
	

	public Burger(String label, Double price) {
		super();
		this.label = label;
		this.price = price;
	}
	
	public Burger() {
		this("empty burger",0.0);
	}

	@Override
	public String toString() {
		return "Burger [label=" + label + ", price=" + price + "]";
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	

}
