package tp.decor;

public class MyMemento {
	private int lastColorIndex;
	private boolean lastFilled;
	

	public MyMemento(int lastColorIndex, boolean lastFilled) {
		this.lastColorIndex = lastColorIndex;
		this.lastFilled = lastFilled;
	}
	
	public MyMemento() {
		this(0,false);
	}

	@Override
	public String toString() {
		return "MyMemento [lastColorIndex=" + lastColorIndex + ", lastFilled=" + lastFilled + "]";
	}
	
	public int getLastColorIndex() {
		return lastColorIndex;
	}
	public void setLastColorIndex(int lastColorIndex) {
		this.lastColorIndex = lastColorIndex;
	}
	public boolean isLastFilled() {
		return lastFilled;
	}
	public void setLastFilled(boolean lastFilled) {
		this.lastFilled = lastFilled;
	}
	
	
}
