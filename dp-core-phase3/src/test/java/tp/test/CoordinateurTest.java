package tp.test;

import org.junit.jupiter.api.Test;

import tp.ioc.MyIocBeanFactory;
import tp.ioc.exemple.Coordinateur;
import tp.ioc.exemple.CoordinateurWithDefault;
import tp.ioc.exemple.MonCalculateur;

public class CoordinateurTest {
	
	public static void main(String[] args) {
		CoordinateurTest testApp=new CoordinateurTest();
		testApp.testCoordinateur();
		testApp.testCoordinateurWithDefault();
	}
	
	
	@Test
	public void testCoordinateur() {
		MyIocBeanFactory myIocBeanFactory = MyIocBeanFactory.getInstance();
	
		MonCalculateur monCalculateurCarre = myIocBeanFactory.getBean(MonCalculateur.class,"MonCalculateurCarre");
		System.out.println("Avec MonCalculateurCarre, res de .calculer="
		                      + monCalculateurCarre.calculer(4));// 4*4=16.0
		
		MonCalculateur monCalculateurDouble = myIocBeanFactory.getBean(MonCalculateur.class,"MonCalculateurDouble");
		System.out.println("Avec MonCalculateurDouble, res de .calculer="
		                      + monCalculateurDouble.calculer(4));// 2*4=8.0
		
		Coordinateur coordinateur =	myIocBeanFactory.getBean(Coordinateur.class);
		System.out.println("Avec Coordinateur et dépendances précises/explicites:");
		coordinateur.calculerEtAfficher();
		
	}
	
	@Test
	public void testCoordinateurWithDefault() {
		MyIocBeanFactory myIocBeanFactory = MyIocBeanFactory.getInstance();
		
		MonCalculateur monCalculateurParDefaut = myIocBeanFactory.getBean(MonCalculateur.class);
		System.out.println("Avec calculateur par defaut, res de .calculer="
		                      + monCalculateurParDefaut.calculer(4));// 4*4=16.0 ou 2*4=8
		
		CoordinateurWithDefault coordinateur =	myIocBeanFactory.getBean(CoordinateurWithDefault.class);
		System.out.println("Avec CoordinateurWithDefault et dépendances par défaut");
		coordinateur.calculerEtAfficher();
		
	}

}
