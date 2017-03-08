package business;

import modelli.Tesserato;
public class Tesseratobusiness {
private static Tesseratobusiness instance;

public static Tesseratobusiness getInstance()
{
	if (instance == null)
		instance = new Tesseratobusiness();
	return instance;
}

public boolean verificaTesserato (String username,String pass)
{
	Tesserato t =new Tesserato(username,pass);
	return t.login();
}
}
