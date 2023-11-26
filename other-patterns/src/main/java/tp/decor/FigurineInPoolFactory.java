package tp.decor;

public class FigurineInPoolFactory {
	
    private static FigurineInPoolFactory uniqueInstance = null;
	
	public synchronized static FigurineInPoolFactory getInstance()	{
		if(uniqueInstance==null){
			uniqueInstance=new FigurineInPoolFactory();
		}
		return uniqueInstance;
	}
	
	Figurine[] figurineBasicPool=new Figurine[2];
	
	private FigurineInPoolFactory() {
		figurineBasicPool[0]=new FigurineHomme();
		figurineBasicPool[1]=new FigurineFemme();
	}
	
	Figurine getFigurineObject(int varianteNumber){
		int varianteIndex = varianteNumber%2;
		return figurineBasicPool[varianteIndex];
	}
}
