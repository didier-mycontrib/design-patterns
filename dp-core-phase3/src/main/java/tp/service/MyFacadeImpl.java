package tp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyFacadeImpl implements MyFacade {
	
    private static Logger logger = LoggerFactory.getLogger(MyFacadeImpl.class);
    
    private GestionConversion gestionConversion=null;
	//et autres ...
    
	//singleton pour facade ...
	
	private MyFacadeImpl(){
		//initialiser this.gestionConversion et autres
		//....
	}
	
	@Override
	public GestionProduits getGestionProduits() {
		return null;//à améliorer
	}

	public GestionConversion getGestionConversion() {
		return gestionConversion;
	}

	public GestionTva getGestionTva() {
		return null;//à améliorer
	}
    /*
	public void setGestionConversion(GestionConversion gestionConversion) {
		this.gestionConversion = gestionConversion;
	}

	public void setGestionTva(GestionTva gestionTva) {
		this.gestionTva = gestionTva;
	}
    /*
	public void setGestionConversion(GestionConversion gestionConversion) {
		this.gestionConversion = gestionConversion;
	}

	public void setGestionTva(GestionTva gestionTva) {
		this.gestionTva = gestionTva;
	}
	*/

	@Override
	public void cleanUpResources() {
		//gestionProduits.cleanUpResources(); //à adapter avec Spring ou autre sur vrai projet		
	}

	
	

}
