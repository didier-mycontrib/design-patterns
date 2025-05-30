package tp.dessin.observateur;

import java.util.ArrayList;
import java.util.List;

//NB: l'équivalent prédéfini etait java.util.Observable mais c'est devenu obsolète dans Java 9


public abstract class AbstractObservableSubject {
	private List<IObserver> listeObservateurs = new ArrayList<IObserver>();
	
	public void addObserver(IObserver o){
		listeObservateurs.add(o);
	}
	
	public void removeObserver(IObserver o){
		listeObservateurs.remove(o);
	}
	
	public void notifyObservers(){ // ou updateAllObservers() ou ...
		for(IObserver o  : listeObservateurs){
			o.update(); //ou o.notify() ou ....
		}
	}
	
}
