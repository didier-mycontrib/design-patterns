package tp.bridge.implementor.loisir;

public class LoisirFactory {
	public static Loisir createLoisir(String typeLoisir) {
		if(typeLoisir.contains("ski"))
			return new FaireDuSki();
		if(typeLoisir.contains("natation"))
			return new Natation();
		if(typeLoisir.contains("film"))
			return new VisionnerFilm();
		else
			return new Lecture();
	}
}
