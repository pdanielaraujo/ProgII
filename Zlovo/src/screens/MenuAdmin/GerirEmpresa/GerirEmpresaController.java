/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.MenuAdmin.GerirEmpresa;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import zlovo.Empresa;

/**
 * FXML Controller class
 *
 * @author Pedro
 */
public class GerirEmpresaController implements Initializable {

    @FXML
    private TableView<Empresa> empresas_table;

    @FXML
    private TableColumn<Empresa, String> col_nome;

    @FXML
    private TableColumn<Empresa, Integer> col_numTelef;

    @FXML
    private TableColumn<Empresa, String> col_localidade;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
