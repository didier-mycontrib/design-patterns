package tp.dessin.observateur;

//NB: l'équivalent prédéfini etait java.util.Observer mais c'est devenu obsolète dans Java 9

public interface IObserver {
	public void update(); // or notify() or ...
}
