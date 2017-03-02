package modelli;

public enum Infopagamento {
   TIPO1("Gratuito"),
   TIPO2("A pagamento");
   
	 
	private final  String infopagamento;
	
	Infopagamento(String infopagamento) {
		this.infopagamento= infopagamento;
	}
	
	public String toString() { 
		return infopagamento;
	}

 public static Infopagamento TrovaperInfopagamento (String infopag) {
 
 for (Infopagamento infopagamento:values()) 
		 {
	 if (infopagamento.equals(infopag))
 {return infopagamento; }
	
		 }
 return null;
 }


}