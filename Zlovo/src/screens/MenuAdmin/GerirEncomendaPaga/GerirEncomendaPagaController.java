/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.MenuAdmin.GerirEncomendaPaga;

import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import zlovo.Empresa;
import zlovo.Encomenda;
import zlovo.Motard;
import zlovo.Singleton;
import zlovo.Utilizador;

/**
 * FXML Controller class
 *
 * @author Pedro
 */
public class GerirEncomendaPagaController implements Initializable {
    
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
    private TableColumn<Encomenda, Motard> motardEnc_col;
    
    @FXML
    private TableView<Motard> motards_table;

    @FXML
    private TableColumn<Motard, String> nomeMotard_col;

    @FXML
    private TableColumn<Motard, Integer> numTelef_col;

    @FXML
    private TableColumn<Motard, String> localidadeMotard_col;
    
    @FXML
    private Button atribuir_btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        atualizarTabelaEncomendas();
        atualizarTabelaMotards();
    }
    
    void atualizarTabelaEncomendas() {
        ObservableList<Encomenda> lista_encomendas = FXCollections.observableArrayList();
        
        for(Integer key : Singleton.instance.getEncomendas().keySet()) {
            Encomenda encomenda = Singleton.instance.getEncomendas().get(key);
            if(encomenda.getEstado() == 0 || encomenda.getEstado() == 1 || encomenda.getEstado() == 2 || encomenda.getEstado() == 4) {
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
                } else if(param.getValue().getEstado() == 2) {
                    return new SimpleObjectProperty<>("Em entrega");
                } else if(param.getValue().getEstado() == 4){
                    return new SimpleObjectProperty<>("Anulada");
                }
                return (ObservableValue<String>) param;
            }
        });
        motardEnc_col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Encomenda, Motard>, ObservableValue<Motard>>() {
            @Override
            public ObservableValue<Motard> call(TableColumn.CellDataFeatures<Encomenda, Motard> param) {
                if(param.getValue().getMotard()== null) {
                    return new SimpleObjectProperty<>();
                } else {
                    return new SimpleObjectProperty<>(param.getValue().getMotard());
                }
            }
        });
        
        encomendas_table.setItems(lista_encomendas);
    }
    
    void atualizarTabelaMotards() {
        ObservableList<Motard> lista_motards = FXCollections.observableArrayList();
        
        for(Integer key : Singleton.instance.getUtilizadores().keySet()) {
            Utilizador motardUtilizador = Singleton.instance.getUtilizadores().get(key);
            if(motardUtilizador instanceof Motard) {
                Motard motard = (Motard) motardUtilizador;
                if(!motard.isEmServico()) {
                    System.out.println("mot: " + motard);
                    System.out.println("mot: " + motard.isEmServico());
                    lista_motards.add(motard);
                }
            }
        }
        
        
        nomeMotard_col.setCellValueFactory(new PropertyValueFactory<>("nome"));
        localidadeMotard_col.setCellValueFactory(new PropertyValueFactory<>("localidade"));
        numTelef_col.setCellValueFactory(new PropertyValueFactory<>("numTelef"));
        
        motards_table.setItems(lista_motards);
    }
    
    @FXML
    void atribuirMotard(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        Encomenda encomenda = encomendas_table.getSelectionModel().getSelectedItem();
        Motard motard = motards_table.getSelectionModel().getSelectedItem();
        
        if(encomenda == null || motard == null) {
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Erro: Sem seleção");
            alert.setHeaderText("Tem de selecionar uma empresa e um motard.");
            alert.show();
        } else {
            if(encomenda.getEstado() == 1) {
                encomenda.setEstado(2);
                encomenda.setMotard(motard);
                motard.setEmServico(true);
                Singleton.instance.adicionarEncomendas(encomenda);
                atualizarTabelaEncomendas();
                atualizarTabelaMotards();
            } else if(encomenda.getEstado() == 0) {
                alert.setAlertType(Alert.AlertType.WARNING);
                alert.setTitle("Erro: Sem pagamento");
                alert.setHeaderText("Esta encomenda ainda não foi paga.");
                alert.show();
            } else if(encomenda.getEstado() == 2) {
                alert.setAlertType(Alert.AlertType.WARNING);
                alert.setTitle("Erro: Em entrega");
                alert.setHeaderText("Esta encomenda já se encontra em entrega.");
                alert.show();
            } else if(encomenda.getEstado() == 4) {
                alert.setAlertType(Alert.AlertType.WARNING);
                alert.setTitle("Erro: Encomenda anulada");
                alert.setHeaderText("Esta encomenda está anulada.");
                alert.show();
            }
        }
    }
    
}
