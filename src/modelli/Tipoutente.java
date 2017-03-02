package modelli;

public enum Tipoutente {
   TIPO1("Tesserato"),
   TIPO2("Istruttore"),
   TIPO3("Responsabilecentro");
	 
	private final  String tipoutente;
	
	Tipoutente(String tipoutente) {
		this.tipoutente= tipoutente;
	}
	
	public String toString() { 
		return tipoutente;
	}

 public static Tipoutente TrovaperTipoutente (String tipout) {
 
 for (Tipoutente tipoutente:values()) 
		 {
	 if (tipoutente.equals(tipout))
 {return tipoutente; }
	
		 }
 return null;
 }


}