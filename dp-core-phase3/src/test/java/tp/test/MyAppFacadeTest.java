package tp.test;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.dto.ProduitDto;
import tp.service.MyFacade;
import tp.service.MyFacadeImpl;

public class MyAppFacadeTest {
	
	private static Logger logger = LoggerFactory.getLogger(MyAppFacadeTest.class);
	
	private MyFacade myFacade; //chose à  tester

    //pour eventuel lancement "run as / java appli"
	public static void main(String[] args) {
		MyAppFacadeTest thisApp = new MyAppFacadeTest();
		thisApp.setUp();
		thisApp.testServiceViaFacade();
		thisApp.clean();
		//System.exit(0);
	}
	
	@BeforeEach
	public void setUp(){
		//myFacade = .... via singleton
	}
	
	@AfterEach
	public void clean(){
	    //this.myFacade.cleanUpResources();// ou équivalent sur vrai projet 
		//(avec fermeture du contexte Spring par exemple)
	}
	
	
	@Test
	public void testServiceViaFacade(){      
		double sommeFrancs = 0; //myFacade....................
		System.out.println("15 euros : " + sommeFrancs + " francs");
		double sommeTva = 0; //myFacade.....................
		System.out.println("TVA (20.0) pour 200 Euros ==>" + sommeTva);
		
		ProduitDto prodDto = null; //myFacade.........................
		System.out.println("prodDto:" + prodDto);
	}

}
