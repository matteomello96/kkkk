package modelli;

public class Utentegenerico
{
	private String nome;
	private String cognome;
	private String codicefiscale;
	private String via;
	private String numerocivico;
	private String cittaresidenza;
    protected String username;
    protected String pass;
    private String numerotelefono;
    private String indirizzomail;
    
    public Utentegenerico()
    {
    	super();
    }
    
    public Utentegenerico(String nome, String cognome, String codicefiscale, String via, String numerocivico, String cittaresidenza,String username,String pass,String numerotelefono,String indirizzomail) {
		super();
		this.nome=nome;
		this.cognome=cognome;
		this.codicefiscale=codicefiscale;
		this.via=via;
		this.numerocivico=numerocivico;
		this.cittaresidenza=cittaresidenza;
	    this.username=username;
	    this.pass=pass;
	    this.numerotelefono=numerotelefono;
	    this.indirizzomail=indirizzomail;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodicefiscale() {
		return codicefiscale;
	}

	public void setCodicefiscale(String codicefiscale) {
		this.codicefiscale = codicefiscale;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getNumerocivico() {
		return numerocivico;
	}

	public void setNumerocivico(String numerocivico) {
		this.numerocivico = numerocivico;
	}

	public String getCittaresidenza() {
		return cittaresidenza;
	}

	public void setCittaresidenza(String cittaresidenza) {
		this.cittaresidenza = cittaresidenza;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNumerotelefono() {
		return numerotelefono;
	}

	public void setNumerotelefono(String numerotelefono) {
		this.numerotelefono = numerotelefono;
	}

	public String getIndirizzomail() {
		return indirizzomail;
	}

	public void setIndirizzomail(String indirizzomail) {
		this.indirizzomail = indirizzomail;
	}
    
    
    
    }