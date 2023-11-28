package tp.ioc;

import javax.sql.DataSource;

import tp.dao.ProduitDao;
import tp.dao.ProduitDaoJdbc;
import tp.ds.MyParamDataSource;
import tp.service.GestionProduits;
import tp.service.GestionProduitsImpl;

public class MyStaticIocBeanFactory {
	
    static MyStaticIocBeanFactory uniqueInstance = null;
	
	public synchronized static MyStaticIocBeanFactory getInstance()
	{
		if(uniqueInstance==null)
		{
			uniqueInstance=new MyStaticIocBeanFactory();
		}
		return uniqueInstance;
	}
	
	//version rapide améliorable
	public <T> T getBean(Class<T> beanClass) {
		T res=null;
		if(beanClass.getSimpleName().equals("GestionProduits")){
			DataSource dataSource = new MyParamDataSource();
			ProduitDao produitDao = new ProduitDaoJdbc(dataSource);
			//ProduitDao produitDao = new ProduitDaoJpa();
			GestionProduits bean = new GestionProduitsImpl(produitDao);
			res = (T) bean;
		}
		return res;
	}

}
