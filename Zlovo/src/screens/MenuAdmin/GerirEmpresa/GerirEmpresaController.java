/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.MenuAdmin.GerirEmpresa;

import java.net.URL;
import java.util.ListIterator;
import java.util.Map;
import java.util.ResourceBundle;
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
import zlovo.DonoEmpresa;
import zlovo.Empresa;
import zlovo.Singleton;
import zlovo.Utilizador;

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
    
    @FXML
    private TableColumn<Empresa, DonoEmpresa> col_dono;
    
    @FXML
    private TableView<DonoEmpresa> donosEmpresas_table;
    
    @FXML
    private TableColumn<DonoEmpresa, String> col_nomeDono;

    @FXML
    private TableColumn<DonoEmpresa, Integer> col_numTelefDono;

    @FXML
    private TableColumn<DonoEmpresa, Integer> col_numCCDono;

    @FXML
    private TableColumn<DonoEmpresa, Integer> col_nifDono;

    @FXML
    private TableColumn<DonoEmpresa, String> col_localidadeDono;
    
    @FXML
    private Button desativarEmpresa_btn;
    
    @FXML
    private Button desativarDonoEmpresa_btn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        atualizarTabelaEmpresas();
        atualizarTabelaDonosEmpresas();
    }
    
    @FXML
    void desativarEmpresa(ActionEvent event) {
        Empresa empresa = empresas_table.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.NONE);

        if(empresa != null) {
            Singleton.instance.getEmpresas().get(empresa.getIdEmpresa());
            System.out.println("id dono: " + empresa.getIdEmpresa());
            System.out.println("dono aa: " + Singleton.instance.getEmpresas().get(empresa.getIdEmpresa()));
            empresa.setAtivo(false);
            Singleton.instance.getEmpresas().put(empresa.getIdEmpresa(), empresa);
            Singleton.guardarDados();
            atualizarTabelaEmpresas();
        } else {
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Erro: Sem dono selecionado");
            alert.setHeaderText("Tem de selecionar um dono de empresa.");
            alert.show();
        }
    }
    
    @FXML
    void desativarDonoEmpresa(ActionEvent event) {
        DonoEmpresa donoEmpresa = donosEmpresas_table.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.NONE);

        if(donoEmpresa != null) {
            Singleton.instance.getUtilizadores().get(donoEmpresa.getIdUtilizador());
            System.out.println("id dono: " + donoEmpresa.getIdUtilizador());
            System.out.println("dono aa: " + Singleton.instance.getUtilizadores().get(donoEmpresa.getIdUtilizador()));
            donoEmpresa.setAtivo(false);
            Singleton.instance.getUtilizadores().put(donoEmpresa.getIdUtilizador(), donoEmpresa);
            Singleton.guardarDados();
            atualizarTabelaDonosEmpresas();
        } else {
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Erro: Sem dono selecionado");
            alert.setHeaderText("Tem de selecionar um dono de empresa.");
            alert.show();
        }
        
    }
    
    void atualizarTabelaEmpresas() {
        ObservableList<Empresa> lista_empresas = FXCollections.observableArrayList();
        
        for(Integer key : Singleton.instance.getEmpresas().keySet()) {
            Empresa empresa = Singleton.instance.getEmpresas().get(key);
            if(empresa.isAtivo()) {
                lista_empresas.add(empresa);
            }
        }
        
        col_nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        col_localidade.setCellValueFactory(new PropertyValueFactory<>("localidade"));
        col_numTelef.setCellValueFactory(new PropertyValueFactory<>("numTelef"));
        col_dono.setCellValueFactory(new PropertyValueFactory<>("dono"));
        
        empresas_table.setItems(lista_empresas);
    }
    
    void atualizarTabelaDonosEmpresas() {
        ObservableList<DonoEmpresa> lista_donosEmpresas = FXCollections.observableArrayList();
        
        for(Integer key : Singleton.instance.getUtilizadores().keySet()) {
            Utilizador donoEmpUtilizador = Singleton.instance.getUtilizadores().get(key);
            if(donoEmpUtilizador instanceof DonoEmpresa) {
                DonoEmpresa donoEmp = (DonoEmpresa) donoEmpUtilizador;
                if(donoEmp.isAtivo()) {
                    lista_donosEmpresas.add(donoEmp);
                }
            }
        }
        
        col_nomeDono.setCellValueFactory(new PropertyValueFactory<>("nome"));
        col_numTelefDono.setCellValueFactory(new PropertyValueFactory<>("numTelef"));
        col_numCCDono.setCellValueFactory(new PropertyValueFactory<>("numCC"));
        col_nifDono.setCellValueFactory(new PropertyValueFactory<>("nif"));
        col_localidadeDono.setCellValueFactory(new PropertyValueFactory<>("localidade"));
        
        donosEmpresas_table.setItems(lista_donosEmpresas);
    }
    
}
