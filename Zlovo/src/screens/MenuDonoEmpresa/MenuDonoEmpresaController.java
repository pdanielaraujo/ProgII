/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.MenuDonoEmpresa;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import zlovo.DonoEmpresa;

/**
 * FXML Controller class
 *
 * @author Pedro
 */
public class MenuDonoEmpresaController implements Initializable {
    
    Stage stage = zlovo.Zlovo.guiStage;
    
    @FXML
    private AnchorPane rootPane;
    
    @FXML
    private Label loggedUserName_label;
    
    @FXML
    private ToggleButton goHome_btn;

    @FXML
    private Button terminarSessao_btn;
    
    @FXML
    private ToggleButton criarEmpresa_btn;
    
    @FXML
    private ToggleButton gerirProduto_btn;
    
    @FXML
    private ToggleButton updateEmpresa_btn;
    
    @FXML
    public HomeDonoEmpresaController homeDonoEmpresaController;
    
    private DonoEmpresa donoemp = (DonoEmpresa) stage.getUserData();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loggedUserName_label.setText(donoemp.getUsername());
        
        ToggleGroup buttonGroup = new ToggleGroup();
        goHome_btn.setToggleGroup(buttonGroup);
        criarEmpresa_btn.setToggleGroup(buttonGroup);
        updateEmpresa_btn.setToggleGroup(buttonGroup);
        gerirProduto_btn.setToggleGroup(buttonGroup);
    }

    @FXML
    void loadMainDonoEmpresaPage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane pane = loader.load(getClass().getResource("/screens/MenuDonoEmpresa/HomeDonoEmpresa.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    
    @FXML
    void loadAddEmpresaPage(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/screens/MenuDonoEmpresa/AddEmpresa/AddEmpresa.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    
    @FXML
    void loadUpdateEmpresaPage(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/screens/MenuDonoEmpresa/UpdateEmpresa/UpdateEmpresa.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    
    @FXML
    void loadGerirProdutoPage(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/screens/MenuDonoEmpresa/ProdutosEmpresa/GerirProdutos.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void terminarSessao(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/LoginScreen/Login.fxml"));
        Parent root = loader.load();
            
        stage.getScene().setRoot(root);
        stage.show();
    }
    
}
