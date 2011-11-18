class Nourriture extends Element {
	protected String type;
	protected int valeurEnergetique;
	
	
	public Nourriture(String type, int valeurEnergetique) {
		this.type=type;
		this.valeurEnergetique=valeurEnergetique;
		
	}
	
	public int consommation(int nourritureDemandee) {
		// Renvoie la quantitŽ de nourriture maxi possible
		int nourriturePossible=this.valeurEnergetique;
		if (nourriturePossible>nourritureDemandee)
			return nourritureDemandee;
		else
			return nourriturePossible;
		
	}
}
