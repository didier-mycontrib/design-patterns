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

public class MyAppServiceTestWithIoc {
	
	private static Logger logger = LoggerFactory.getLogger(MyAppServiceTestWithIoc.class);
	
	private GestionProduits serviceProduits; //chose à  tester

    //pour eventuel lancement "run as / java appli"
	public static void main(String[] args) {
		MyAppServiceTestWithIoc thisApp = new MyAppServiceTestWithIoc();
		thisApp.setUp();
		thisApp.testServiceProduits();
		thisApp.clean();
		//System.exit(0);
	}
	
	@Before
	public void setUp(){
		MyXmlBeanFactory myXmlIocFactory = MyXmlBeanFactory.getInstance();
		myXmlIocFactory.initIocConfigFromXmlFile("myIocConfig.xml");
		this.serviceProduits = (GestionProduits) myXmlIocFactory.getBean("serviceGestionProduits");
	}
	
	@After
	public void clean(){
	   this.serviceProduits.cleanUpResources();
	}
	
	
	
	@Test
	public void testServiceProduits(){      
        ProduitDto prodDto = this.serviceProduits.getProduitByRef("1");
        Assert.assertNotNull(prodDto);
        Assert.assertTrue(prodDto.getReference().equals("1"));
        logger.info("ref=1 --> prodDto : " + prodDto);
	}

}
