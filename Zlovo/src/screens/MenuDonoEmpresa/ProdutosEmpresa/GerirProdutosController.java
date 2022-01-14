/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.MenuDonoEmpresa.ProdutosEmpresa;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import zlovo.Empresa;
import zlovo.Produto;
import zlovo.Singleton;

/**
 * FXML Controller class
 *
 * @author Pedro
 */
public class GerirProdutosController implements Initializable {
    
    @FXML
    private TableView<Produto> produtos_table;

    @FXML
    private TableColumn<Produto, String> nomeProduto_col;

    @FXML
    private TableColumn<Produto, String> categoriaProduto_col;

    @FXML
    private TableColumn<Produto, String> descricaoProduto_col;
    
    @FXML
    private TableColumn<Produto, Empresa> empresaProduto_col;
    
    @FXML
    private TableView<Map.Entry<String, Float>> precos_table;

    @FXML
    private TableColumn<Map.Entry<String, Float>, String> descricaoPreco_col;

    @FXML
    private TableColumn<Map.Entry<String, Float>, Float> preco_col;
    
    @FXML
    private TextField nome_txt;

    @FXML
    private TextField categoria_txt;

    @FXML
    private TextField descricao_txt;
    
    @FXML
    private TextField descricaoPreco_txt;

    @FXML
    private TextField preco_txt;
    
    @FXML
    private TextField descricaoPrecoAddPreco_txt;

    @FXML
    private TextField precoAddPreco_txt;
    
    @FXML
    private TextField nomeUpdate_txt;

    @FXML
    private TextField categoriaUpdate_txt;

    @FXML
    private TextField descricaoUpdate_txt;
    
    @FXML
    private Button criarProduto_btn;
    
    @FXML
    private Button atualizarProduto_btn;
    
    @FXML
    private Button criarPreco_btn;
    
    @FXML
    private Button verPrecos_btn;
    
    @FXML
    private ToggleButton showAddProduto_btn;

    @FXML
    private ToggleButton showUpdateProduto_btn;

    @FXML
    private ToggleButton showAddPreco_btn;

    @FXML
    private ToggleButton showUpdatePreco_btn;

    @FXML
    private ToggleButton showRemoveProduto_btn;

    @FXML
    private ToggleButton showRemovePreco_btn;
    
    @FXML
    private Pane addProduto_pane;
    
    @FXML
    private Pane updateProduto_pane;
    
    @FXML
    private Pane addPreco_pane;
    
    @FXML
    private ChoiceBox<Empresa> choicebox_empresas;
    
    @FXML
    private ChoiceBox<Empresa> choicebox_empresasUpdate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        atualizarTabelaProdutos();
        preencherChoiceBoxEmpresa();
        
        ToggleGroup buttonGroup = new ToggleGroup();
        showAddProduto_btn.setToggleGroup(buttonGroup);
        showUpdateProduto_btn.setToggleGroup(buttonGroup);
        showRemoveProduto_btn.setToggleGroup(buttonGroup);
        showAddPreco_btn.setToggleGroup(buttonGroup);
        showUpdatePreco_btn.setToggleGroup(buttonGroup);
        showRemovePreco_btn.setToggleGroup(buttonGroup);
        
        showAddProduto_btn.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue) {
                addProduto_pane.setVisible(true);
            } else {
                addProduto_pane.setVisible(false);
            }
        });
        
        showUpdateProduto_btn.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue) {
                updateProduto_pane.setVisible(true);
            } else {
                updateProduto_pane.setVisible(false);
            }
        });
        
        showAddPreco_btn.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue) {
                addPreco_pane.setVisible(true);
            } else {
                addPreco_pane.setVisible(false);
            }
        });
    }   
    
    void preencherChoiceBoxEmpresa(){
        // Preencher lista de empresas
        ObservableList<Empresa> lista_empresas = FXCollections.observableArrayList();
        for(Integer key : Singleton.instance.getEmpresas().keySet()) {
            Empresa empresa = Singleton.instance.getEmpresas().get(key);
            if(empresa.isAtivo()) {
                lista_empresas.add(empresa);
            }
        }
        choicebox_empresas.setItems(lista_empresas);
    }
    
    void atualizarTabelaProdutos() {
        ObservableList<Produto> lista_produtos = FXCollections.observableArrayList();
        
        for(Produto p : Singleton.instance.getProdutos().values()) {
            lista_produtos.add(p);
        }
        
        nomeProduto_col.setCellValueFactory(new PropertyValueFactory<>("nome"));
        categoriaProduto_col.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        descricaoProduto_col.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        empresaProduto_col.setCellValueFactory(new PropertyValueFactory<>("empresa"));
        
        produtos_table.setItems(lista_produtos);
        
//        Produto produto = produtos_table.getSelectionModel().getSelectedItem();
//        if(produto != null) {
//            atualizarTabelaPrecos(produto);
//            System.out.println("1");
//        } else {
//            System.out.println("2");
//        }
    }
    
    void atualizarTabelaPrecos() {
        Alert alert = new Alert(Alert.AlertType.NONE);
//        ObservableList<Produto> lista_precos = FXCollections.observableArrayList();
        
        Produto produto = produtos_table.getSelectionModel().getSelectedItem();
        System.out.println("produtos" + produto.getPreco());
        
        descricaoPreco_col.setCellValueFactory((CellDataFeatures<Map.Entry<String, Float>, String> param) -> new SimpleObjectProperty(param.getValue().getKey()));
        preco_col.setCellValueFactory((CellDataFeatures<Map.Entry<String, Float>, Float> param) -> new SimpleObjectProperty(param.getValue().getValue()));
        precos_table.getItems().setAll(produto.getPreco().entrySet());
    }
    
    @FXML
    void verPrecos(ActionEvent event) {
        atualizarTabelaPrecos();
    }
    
    @FXML
    void criarProduto(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.NONE);
                
        boolean exists = false;
        
        if(nome_txt.getText().trim().isEmpty() || categoria_txt.getText().trim().isEmpty() 
                || descricao_txt.getText().trim().isEmpty() || choicebox_empresas.getSelectionModel().isEmpty()) {
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Erro: Campos vazios");
            alert.setHeaderText("Tem de preencher os campos todos.");
            alert.show();
        } else {
            Produto produto = new Produto();
            HashMap<String,Float> preco = new HashMap<>();
            produto.setIdProduto(Singleton.instance.incrementIdProduto(produto));
            produto.setNome(nome_txt.getText());
            produto.setCategoria(categoria_txt.getText());
            produto.setDescricao(descricao_txt.getText());
            produto.setEmpresa(choicebox_empresas.getValue());
            preco.put(descricaoPreco_txt.getText(), Float.parseFloat(preco_txt.getText()));
            produto.setPreco(preco);
            
            for(Empresa emp : Singleton.instance.getEmpresas().values()) {
                if(emp.equals(choicebox_empresas.getValue())) {
                    System.out.println("empresa igual: " + emp);
                    ArrayList<Produto> produtos = new ArrayList<>();
                    produtos.add(produto);
                    emp.getProdutos().addAll(produtos);
                    System.out.println("lista local: " + produtos);
                    System.out.println("lista emp: " + emp.getProdutos());
                } else {
                    System.out.println("empresa não igual: " + emp);
                }
            }
            if(Singleton.instance.getProdutos().isEmpty()) {
                Singleton.instance.adicionarProdutos(produto);
                System.out.println("produto: " + produto);
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setTitle("Info: Empresa criada");
                alert.setHeaderText("A sua empresa foi criada com sucesso.");
                atualizarTabelaProdutos();
                alert.show();
            } else {
                Singleton.instance.adicionarProdutos(produto);
                System.out.println("produto: " + produto);
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setTitle("Info: Empresa criada");
                alert.setHeaderText("A sua empresa foi criada com sucesso.");
                alert.show();
                atualizarTabelaProdutos();
            }
        }
    }
    
    @FXML
    void criarPreco(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        Produto produto = produtos_table.getSelectionModel().getSelectedItem();
        System.out.println("produtos" + produto.getPreco());
        
        if(descricaoPrecoAddPreco_txt.getText().trim().isEmpty() || precoAddPreco_txt.getText().trim().isEmpty()) {
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Erro: Campos vazios");
            alert.setHeaderText("Tem de preencher os campos todos.");
            alert.show();
        } else {
            produto.getPreco().put(descricaoPrecoAddPreco_txt.getText(), Float.parseFloat(precoAddPreco_txt.getText()));
            Singleton.guardarDados();
            atualizarTabelaPrecos();
        }
    }
    
    @FXML
    void atualizarProduto(ActionEvent event) {
        
    }
    
}
