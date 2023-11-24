package tp.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.dto.ProduitDto;
import tp.ioc.MyIocBeanFactory;
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
	
	@BeforeEach
	public void setUp(){
		/*
		//old version
		MyXmlBeanFactory myXmlIocFactory = MyXmlBeanFactory.getInstance();
		myXmlIocFactory.initIocConfigFromXmlFile("myIocConfig.xml");
		this.serviceProduits = (GestionProduits) myXmlIocFactory.getBean("serviceGestionProduits");
		*/
		
		MyIocBeanFactory myIocFactory = MyIocBeanFactory.getInstance();
		this.serviceProduits = myIocFactory.getBean(GestionProduits.class);
	}
	
	@AfterEach
	public void clean(){
	   this.serviceProduits.cleanUpResources();
	}
	
	
	
	@Test
	public void testServiceProduits(){      
        ProduitDto prodDto = this.serviceProduits.getProduitByRef("1");
        assertNotNull(prodDto);
        assertTrue(prodDto.getReference().equals("1"));
        logger.info("ref=1 --> prodDto : " + prodDto);
        
        double ancien_prix =prodDto.getPrix();
        double nouveau_prix =ancien_prix*1.1; //augmentation de 10%
        prodDto.setPrix(nouveau_prix);
        this.serviceProduits.updateProduitViaDto(prodDto);
        
        //relecture pour vérifier la mise à jour
        ProduitDto prodDtoRelu = this.serviceProduits.getProduitByRef("1");
        logger.info("ref=1 --> prodDto apres augmentation de 10% : " + prodDto);
        assertEquals(nouveau_prix, prodDtoRelu.getPrix(), 0.0001);
        
        
        
	}

}
