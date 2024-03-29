package tp.bridge.abstraction;

import tp.bridge.implementor.loisir.Loisir;
import tp.bridge.implementor.loisir.LoisirFactory;

public class SeFairePlaisir2 extends SeFairePlaisir {
	private Loisir loisir2;
	
	public SeFairePlaisir2(String typeLoisir,String typeLoisir2) {
		super(typeLoisir);
		this.loisir2 = LoisirFactory.createLoisir(typeLoisir2);
	}
	public SeFairePlaisir2(String typeLoisir) {
		this(typeLoisir,null);
	}
	
	public SeFairePlaisir2() {
		this(null,null);
	}

	@Override
	public String toString() {
        String descriptionLoisir1 = "";
        if(getLoisir()!=null) 
        	descriptionLoisir1= getLoisir().decrire() +  " (typeLoisir=" + getLoisir().getType().toString()+")";
        String descriptionLoisir2 = "" ;
        if(getLoisir2()!=null) 
        	descriptionLoisir2 = getLoisir2().decrire() +  " (typeLoisir=" + getLoisir2().getType().toString()+")";
		return "SeFairePlaisir2 [ " + descriptionLoisir1 + " , " + descriptionLoisir2 + "]";
	}

	public Loisir getLoisir2() {
		return loisir2;
	}

	public void setLoisir2(Loisir loisir2) {
		this.loisir2 = loisir2;
	}
	
	

}
