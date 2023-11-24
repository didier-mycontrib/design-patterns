package tp.structure.part;

public class TodaySpecial implements MainCourse {
	
	private String label;
	private Double price;
	

	public TodaySpecial(String label, Double price) {
		super();
		this.label = label;
		this.price = price;
	}
	
	public TodaySpecial() {
		this("surprise du chef",7.0);
	}

	@Override
	public String toString() {
		return "TodaySpecial [label=" + label + ", price=" + price + "]";
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
