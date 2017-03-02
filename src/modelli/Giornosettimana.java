package modelli;

public enum Giornosettimana {
   TIPO1("Lunedi"),
   TIPO2("Martedi"),
	TIPO3("Mercoledi"),
	TIPO4("Giovedi"),
	TIPO5("Venerdi"),
	TIPO6("Sabato");
	
	
	
	private final  String giornosettimana;
	
	Giornosettimana(String giornosettimana) {
		this.giornosettimana= giornosettimana;
	}
	
	public String toString() { 
		return giornosettimana;
	}

 public static Giornosettimana TrovaperGiornosettimana (String giornoset) {
 
 for (Giornosettimana giornosettimana:values()) 
		 {
	 if (giornosettimana.equals(giornoset))
 {return giornosettimana; }
	
		 }
 return null;
 }


}