package listeners;
import business.Tesseratobusiness;
import viste.vistaTesserato;
import viste.LoginWindows2;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JOptionPane;
 
public class LoginBtnListener implements ActionListener {
private LoginWindows2 loginWindows2;
     
    public LoginBtnListener(LoginWindows2 loginWindows2) {
        super();
        this.loginWindows2 = loginWindows2;
         
    }
     
    public void actionPerformed(ActionEvent e) {
     
         
        String username = loginWindows2.username.getText();
        String pass = loginWindows2.password.getText();
 
         
        boolean tesseratoEsiste = Tesseratobusiness.getInstance().verificaTesserato(username, pass);
        if(tesseratoEsiste){
            JOptionPane.showMessageDialog(null, "Benvenuto!");
        new vistaTesserato();
        loginWindows2.dispose();
            }
        else{
             
        }
 
    }
     
}