package tp.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.dao.ProduitDao;
import tp.entity.Produit;
import tp.ioc.MyIocBeanFactory;

public class MyAppTest {
	
	private static Logger logger = LoggerFactory.getLogger(MyAppTest.class);
	
	private ProduitDao produitDao; //chose à  tester

    //pour eventuel lancement "run as / java appli"
	public static void main(String[] args) {
		MyAppTest thisApp = new MyAppTest();
		thisApp.setUp();
		thisApp.testProduitDao();
		thisApp.clean();
		//System.exit(0);
	}
	
	@BeforeEach
	public void setUp(){
		MyIocBeanFactory myIocBeanFactory = MyIocBeanFactory.getInstance();
		this.produitDao = myIocBeanFactory.getBean(ProduitDao.class);
	}
	
	@AfterEach
	public void clean(){
		this.produitDao.cleanUpResources();
	}
	
	//@Test
	public void listerTousLesProduits()
	{
		List<Produit> listProd = produitDao.getAllProduits();
		assertNotNull(listProd);
		logger.info("liste des produits ==>");
		for(Produit p : listProd)
			logger.info(p.toString());
	}
	
	
	
	@Test
	public void testProduitDao()
	{
        
        listerTousLesProduits();
        
        Produit nouveauProduit = new Produit(null,"nouveau produit XY",26.6);
        nouveauProduit = produitDao.createProduit(nouveauProduit);
        Long ref = nouveauProduit.getReference();
        assertNotNull(ref);
        Produit prod = produitDao.getProduitByRef(ref);
        assertTrue(prod.getLabel().equals("nouveau produit XY"));
        assertEquals(26.6, prod.getPrix(), 0.00001);
        logger.info("nouveau produit (with ref="+ ref + "):");
        logger.info(prod.toString());
        
        prod.setLabel("nouveau label");
        prod.setPrix(65.2);
        produitDao.updateProduit(prod);
        
        prod = produitDao.getProduitByRef(ref);
        assertTrue(prod.getLabel().equals("nouveau label"));
        assertEquals(65.2, prod.getPrix(), 0.00001);
        logger.info("nouveau produit modifie:");
        logger.info(prod.toString());
       
        produitDao.deleteProduit(prod);
        Produit deletedProd = produitDao.getProduitByRef(ref);
        if(deletedProd==null)
        	 logger.info("==>nouveau produit finalement supprime.");
        assertNull(deletedProd);
        
	}

}
