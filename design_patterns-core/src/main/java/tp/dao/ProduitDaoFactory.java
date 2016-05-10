package tp.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.util.MyPropertiesUtil;

/*
 * Singleton
 * Factory of ProduitDao
 */
public class ProduitDaoFactory {
	
	private static Logger logger = LoggerFactory.getLogger(ProduitDaoFactory.class);
	
	
	/* coder ici le design pattern singleton sur la classe ProduitDaoFactory
	   static , getInstance() , constructeur privé
	 */
	
	
	private String commonData; //shared inside singleton (with get/set)
	
	
	/* coder ici une méthode de fabrication createProduitDao() qui va construire et retourner une instance
	 * d'un DAO selon la valeur de la propriété "produitDao" du fichier src/main/resources/produitDao.properties
	 * 
	 * String daoImplClassName 
		    = MyPropertiesUtil.propertyValueFromEntryOfPropertyFile("produitDao.properties","produitDao");
     * 
     * On pourra éventuellement utiliser  Class.forName(....).newInstance();
	 */
	
	
	public String getCommonData() {
		return commonData;
	}

	public void setCommonData(String commonData) {
		this.commonData = commonData;
	}
	
	

}
