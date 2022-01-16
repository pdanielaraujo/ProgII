/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.MenuAdmin.AddAdmin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import zlovo.Admin;
import zlovo.Motard;
import zlovo.Singleton;
import zlovo.Utilizador;

/**
 * FXML Controller class
 *
 * @author Pedro
 */
public class AddAdminController implements Initializable {
    
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
    private Button add_btn;

    @FXML
    private PasswordField pass_txt;

    @FXML
    private RadioButton admin_rb;

    @FXML
    private RadioButton motard_rb;

    @FXML
    private TextField nome_txt;

    @FXML
    private TextField username_txt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup radioGroup = new ToggleGroup();
        admin_rb.setToggleGroup(radioGroup);
        admin_rb.setSelected(true);
        motard_rb.setToggleGroup(radioGroup);
    }  
    
    @FXML
    void addAdminMotard(ActionEvent event) {
        System.out.println("adicionou admin/motard");
        Alert alert = new Alert(Alert.AlertType.NONE);
        
        if(nome_txt.getText().trim().isEmpty() || pass_txt.getText().trim().isEmpty() || numCC_txt.getText().trim().isEmpty()
                || nif_txt.getText().trim().isEmpty() || numTelef_txt.getText().trim().isEmpty()
                || morada_txt.getText().trim().isEmpty() || localidade_txt.getText().trim().isEmpty()) {
            
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Erro: Campos vazios");
            alert.setHeaderText("Tem de preencher os campos todos.");
            alert.show();
        } else {
            if(admin_rb.isSelected()) {
                System.out.println("aaa ADMIN");
                Admin admin = new Admin();
                admin.setIdUtilizador(Singleton.instance.incrementIdUtilizador(admin));
                admin.setNome(nome_txt.getText());
                admin.setUsername(username_txt.getText());
                admin.setPassword(pass_txt.getText());
                admin.setNumCC(Integer.parseInt(numCC_txt.getText()));
                admin.setNif(Integer.parseInt(nif_txt.getText()));
                admin.setNumTelef(Integer.parseInt(numTelef_txt.getText()));
                admin.setMorada(morada_txt.getText());
                admin.setLocalidade(localidade_txt.getText());
                Singleton.instance.adicionarUtilizadores(admin);
            } else {
                System.out.println("aaa MOTARD");
                Motard motard = new Motard();
                motard.setIdUtilizador(Singleton.instance.incrementIdUtilizador(motard));
                motard.setNome(nome_txt.getText());
                motard.setUsername(username_txt.getText());
                motard.setPassword(pass_txt.getText());
                motard.setNumCC(Integer.parseInt(numCC_txt.getText()));
                motard.setNif(Integer.parseInt(nif_txt.getText()));
                motard.setNumTelef(Integer.parseInt(numTelef_txt.getText()));
                motard.setMorada(morada_txt.getText());
                motard.setLocalidade(localidade_txt.getText());
                motard.setEmServico(false);
                Singleton.instance.adicionarUtilizadores(motard);
            }
        }
    }
    
}
