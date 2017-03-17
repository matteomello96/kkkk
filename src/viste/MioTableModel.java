package viste;

import java.lang.reflect.Field;
import java.time.Year;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelli.Calendario;

public class MioTableModel extends AbstractTableModel {

	private ArrayList<Calendario> dati;
	
	public ArrayList<Calendario> getDati() {
		return dati;
	}

	public MioTableModel(ArrayList<Calendario> dati) {
		super();
		this.dati = dati;
	}

	@Override
	public int getRowCount() {
		if(dati!=null) return dati.size();
		else return 0;
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		//ArrayList<Utente>
		//data binding
		Calendario c=dati.get(rowIndex);
		if(columnIndex==0) return c.getNomecalendario();
		else if(columnIndex==1) return c.getAnnovalidita();
		
		return null;
	}

	@Override
	public Class getColumnClass(int column) {
		if(column==2) return Boolean.class;
		else return String.class;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}
	

	@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex==0) dati.get(rowIndex).setNomecalendario(aValue.toString());
        if(columnIndex==1) dati.get(rowIndex).setAnnovalidita(Year.parse(aValue.toString()));
    
        fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
    }
}
