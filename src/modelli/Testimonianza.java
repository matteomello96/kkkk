package modelli;

import java.io.IOException;
import java.util.Date;
import dao.TestimonianzaDAO;

public class Testimonianza
{ 
	private int codicetestimonianza;
    private String commento;
	private Date dataazione;
	private Tesserato tesserato;
	private Disciplina disciplina;
	
	public Date getDataazione() {
		return dataazione;
	}

	public void setDataazione(Date dataazione) {
		this.dataazione = dataazione;
	}

	public Tesserato getTesserato() {
		return tesserato;
	}

	public void setTesserato(Tesserato tesserato) {
		this.tesserato = tesserato;
	}

	public String getCommento() {
		return commento;
	}

	public void setCommento(String commento) {
		this.commento = commento;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public static Testimonianza CercaTestimonianzaperCodice(int codicetestimonianza) throws IOException {
		return TestimonianzaDAO.getInstance().CercaperCodice(codicetestimonianza);
	}

	public int getCodicetestimonianza() {
		return codicetestimonianza;
	}

	public void setCodicetestimonianza(int codicetestimonianza) {
		this.codicetestimonianza = codicetestimonianza;
	}
	
	
	    }