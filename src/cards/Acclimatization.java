package cards;

public class Acclimatization extends Card {
	
	private int acclimatization;

	public Acclimatization(int acclimatization) {
		
		this.acclimatization = acclimatization;
		super.path = "acclimatization" + Integer.toString(this.acclimatization);
		super.createImage();

	}

}
