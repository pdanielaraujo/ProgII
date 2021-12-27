/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.RegisterScreen;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Pedro
 */
public class RegistoController implements Initializable {
    
    @FXML
    private TextField nome_txt;

    @FXML
    private TextField pass_txt;

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
    
}
