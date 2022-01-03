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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import zlovo.Cliente;
import zlovo.DonoEmpresa;
import zlovo.Singleton;
import static zlovo.Singleton.instance;
import zlovo.Utilizador;

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
    private TextField username_txt;

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
    
    @FXML
    private RadioButton cliente_rb;

    @FXML
    private RadioButton donoEmpresa_rb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup radioGroup = new ToggleGroup();
        cliente_rb.setToggleGroup(radioGroup);
        cliente_rb.setSelected(true);
        donoEmpresa_rb.setToggleGroup(radioGroup);
    }    
    @FXML
    void criarConta(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        
        if(nome_txt.getText().trim().isEmpty() || pass_txt.getText().trim().isEmpty() || numCC_txt.getText().trim().isEmpty()
                || nif_txt.getText().trim().isEmpty() || numTelef_txt.getText().trim().isEmpty()
                || morada_txt.getText().trim().isEmpty() || localidade_txt.getText().trim().isEmpty()) {
            
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Erro: Campos vazios");
            alert.setHeaderText("Tem de preencher os campos todos.");
            alert.show();
        } else {
            
            if(cliente_rb.isSelected()) {
                System.out.println("aaa CLIENTE");
                Cliente cliente = new Cliente();
                cliente.setIdUtilizador(Singleton.instance.incrementIdUtilizador(cliente));
                cliente.setNome(nome_txt.getText());
                cliente.setUsername(username_txt.getText());
                cliente.setPassword(pass_txt.getText());
                cliente.setNumCC(Integer.parseInt(numCC_txt.getText()));
                cliente.setNif(Integer.parseInt(nif_txt.getText()));
                cliente.setNumTelef(Integer.parseInt(numTelef_txt.getText()));
                cliente.setMorada(morada_txt.getText());
                cliente.setLocalidade(localidade_txt.getText());
                Singleton.instance.registo(cliente);
            } else {
                System.out.println("aaa DONO EMPRESA");
                DonoEmpresa donoEmpresa = new DonoEmpresa();
                donoEmpresa.setIdUtilizador(Singleton.instance.incrementIdUtilizador(donoEmpresa));
                donoEmpresa.setNome(nome_txt.getText());
                donoEmpresa.setUsername(username_txt.getText());
                donoEmpresa.setPassword(pass_txt.getText());
                donoEmpresa.setNumCC(Integer.parseInt(numCC_txt.getText()));
                donoEmpresa.setNif(Integer.parseInt(nif_txt.getText()));
                donoEmpresa.setNumTelef(Integer.parseInt(numTelef_txt.getText()));
                donoEmpresa.setMorada(morada_txt.getText());
                donoEmpresa.setLocalidade(localidade_txt.getText());
                donoEmpresa.setAtivo(true);
                Singleton.instance.registo(donoEmpresa);
            }
        }
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
