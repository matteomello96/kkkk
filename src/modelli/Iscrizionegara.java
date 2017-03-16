package modelli;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import dao.IscrizionegaraDAO;

public class Iscrizionegara extends Iscrizioneevento {
	private int codiceiscrizionegara;
	private File certificatoRC;
	private Gara gara;
	//manca il campo note
	public int getCodiceiscrizionegara() {
		return codiceiscrizionegara;
	}
	public void setCodiceiscrizionegara(int codiceiscrizionegara) {
		this.codiceiscrizionegara = codiceiscrizionegara;
	}
	public File getCertificatoRC() {
		return certificatoRC;
	}
	public void setCertificatoRC(File certificatoRC) {
		this.certificatoRC = certificatoRC;
	}
	public static Iscrizionegara CercaIscrizionegaraperCodice(int codiceiscrizionegara) throws IOException {
		return IscrizionegaraDAO.getInstance().CercaperCodice(codiceiscrizionegara);
	}
	public Gara getGara() {
		return gara;
	}
	public void setGara(Gara gara) {
		this.gara = gara;
	}
	
	public String readFile(String pathname) throws IOException {

	    File file = new File(pathname);
	    StringBuilder fileContents = new StringBuilder((int)file.length());
	    Scanner scanner = new Scanner(file);
	    String lineSeparator = System.getProperty("line.separator");

	    try {
	        while(scanner.hasNextLine()) {
	            fileContents.append(scanner.nextLine() + lineSeparator);
	        }
	        return fileContents.toString();
	    } finally {
	        scanner.close();
	    }
	}
}
