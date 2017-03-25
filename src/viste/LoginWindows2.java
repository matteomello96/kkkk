package viste;




import listeners.LoginBtnListener;

 
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
 
public class LoginWindows2 extends JFrame {
	public JLabel testo;
    public JTextField username = new JTextField();
    public JTextField password = new JTextField();
    public LoginWindows2()
    {
        super("Effettua Login");
        Container c = this.getContentPane();
        this.setLayout(new GridLayout(3,1));
        testo = new JLabel("Registrati o effettua il login");
        JButton login = new JButton("Effettua login");
         
        login.addActionListener(new LoginBtnListener(this));
        
        c.add(username);
        c.add(password);
        c.add(login);
         
        this.setSize(200,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
 
}
