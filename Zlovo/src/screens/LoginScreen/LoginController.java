/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.LoginScreen;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import zlovo.Admin;
import zlovo.Cliente;
import zlovo.DonoEmpresa;
import zlovo.Motard;
import zlovo.Singleton;
import zlovo.Utilizador;

/**
 * FXML Controller class
 *
 * @author Pedro
 */
public class LoginController implements Initializable {
    
    Stage stage = zlovo.Zlovo.guiStage;
    
    @FXML
    private TextField username_txt;

    @FXML
    private PasswordField pass_txt;

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
        Singleton s = Singleton.instance;
        Alert alert = new Alert(Alert.AlertType.NONE);
        
        try{
            if(username_txt.getText().trim().isEmpty() || pass_txt.getText().trim().isEmpty()){
                alert.setAlertType(Alert.AlertType.WARNING);
                alert.setTitle("Erro: Campos vazios");
                alert.setHeaderText("Tem de preencher os campos todos.");
                alert.show();
            } else {
                Utilizador utilizador = s.login(username_txt.getText(), pass_txt.getText());
            
                System.out.println(utilizador.getNome());
                System.out.println(utilizador);
            
                if(utilizador instanceof Admin){
                    System.out.println("É um admin");
                    try{
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/MenuAdmin/MenuAdmin.fxml"));
                        Parent root = loader.load();
            
                        stage.getScene().setRoot(root);
                        stage.show();
                    } catch (IOException ioe) {
                        ioe.getMessage();
                    }
                } else if(utilizador instanceof Cliente) {
                    System.out.println("É um cliente");
                    try{
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/MenuCliente/MenuCliente.fxml"));
                        Parent root = loader.load();
            
                        stage.getScene().setRoot(root);
                        stage.show();
                    } catch (IOException ioe) {
                        ioe.getMessage();
                    }
                } else if(utilizador instanceof DonoEmpresa) {
                    System.out.println("É um dono de empresa");
                    try{
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/MenuDonoEmpresa/MenuDonoEmpresa.fxml"));
                        Parent root = loader.load();
            
                        stage.getScene().setRoot(root);
                        stage.show();
                    } catch (IOException ioe) {
                        ioe.getMessage();
                    }
                } else if(utilizador instanceof Motard) {
                    System.out.println("É um motard");
                    try{
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/MenuMotard/MenuMotard.fxml"));
                        Parent root = loader.load();
            
                        stage.getScene().setRoot(root);
                        stage.show();
                    } catch (IOException ioe) {
                        ioe.getMessage();
                    }
                }
            }
        } catch(NullPointerException npe) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Erro: Campos errados");
            alert.setHeaderText("Conta não existe ou credenciais erradas.");
            alert.show();
            System.out.println("Erro: Conta não existe ou credenciais erradas " + npe.getMessage());
        }
        
        
        
        
//        Utilizador utilizador = 
//        utilizador.login(nome_txt.getText(), pass_txt.getText());
        
//        try{
//            FileInputStream fileIn = new FileInputStream("utilizadores.txt");
//            ObjectInputStream in = new ObjectInputStream(fileIn);
//            utilizador = (Utilizador) in.readObject();
//            in.close();
//            fileIn.close();
//        }catch(IOException ex){
//            System.out.println("Erro: " + ex.getMessage());
//        }catch(ClassNotFoundException ex){
//            System.out.println("Contacto class not found. " + ex.getMessage());
//        }
        
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
