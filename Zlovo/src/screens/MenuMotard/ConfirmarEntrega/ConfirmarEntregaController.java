/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.MenuMotard.ConfirmarEntrega;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import zlovo.Empresa;
import zlovo.Encomenda;
import zlovo.Singleton;

/**
 * FXML Controller class
 *
 * @author Pedro
 */
public class ConfirmarEntregaController implements Initializable {
    
    @FXML
    private TableView<Encomenda> encomendas_table;

    @FXML
    private TableColumn<Encomenda, Integer> idEnc_col;

    @FXML
    private TableColumn<Encomenda, Empresa> empresaEnc_col;

    @FXML
    private TableColumn<Encomenda, Float> precoTotalEnc_col;

    @FXML
    private TableColumn<Encomenda, String> estadoEnc_col;

    @FXML
    private Button encEntregue_btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    void atualizarTabelaEncomendas() {
        ObservableList<Encomenda> lista_encomendas = FXCollections.observableArrayList();
        
        for(Integer key : Singleton.instance.getEncomendas().keySet()) {
            Encomenda encomenda = Singleton.instance.getEncomendas().get(key);
            if(encomenda.getEstado() == 1) {
                lista_encomendas.add(encomenda);
            }
        }
        
        empresaEnc_col.setCellValueFactory(new PropertyValueFactory<>("empresa"));
        idEnc_col.setCellValueFactory(new PropertyValueFactory<>("idEncomenda"));
        precoTotalEnc_col.setCellValueFactory((TableColumn.CellDataFeatures<Encomenda, Float> param) -> new SimpleObjectProperty(param.getValue().getPrecoTotal() + "€"));
        estadoEnc_col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Encomenda, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Encomenda, String> param) {
                if(param.getValue().getEstado() == 0) {
                    return new SimpleObjectProperty<>("Por pagar");
                } else if(param.getValue().getEstado() == 1) {
                    return new SimpleObjectProperty<>("Paga");
                } else if(param.getValue().getEstado() == 4){
                    return new SimpleObjectProperty<>("Anulada");
                }
                return (ObservableValue<String>) param;
            }
            
        });
        
        encomendas_table.setItems(lista_encomendas);
    }
    
}
