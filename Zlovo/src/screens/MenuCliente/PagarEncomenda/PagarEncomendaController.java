/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.MenuCliente.PagarEncomenda;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import zlovo.Encomenda;
import zlovo.Singleton;

/**
 * FXML Controller class
 *
 * @author Pedro
 */
public class PagarEncomendaController implements Initializable {
    
    @FXML
    private TableView<Encomenda> encomendas_table;

    @FXML
    private TableColumn<Encomenda, Integer> idEnc_col;

    @FXML
    private TableColumn<Encomenda, Float> precoTotalEnc_col;

    @FXML
    private TableColumn<Encomenda, String> estadoEnc_col;
    
    @FXML
    private Button pagarReferencia_btn;
    
    @FXML
    private Label entidade_txt;

    @FXML
    private Label referencia_txt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        atualizarTabelaEncomendas();
    }
    
    void atualizarTabelaEncomendas() {
        ObservableList<Encomenda> lista_encomendas = FXCollections.observableArrayList();
        
        for(Integer key : Singleton.instance.getEncomendas().keySet()) {
            Encomenda encomenda = Singleton.instance.getEncomendas().get(key);
            if(encomenda.getEstado() == 0) {
                lista_encomendas.add(encomenda);
            }
        }
        
        
        idEnc_col.setCellValueFactory(new PropertyValueFactory<>("idEncomenda"));
        precoTotalEnc_col.setCellValueFactory((TableColumn.CellDataFeatures<Encomenda, Float> param) -> new SimpleObjectProperty(param.getValue().getPrecoTotal() + "€"));
        estadoEnc_col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Encomenda, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Encomenda, String> param) {
                if(param.getValue().getEstado() == 0) {
                    return new SimpleObjectProperty<>("Por pagar");
                } else if(param.getValue().getEstado() == 1) {
                    return new SimpleObjectProperty<>("Paga");
                }
                return (ObservableValue<String>) param;
            }
            
        });
        
        encomendas_table.setItems(lista_encomendas);
    }
    
    @FXML
    void pagar(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        Random rand = new Random();
        
        Encomenda encomenda = encomendas_table.getSelectionModel().getSelectedItem();
                
        int referencia = 100000000 + rand.nextInt(900000000);
        
        if(encomenda == null) {
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Erro: Sem seleção");
            alert.setHeaderText("Tem de selecionar uma empresa.");
            alert.show();
        } else {
            entidade_txt.setText(String.valueOf(encomenda.getEmpresa().getEntidade()));
            referencia_txt.setText(String.valueOf(referencia));
        }
    }
}
