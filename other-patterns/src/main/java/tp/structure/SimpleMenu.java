package tp.structure;

import tp.builder.SimpleMenuBuilder;
import tp.structure.part.Dessert;
import tp.structure.part.Drink;
import tp.structure.part.MainCourse;
import tp.structure.part.Starter;

public class SimpleMenu {
	
	private String name;
	private Double totalPrice;
	
	private Starter starter;
	private MainCourse mainCourse;
	private Dessert dessert;
	private Drink drink;
	
    public static SimpleMenuBuilder builder() {
		return new SimpleMenuBuilder();
	}
	
	
	public SimpleMenu(String name) {
		super();
		this.name = name;
	}

	public SimpleMenu() {
		this("menuOfTheDay");
	}

	
	
	@Override
	public String toString() {
		return "SimpleMenu [name=" + name + ", totalPrice=" + totalPrice + ", starter=" + starter + ", mainCourse="
				+ mainCourse + ", dessert=" + dessert + ", drink=" + drink + "]";
	}


	public Starter getStarter() {
		return starter;
	}
	public void setStarter(Starter starter) {
		this.starter = starter;
	}
	public MainCourse getMainCourse() {
		return mainCourse;
	}
	public void setMainCourse(MainCourse mainCourse) {
		this.mainCourse = mainCourse;
	}
	public Dessert getDessert() {
		return dessert;
	}
	public void setDessert(Dessert dessert) {
		this.dessert = dessert;
	}
	public Drink getDrink() {
		return drink;
	}
	public void setDrink(Drink drink) {
		this.drink = drink;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
	
}
