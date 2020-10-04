
public class Carta {

	String palo;
	String num;
	
	
	
	public Carta(String palo, String num) {
		
		this.palo = palo;
		this.num = num;
	}

	public String getPalo() {
		return palo;
	}
	
	public String getNum() {
		return num;
	}

	@Override
	public String toString() {
		return num + " de " + palo;
	}

	
	
}
