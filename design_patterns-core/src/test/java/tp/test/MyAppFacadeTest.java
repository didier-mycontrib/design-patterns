package tp.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.dto.ProduitDto;
import tp.ioc.MyXmlBeanFactory;
import tp.service.GestionProduits;
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
	
	@Before
	public void setUp(){
		myFacade = MyFacadeImpl.getInstance();
	}
	
	@After
	public void clean(){
	    this.myFacade.cleanUpResources();// ou équivalent sur vrai projet 
		//(avec fermeture du contexte Spring par exemple)
	}
	
	
	@Test
	public void testServiceViaFacade(){      
		double sommeFrancs = 0; // .... REMPLACER 0 par un appel de euroToFrancs(15.0) 
		                        //en passant par la facade et le service gestionConversion
		System.out.println("15 euros : " + sommeFrancs + " francs");
		double sommeTva = 0; //.... REMPLACER 0 par un appel de getTva(20.0 , 200) 
		                     //en passant par la facade et le service gestionTva
		System.out.println("TVA (20.0) pour 200 Euros ==>" + sommeTva);
		
		ProduitDto prodDto = null;//.... REMPLACER null par un appel de getProduitByRef("1") 
		                         // en passant par la facade et le service gestionProduits
		System.out.println("prodDto:" + prodDto);
	}

}
