package modelli;

import dao.SceltaDAO;



public class Scelta {
  private String scelta;

public String getScelta() {
	return scelta;
}

public void setScelta(String scelta) {
	this.scelta = scelta;
}
public static Scelta MostraSceltaperNome(String scelta)  {
	return SceltaDAO.getInstance().MostraScelta(scelta);
}
}
