package modelli;

import java.io.IOException;


import dao.DisciplinedisponibiliDAO;


public class Disciplinedisponibili {
  private int combinazionelivdis ;
  private Livello livello;
  private Disciplina disciplina;
  private int maxiscrittiturno;
  private int costomensile;
  

public int getCombinazionelivdis() {
	return combinazionelivdis;
}
public void setCombinazionelivdis(int combinazionelivdis) {
	this.combinazionelivdis = combinazionelivdis;
}
public Livello getLivello() {
	return livello;
}
public void setLivello(Livello livello) {
	this.livello = livello;
}
public Disciplina getDisciplina() {
	return disciplina;
}
public void setDisciplina(Disciplina disciplina) {
	this.disciplina = disciplina;
}
public int getMaxiscrittiturno() {
	return maxiscrittiturno;
}
public void setMaxiscrittiturno(int maxiscrittiturno) {
	this.maxiscrittiturno = maxiscrittiturno;
}
public int getCostomensile() {
	return costomensile;
}
public void setCostomensile(int costomensile) {
	this.costomensile = costomensile;
}
public static Disciplinedisponibili CercaCombinazioneperDisciplina(String disciplina) throws IOException {
	return DisciplinedisponibiliDAO.getInstance().CercaperDisciplina(disciplina);
}

public static Disciplinedisponibili CercaCombinazioneperCombinazione(int combinazione) throws IOException {
	return DisciplinedisponibiliDAO.getInstance().CercaperCombinazione(combinazione);
}
public boolean InserisciCombinazionelivdis() {
	return 	DisciplinedisponibiliDAO.getInstance().InserisciCombinazionelivdis(this);
}
public static Disciplinedisponibili CercaCombinazioneperLivello(String livello) throws IOException {
	return DisciplinedisponibiliDAO.getInstance().CercaperLivello(livello);
}

}
