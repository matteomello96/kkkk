package modelli;

import java.util.Date;

public class Iscrizioneevento
{

	private Date dataazione;
	private Modalitapagamento modalitapagamento;
	private Tesserato tesserato;
	
    
    public Iscrizioneevento()
    {
    	super();
    }
    
    public Iscrizioneevento(Date dataazione, Modalitapagamento modalitapagamento,Tesserato tesserato) {
		super();
		
		this.dataazione=dataazione;
		this.modalitapagamento=modalitapagamento;
		this.tesserato=tesserato;
	

	
    
	}

	public Date getDataazione() {
		return dataazione;
	}

	public void setDataazione(Date dataazione) {
		this.dataazione = dataazione;
	}

	

	public Modalitapagamento getModalitapagamento() {
		return modalitapagamento;
	}

	public void setModalitapagamento(Modalitapagamento modalitapagamento) {
		this.modalitapagamento = modalitapagamento;
	}


	public Tesserato getTesserato() {
		return tesserato;
	}

	public void setTesserato(Tesserato tesserato) {
		this.tesserato = tesserato;
	}

	
	    }