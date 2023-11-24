package tp.ioc.exemple;

import tp.ioc.annot.MyInject;

public class CoordinateurWithDefault {
	
	
	@MyInject
	private MonAfficheur monAfficheur=null; //référence vers afficheur à injecter
	
	
	@MyInject
	private MonCalculateur monCalculateur=null;//référence vers calculateur à injecter
	
	

	public void calculerEtAfficher() {
		double x=4;
		double res =monCalculateur.calculer(x); //x*x ou bien 2*x ou bien ...
		monAfficheur.afficher("res="+res);// >> res=16 en v1 ou bien ** res=16
	}
}
