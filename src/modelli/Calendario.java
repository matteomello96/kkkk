 package modelli;

import java.time.Year;

import dao.CalendarioDAO;


public class Calendario {
  private String nomecalendario;
  private Year annovalidita;
  
public String getNomecalendario() {
	return nomecalendario;
}
public void setNomecalendario(String nomecalendario) {
	this.nomecalendario = nomecalendario;
}
public Year getAnnovalidita() {
	return annovalidita;
}
public void setAnnovalidita(Year annovalidita) {
	this.annovalidita = annovalidita;
}
public static Calendario CercaCalendarioperNome(String nome) {
	return CalendarioDAO.getInstance().CercaperNome(nome);
}
public boolean InserisciCalendario() {
	return CalendarioDAO.getInstance().InserisciCalendario(this);
}
public static Calendario CercaCalendarioperAnnovalidita(Year anno) {
	return CalendarioDAO.getInstance().CercaperAnnoValidita(anno);
}
public static Calendario VisualizzaCalendario(Year anno,String nome) {
	return CalendarioDAO.getInstance().VisualizzaCalendario(anno,nome);
}

}
