package modelli;

public class Gestioneturno {
	private int codiceturno;
	private Fasciaoraria fasciaoraria;
	private Giornosettimana giornosettimana;
	private Disciplinedisponibili disciplinedisponibili;
	private Spazio spazio;

	public int getCodiceturno() {
		return codiceturno;
	}
	public void setCodiceturno(int codiceturno) {
		this.codiceturno = codiceturno;
	}
	public Fasciaoraria getFasciaoraria() {
		return fasciaoraria;
	}
	public void setFasciaoraria(Fasciaoraria fasciaoraria) {
		this.fasciaoraria = fasciaoraria;
	}
	public Giornosettimana getGiornosettimana() {
		return giornosettimana;
	}
	public void setGiornosettimana(Giornosettimana giornosettimana) {
		this.giornosettimana = giornosettimana;
	}
	public Disciplinedisponibili getDisciplinedisponibili() {
		return disciplinedisponibili;
	}
	public void setDisciplinedisponibili(Disciplinedisponibili disciplinedisponibili) {
		this.disciplinedisponibili = disciplinedisponibili;
	}
	public Spazio getSpazio() {
		return spazio;
	}
	public void setSpazio(Spazio spazio) {
		this.spazio = spazio;
	}
}
