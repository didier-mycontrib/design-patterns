package tp.dessin.observateur;

//NB: java.util.Observable est devenu obsolète dans Java 9


public class SubjectWithCommonData extends AbstractObservableSubject { // VERSION1 "MAISON"
// public class SubjectWithCommonData extends Observable {
	
	private String commonData;

	public String getCommonData() {
		return commonData;
	}

	public void setCommonData(String commonData) {
		this.commonData = commonData;
		//this.setChanged();//en version java.util.Observable seulement (pas en version "maison"/AbstractSubject)
		this.notifyObservers();
		//avertir tous les observateurs qu'un changement a été effectué
		// et INDIRECTEMENT DECLENCHER DES mises à jour
	}
	
	

}
