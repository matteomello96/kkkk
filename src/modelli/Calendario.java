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


}
