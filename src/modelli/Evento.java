package modelli;

import java.util.Date;

public class Evento
{
	private String nomeevento;
	private Date dataevento;
	private String descrizione;
	private Infopagamento infopagamento;
	private Float costoevento;
	private Disciplinedisponibili disciplinedisponibili;
    private Istruttore istruttore;
    
    
    public Evento()
    {
    	super();
    }
    
    public Evento(String nomeevento, Date dataevento, String descrizione,Infopagamento infopagamento, Float costoevento, Disciplinedisponibili disciplinedisponibili, Istruttore istruttore) {
		super();
		this.nomeevento=nomeevento;
		this.dataevento=dataevento;
		this.descrizione=descrizione;
		this.infopagamento=infopagamento;
		this.costoevento=costoevento;
		this.disciplinedisponibili=disciplinedisponibili;
	    this.istruttore=istruttore;
	    
	}

	public String getNomeevento() {
		return nomeevento;
	}

	public void setNomeevento(String nomeevento) {
		this.nomeevento = nomeevento;
	}

	public Date getDataevento() {
		return dataevento;
	}

	public void setDataevento(Date dataevento) {
		this.dataevento = dataevento;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Infopagamento getInfopagamento() {
		return infopagamento;
	}

	public void setInfopagamento(Infopagamento infopagamento) {
		this.infopagamento = infopagamento;
	}

	public Float getCostoevento() {
		return costoevento;
	}

	public void setCostoevento(Float costoevento) {
		this.costoevento = costoevento;
	}



	public Istruttore getIstruttore() {
		return istruttore;
	}

	public void setIstruttore(Istruttore istruttore) {
		this.istruttore = istruttore;
	}

	public Disciplinedisponibili getDisciplinedisponibili() {
		return disciplinedisponibili;
	}

	public void setDisciplinedisponibili(Disciplinedisponibili disciplinedisponibili) {
		this.disciplinedisponibili = disciplinedisponibili;
	}

	    }