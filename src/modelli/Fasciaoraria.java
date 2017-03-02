package modelli;

public enum Fasciaoraria {
   TIPO1("8:30-9:30"),
   TIPO2("9:30-10:30"),
	TIPO3("10:30-11:30"),
	TIPO4("11:30-12:30"),
	TIPO5("15:30-16:30"),
	TIPO6("16:30-17:30"),
	TIPO7("18:30-19:30"),
	TIPO8("20:30-21:30"),
	TIPO9("21:30-22:30");
	
	
	
	private final  String fasciaoraria;
	
	Fasciaoraria(String fasciaoraria) {
		this.fasciaoraria= fasciaoraria;
	}
	
	public String toString() { 
		return fasciaoraria;
	}

 public static Fasciaoraria TrovaperFasciaOraria (String orario) {
 
 for (Fasciaoraria fasciaoraria:values()) 
		 {
	 if (fasciaoraria.equals(orario))
 {return fasciaoraria; }
	
		 }
 return null;
 }


}