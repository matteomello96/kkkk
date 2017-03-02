package dao;
import java.util.ArrayList;
	import modelli.Modalitapagamento;
	import connessioneDB.DbConnection;

public class ModalitapagamentoDAO {

		private static ModalitapagamentoDAO instance;
		
		public static synchronized ModalitapagamentoDAO getInstance() {
			if(instance == null)
				instance = new ModalitapagamentoDAO();
			return instance;
		}
		
		public Modalitapagamento CercaperNome(String nomemodalita) {

			Modalitapagamento mod = new Modalitapagamento();
			
			ArrayList<String[]> result = DbConnection.getInstance().eseguiQuery("SELECT * FROM modalitapagamento WHERE nomemodalita='"+nomemodalita+"' ");
			
			if(result.size() == 0) return null;
			
			String[] riga = result.get(0);
			
			mod.setNomemodalita(riga[0]);
			
			
			
			
			return mod;
		}
	}

