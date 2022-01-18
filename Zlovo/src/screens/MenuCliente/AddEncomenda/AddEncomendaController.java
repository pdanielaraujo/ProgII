/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.MenuCliente.AddEncomenda;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import zlovo.Empresa;
import zlovo.Singleton;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import zlovo.Encomenda;
import zlovo.Produto;

/**
 * FXML Controller class
 *
 * @author Pedro
 */
public class AddEncomendaController implements Initializable {
    
    Stage stage = zlovo.Zlovo.guiStage;
    
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
    
    @FXML
    private Button irPagar_btn;
    
    @FXML
    private VBox containerCarrinho;
    
    @FXML
    private Label valorTotal_txt;
    
    @FXML
    private ScrollPane scrollEncomenda;
    
    Encomenda encomenda = new Encomenda();
    ArrayList<Produto> produtosEncomenda = new ArrayList<>();
    float precoTotal = 0;
    ArrayList<Float> preco = new ArrayList<>();
    ArrayList<Pane> panes = new ArrayList<>();
    Pane pa = new Pane();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        atualizarTabelaEmpresas();
        atualizarTabelaProdutos();
        scrollEncomenda.setHbarPolicy(ScrollBarPolicy.NEVER);
        scrollEncomenda.setVbarPolicy(ScrollBarPolicy.ALWAYS);
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
        
        Produto produto = produtos_table.getSelectionModel().getSelectedItem();
        System.out.println("produtos" + produto.getPreco());
        
        descricaoPreco_col.setCellValueFactory((TableColumn.CellDataFeatures<Map.Entry<String, Float>, String> param) -> new SimpleObjectProperty(param.getValue().getKey()));
        preco_col.setCellValueFactory((TableColumn.CellDataFeatures<Map.Entry<String, Float>, Float> param) -> new SimpleObjectProperty(param.getValue().getValue() + "€"));
        precos_table.getItems().setAll(produto.getPreco().entrySet());

        addBtn_col.setCellFactory(new Callback<TableColumn<Map.Entry<String, Float>, Produto>, TableCell<Map.Entry<String, Float>, Produto>>() {
          @Override
          public TableCell<Map.Entry<String, Float>, Produto> call(TableColumn<Map.Entry<String, Float>, Produto> param) {
              final TableCell<Map.Entry<String, Float>, Produto> cell = new TableCell<Map.Entry<String, Float>, Produto>() {
                  private Button btn = new Button("Carrinho");
                  
                  Pane pane = new Pane();
                  int lengthId= 0;
                  
                  {
                      
                      btn.setMaxWidth(Double.MAX_VALUE);
                      btn.setMaxHeight(Double.MIN_VALUE);
                      btn.setStyle("-fx-background-color: #7fa6c9; -fx-text-fill: white; -fx-cursor: hand;");
                      
                      btn.setOnAction((ActionEvent event) -> {
                          Map.Entry<String, Float> entry = getTableView().getItems().get(getIndex());
                          
                          produtosEncomenda.add(produto);
                          Encomenda e = new Encomenda();
                          e.setProdutos(produtosEncomenda);
                          preco.add(entry.getValue());
                          precoTotal += entry.getValue();
                          e.setPrecoTotal(precoTotal);
                          e.setDescricao(entry.getKey());
                          e.setEstado(0);
                          e.setEmpresa(produto.getEmpresa());
                          encomenda = e;
                          
                          String paneId = "id0" + Integer.toString(lengthId++);
                          
  
  
                          Label prodNome = new Label();
                          prodNome.setText(produto.getNome());
                          prodNome.setLayoutX(10);
                          prodNome.setLayoutY(10);
                          
                          Label prodDesc = new Label();
                          prodDesc.setText(entry.getKey());
                          prodDesc.setLayoutX(10);
                          prodDesc.setLayoutY(35);
                          
                          Label prodPreco = new Label();
                          prodPreco.setText(String.valueOf(entry.getValue()) + "€");
                          prodPreco.setLayoutX(145);
                          prodPreco.setLayoutY(35);
                          
                          ImageView deleteBtn = new ImageView("./assets/delete_icon.png");
                          deleteBtn.setLayoutX(190);
                          deleteBtn.setLayoutY(30);
                          deleteBtn.setCursor(Cursor.HAND);
                          
                          Pane pan = new Pane();
                          pan.setStyle("-fx-background-color: white; -fx-border-width: 0 0 1 0; -fx-border-color: #728da6; -fx-padding: 5;");
                          pan.getChildren().addAll(prodNome, prodDesc, prodPreco, deleteBtn);
                          pa = pan;
                          panes.add(pa);
                          
                          containerCarrinho.getChildren().add(pan);
                          scrollEncomenda.setHbarPolicy(ScrollBarPolicy.NEVER);
                          scrollEncomenda.setVbarPolicy(ScrollBarPolicy.ALWAYS);
                          scrollEncomenda.setContent(containerCarrinho);
                          
//                          deleteBtn.setOnMouseClicked((MouseEvent eventA) -> {
//                              boolean remove = false;
//                              for(Produto prod : encomenda.getProdutos()) {
//                                  for(Pane pane_ : panes) {
//                                      if(prod.getDescricao().equals(pane_.getChildren().get(lengthId)))
//                                  }
//                              }
////                              if(remove) {
////                                  containerCarrinho.getChildren().remove(pan);
////                              }
////                            encomenda.getProdutos().remove(produto);
//                              System.out.println("AAA");
//                              
//                          });
                          
                          valorTotal_txt.setText(String.valueOf(precoTotal) + "€");
                      });
                  }
                  
                  @Override
                  protected void updateItem(Produto p, boolean empty) {
                      super.updateItem(p, empty);
                      setGraphic(empty ? null : btn);
                  }
              };
              return cell;
          }
        });
    }
    
    void addCarrinho(Produto produto) {
        
    }
    
    @FXML
    void verProdutos(ActionEvent event) {
        atualizarTabelaProdutos();
    }
    
    @FXML
    void verPrecos(ActionEvent event) {
        atualizarTabelaPrecos();
    }
    
    @FXML
    void goToPayment(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        
        encomenda.setIdEncomenda(Singleton.instance.incrementIdEncomenda(encomenda));
        System.out.println("aa: " + encomenda.getIdEncomenda());
        System.out.println("bb: " + encomenda);
        for(Empresa emp : Singleton.instance.getEmpresas().values()) {
            if(encomenda.getEmpresa().equals(emp)) {
                ArrayList<Encomenda> encomendas = new ArrayList<>();
                encomendas.add(encomenda);
                emp.setEncomendas(encomendas);
                Singleton.instance.adicionarEmpresas(emp);
                Singleton.instance.adicionarEncomendas(encomenda);
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setTitle("Info: Encomenda registada");
                alert.setHeaderText("A sua encomenda foi registada com sucesso.");
                alert.show();
        
                containerCarrinho.getChildren().removeAll(panes);
                precoTotal = 0;
                valorTotal_txt.setText(null);
                encomenda.getProdutos().removeAll(produtosEncomenda);
                
            }
        }
    }
    
}
