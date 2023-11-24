package tp.builder;

import org.junit.jupiter.api.Test;

import tp.structure.SimpleMenu;
import tp.structure.part.Burger;
import tp.structure.part.Icecream;
import tp.structure.part.Soda;
import tp.structure.part.Wine;

public class TestSimpleMenuBuilder {
	
	@Test
	public void testSimpleMenuBuilder() {
		SimpleMenu menu1 = SimpleMenu.builder()
						   .defaultMainCourse()
				           .dessert(new Icecream("vanilla",2.5))
				           .drink(new Wine("bordeaux",3.5) )
				           .build();
		System.out.println("menu1="+menu1);
		
		
		SimpleMenu menu2 = SimpleMenu.builder()
				   .mainCourse(new Burger("Maxi Beacon Burger",6.8))
		           .dessert(new Icecream("lemon",2.5))
		           .drink(new Soda("CocaCola",3.0) )
		           .build();
        System.out.println("menu2="+menu2);
	}

}
