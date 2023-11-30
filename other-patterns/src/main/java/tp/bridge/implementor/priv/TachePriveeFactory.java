package tp.bridge.implementor.priv;

public class TachePriveeFactory {
	
	public static TachePrivee createTachePrivee(String typeTache) {
		if(typeTache.contains("enfant"))
			return new GererEnfants();
		/* else if , else if */
		else
			return new FaireMenage(false,30);
	}
	
}
