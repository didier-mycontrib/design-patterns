package tp.bridge.implementor.loisir;

public class VisionnerFilm implements Loisir{

	@Override
	public String decrire() {
		return "visionner film";
	}
	
	@Override
	public TypeLoisir getType() {
		return TypeLoisir.CULTUREL;
	}

}
