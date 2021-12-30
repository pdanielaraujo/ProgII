/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.RegisterScreen;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Pedro
 */
public class RegistoController implements Initializable {
    
    Stage stage = zlovo.Zlovo.guiStage;
    
    @FXML
    private TextField nome_txt;

    @FXML
    private PasswordField pass_txt;

    @FXML
    private TextField numCC_txt;

    @FXML
    private TextField nif_txt;

    @FXML
    private TextField numTelef_txt;

    @FXML
    private TextField morada_txt;

    @FXML
    private TextField localidade_txt;

    @FXML
    private Button register_btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    void criarConta(ActionEvent event) {
        System.out.println("Criou conta");
    }
    
    @FXML
    void goToLoginScreen(MouseEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/LoginScreen/Login.fxml"));
            Parent root = loader.load();
            
            stage.getScene().setRoot(root);
            stage.show();
        } catch (IOException ioe) {
            ioe.getMessage();
        }
    }
    
}
