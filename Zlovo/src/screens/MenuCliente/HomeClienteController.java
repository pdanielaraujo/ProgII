/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.MenuCliente;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import zlovo.Cliente;

/**
 * FXML Controller class
 *
 * @author Pedro
 */
public class HomeClienteController implements Initializable {
    
    Stage stage = zlovo.Zlovo.guiStage;
    
    @FXML
    private Label nome_label;

    @FXML
    private Label username_label;

    @FXML
    private Label numCC_label;

    @FXML
    private Label nif_label;

    @FXML
    private Label numTelef_label;

    @FXML
    private Label morada_label;

    @FXML
    private Label localidade_label;
    
    private Cliente cliente = (Cliente) stage.getUserData();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nome_label.setText(cliente.getNome());
        username_label.setText(cliente.getUsername());
        numCC_label.setText(String.valueOf(cliente.getNumCC()));
        nif_label.setText(String.valueOf(cliente.getNif()));
        numTelef_label.setText(String.valueOf(cliente.getNumTelef()));
        morada_label.setText(cliente.getMorada());
        localidade_label.setText(cliente.getLocalidade());
    }    
    
}
