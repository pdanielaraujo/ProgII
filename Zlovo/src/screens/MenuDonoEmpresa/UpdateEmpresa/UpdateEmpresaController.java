/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.MenuDonoEmpresa.UpdateEmpresa;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import zlovo.DonoEmpresa;
import zlovo.Empresa;
import zlovo.Singleton;

/**
 * FXML Controller class
 *
 * @author Pedro
 */
public class UpdateEmpresaController implements Initializable {
    
    Stage stage = zlovo.Zlovo.guiStage;
    
    @FXML
    private TableView<Empresa> empresas_table;

    @FXML
    private TableColumn<Empresa, String> nomeEmpresa_col;

    @FXML
    private TableColumn<Empresa, String> moradaEmpresa_col;

    @FXML
    private TableColumn<Empresa, String> localidadeEmpresa_col;

    @FXML
    private TableColumn<Empresa, Integer> numTelefEmpresa_col;
    
    private DonoEmpresa donoemp = (DonoEmpresa) stage.getUserData();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        atualizarTabelaEmpresas();
    }    
    
    void atualizarTabelaEmpresas() {
        ObservableList<Empresa> lista_empresas = FXCollections.observableArrayList();
        
        for(Empresa emp : Singleton.instance.getEmpresas().values()) {
            if(emp.isAtivo() == true) {
                if (emp.getDono() == donoemp) {
                    lista_empresas.add(new Empresa(emp.getNome(), emp.getMorada(), emp.getLocalidade(), emp.getNumTelef(), emp.isAtivo(), emp.getDono()));
                }
            }
        }
        
        nomeEmpresa_col.setCellValueFactory(new PropertyValueFactory<>("nome"));
        moradaEmpresa_col.setCellValueFactory(new PropertyValueFactory<>("morada"));
        localidadeEmpresa_col.setCellValueFactory(new PropertyValueFactory<>("localidade"));
        numTelefEmpresa_col.setCellValueFactory(new PropertyValueFactory<>("numTelef"));
        
        empresas_table.setItems(lista_empresas);
    }
    
}
