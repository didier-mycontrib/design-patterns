package tp.bridge.implementor.pro;

public class ProfessionFactory {
	
	public static Profession createProfession(String typeTravail) {
		if(typeTravail.contains("informatique"))
			return new Informaticien();
		/* else if , else if */
		else
			return new Agriculteur();
	}

}
