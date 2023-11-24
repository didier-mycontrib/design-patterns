package tp.builder;

import tp.structure.SimpleMenu;
import tp.structure.part.Dessert;
import tp.structure.part.Drink;
import tp.structure.part.MainCourse;
import tp.structure.part.TodaySpecial;

public class SimpleMenuBuilder {
	private SimpleMenu simpleMenu;//to build
	
	public SimpleMenuBuilder() {
		simpleMenu=new SimpleMenu();
	}
	
	public SimpleMenuBuilder(String name) {
		simpleMenu=new SimpleMenu(name);
	}
	
	public SimpleMenuBuilder name(String name) {
		simpleMenu.setName(name);
		return this;
	}
	
	public SimpleMenuBuilder dessert(Dessert dessert) {
		simpleMenu.setDessert(dessert);
		return this;
	}
	
	public SimpleMenuBuilder drink(Drink drink) {
		simpleMenu.setDrink(drink);
		return this;
	}
	
	public SimpleMenuBuilder mainCourse(MainCourse mainCourse) {
		simpleMenu.setMainCourse(mainCourse);
		return this;
	}
	
	public SimpleMenuBuilder defaultMainCourse() {
		simpleMenu.setMainCourse(new TodaySpecial());
		return this;
	}
	
	
	public SimpleMenu build() {
		double totalPrice=0.0;
		if(simpleMenu.getDessert()!=null)
			totalPrice += simpleMenu.getDessert().getPrice();
		if(simpleMenu.getDrink()!=null)
			totalPrice += simpleMenu.getDrink().getPrice();
		simpleMenu.setTotalPrice(totalPrice);
		return simpleMenu;
	}
}
