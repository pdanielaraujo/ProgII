/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.MenuCliente.AddEncomenda;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import zlovo.Empresa;
import zlovo.Singleton;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import zlovo.Produto;

/**
 * FXML Controller class
 *
 * @author Pedro
 */
public class AddEncomendaController implements Initializable {
    
    @FXML
    private TableView<Empresa> empresas_table;

    @FXML
    private TableColumn<Empresa, String> empresa_col;
    
    @FXML
    private TableView<Produto> produtos_table;

    @FXML
    private TableColumn<Produto, String> produto_col;
    
    @FXML
    private TableView<Map.Entry<String, Float>> precos_table;

    @FXML
    private TableColumn<Map.Entry<String, Float>, String> descricaoPreco_col;

    @FXML
    private TableColumn<Map.Entry<String, Float>, Float> preco_col;
    
    @FXML
    private TableColumn<Map.Entry<String, Float>, Produto> addBtn_col;
    
    @FXML
    private Button verProdutos_btn;
    
    @FXML
    private Button verPrecos_btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        atualizarTabelaEmpresas();
        atualizarTabelaProdutos();
    }
    
    void atualizarTabelaEmpresas() {
        ObservableList<Empresa> lista_empresas = FXCollections.observableArrayList();
        
        for(Integer key : Singleton.instance.getEmpresas().keySet()) {
            Empresa empresa = Singleton.instance.getEmpresas().get(key);
            if(empresa.isAtivo()) {
                lista_empresas.add(empresa);
                System.out.println("empresa: " + empresa.getNome() + "lista produtos: " + empresa.getProdutos());
            }
        }
        
        empresa_col.setCellValueFactory(new PropertyValueFactory<>("nome"));
        empresas_table.setItems(lista_empresas);
    }
    
    void atualizarTabelaProdutos() {
        ObservableList<Produto> lista_produtos = FXCollections.observableArrayList();
        
        Empresa empresa = empresas_table.getSelectionModel().getSelectedItem();
        
        for(Produto p : Singleton.instance.getProdutos().values()) {
            if(p.getEmpresa().equals(empresa)) {
                lista_produtos.add(p);
            }
        }
        
        produto_col.setCellValueFactory(new PropertyValueFactory<>("nome"));
        
        produtos_table.setItems(lista_produtos);
    }
    
    void atualizarTabelaPrecos() {
        Alert alert = new Alert(Alert.AlertType.NONE);
//        ObservableList<Produto> lista_precos = FXCollections.observableArrayList();
        
        Produto produto = produtos_table.getSelectionModel().getSelectedItem();
        System.out.println("produtos" + produto.getPreco());
        
        descricaoPreco_col.setCellValueFactory((TableColumn.CellDataFeatures<Map.Entry<String, Float>, String> param) -> new SimpleObjectProperty(param.getValue().getKey()));
        preco_col.setCellValueFactory((TableColumn.CellDataFeatures<Map.Entry<String, Float>, Float> param) -> new SimpleObjectProperty(param.getValue().getValue()));
//        addBtn_col.setCellValueFactory((TableColumn.CellDataFeatures<Map.Entry<String, Float>, Button> param) -> new SimpleObjectProperty(new Button("add")));
        precos_table.getItems().setAll(produto.getPreco().entrySet());
        addBtn_col.setCellFactory((param) -> new TableCell<Map.Entry<String, Float>, Produto>(){
            
            private final Button btn = new Button("Adicionar");
            
            {
                btn.setOnAction(event -> {
                    Map.Entry<String, Float> entry = getTableView().getItems().get(getIndex());
                    System.out.println("aaaasdsadsaa: " + entry.getKey());
                    System.out.println("aaaasdsadsaa: " + produto.getPreco().entrySet());
                });
            }
            
            
            @Override
            protected void updateItem(Produto p, boolean empty) {
                super.updateItem(p, empty);
                setGraphic(empty ? null : btn);
            }
        });
    }
    
    @FXML
    void verProdutos(ActionEvent event) {
        atualizarTabelaProdutos();
    }
    
    @FXML
    void verPrecos(ActionEvent event) {
        atualizarTabelaPrecos();
    }
    
}
