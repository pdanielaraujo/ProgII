/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.LoginScreen;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import zlovo.Admin;
import zlovo.Cliente;
import zlovo.Utilizador;

/**
 * FXML Controller class
 *
 * @author Pedro
 */
public class LoginController implements Initializable {
    
    Stage stage = zlovo.Zlovo.guiStage;
    
    @FXML
    private TextField nome_txt;

    @FXML
    private TextField pass_txt;

    @FXML
    private Button login_btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    void entrarConta(ActionEvent event) {
        System.out.println("Entrou");
        Admin admin = null;
        //boolean e_subclasse = Utilizador.class.isAssignableFrom(Cliente.class);
        //System.out.println(e_subclasse);
        //admin.login();
        
        try{
            FileInputStream fileIn = new FileInputStream("admins.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            admin = (Admin) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException ex){
            System.out.println("Erro: " + ex.getMessage());
        }catch(ClassNotFoundException ex){
            System.out.println("Contacto class not found. " + ex.getMessage());
        }
        
        if(nome_txt.getText().equals(admin.getNome())) {
            System.out.println("admin existe, login");
        } else {
            System.out.println("admin não existe com este nome, cancel");
        }
        
        System.out.println(admin.getNome());
        
    }
    
    @FXML
    void goToRegisterScreen(MouseEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/RegisterScreen/Registo.fxml"));
            Parent root = loader.load();
            
            stage.getScene().setRoot(root);
            stage.show();
        } catch (IOException ioe) {
            ioe.getMessage();
        }
        
    }
    
}
