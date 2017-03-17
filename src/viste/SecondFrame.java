package viste;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import modelli.Calendario;
import listeners.Ascoltatore;
import listeners.InvioListener;
import listeners.LoginBtnListener;
import listeners.MouseSpy;

public class SecondFrame extends JFrame {

	private JButton nord;
	private JButton ovest;
	private JButton centro;
	private JButton est;
	private JButton sud;

	private JPanel centroPnl;
	private JPanel sudPnl; 
	private JPanel pnlWithImg;
	private JPanel tabellaPnl;
	
	private JMenuBar menuBar;
	private JMenu file;
	private JMenu edit;
	private JMenu move;
	private JMenuItem random;
	private JMenuItem up;
	private JMenuItem down;
	
	
	
	private JButton readTabelBtn;
	private JTextArea textArea;
	
	private JTable tabella;

	public JTable getTabella() {
		return tabella;
	}

	public void setTabella(JTable tabella) {
		this.tabella = tabella;
	}

	public JPanel getCentroPnl() {
		return centroPnl;
	}

	public JPanel getPnlWithImg() {
		return pnlWithImg;
	}
	
	

	
	public SecondFrame(String title) throws HeadlessException {
		super(title);

		setSize(800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		
		String[][] rowData = new String[2][3];
		rowData[0][0] = "a";
		rowData[0][1] = "b";
		rowData[0][2] = "c";
		rowData[1][0] = "d";
		rowData[1][1] = "e";
		rowData[1][2] = "f";
		
		String[] columnNames=new String[3];
		columnNames[0] = "nomecalendario";
		columnNames[1] = "annovalidita";
		
		
		//tabella = new JTable(rowData, columnNames);

		ArrayList<Calendario> dati = new ArrayList<Calendario>();
		
		
		MioTableModel mio= new MioTableModel(dati);
		tabella = new JTable(mio);
		tabellaPnl = new JPanel();
		tabellaPnl.setLayout(new GridLayout(2, 1));
		tabellaPnl.add(tabella.getTableHeader());
		tabellaPnl.add(tabella);
		
		pnlWithImg=new JPanel();
		
		
		/*
		nord = new JButton("Nord");
		ovest = new JButton("Ovest");
		centro = new JButton("Centro");
		est = new JButton("Est");
		sud = new JButton("Sud");

		getContentPane().add(nord, BorderLayout.NORTH);
		getContentPane().add(ovest, BorderLayout.WEST);
		getContentPane().add(centro, BorderLayout.CENTER);
		getContentPane().add(est, BorderLayout.EAST);
		getContentPane().add(sud, BorderLayout.SOUTH);
		*/

		
		readTabelBtn = new JButton("Leggi tabella");
		
		centroPnl = new JPanel();
		sudPnl = new JPanel();
		
		centroPnl.setLayout(new GridLayout(4,3));
		sudPnl.setLayout(new FlowLayout());
		
		for(int i=0;i<10;i++)
			centroPnl.add(new JButton("BTN"+i));

		textArea= new JTextArea(5, 10);
		centroPnl.add(textArea);
		
		
		
		sudPnl.add(readTabelBtn);
		
		//getContentPane().add(centroPnl, BorderLayout.CENTER);
		getContentPane().add(tabellaPnl, BorderLayout.CENTER);
		//getContentPane().add(pnlWithImg, BorderLayout.CENTER);
		getContentPane().add(sudPnl, BorderLayout.SOUTH);
		
		setMinimumSize(new Dimension(400,300));
		
		menuBar = new JMenuBar();

		file = new JMenu("File");
		edit = new JMenu("Edit");
		move = new JMenu("Move");
		random = new JMenuItem("Random");
		up = new JMenuItem("Up");
		down = new JMenuItem("Down");
		
		move.add(up);
		move.add(down);
		
		edit.add(move);
		edit.add(random);

		menuBar.add(file);
		menuBar.add(edit);
		
		setJMenuBar(menuBar);

		addMouseListener(new MouseSpy());
		//loginBtn.addActionListener(new Ascoltatore());
		
		/* trucchetto...
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				usernameTxt.getText();
				passwordTxt.getPassword();
				//chiama il LoginBusiness
				
			}
		});*/
		
		
		
		setVisible(true);
	}

	
}
