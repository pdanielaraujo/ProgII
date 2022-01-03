/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.MenuAdmin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Pedro
 */
public class MenuAdminController implements Initializable {
    
    Stage stage = zlovo.Zlovo.guiStage;

    @FXML
    private Button goToAddAdminScreen;

    @FXML
    private Button goToGerirEmpresaScreen;

    @FXML
    private Button goToGerirProdutoScreen;
    
    @FXML
    private Button terminarSessao_btn;
    
    @FXML
    private AnchorPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    void loadAddAdminPane(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/screens/MenuAdmin/AddAdmin/AddAdmin.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void loadGerirEmpresaPane(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/screens/MenuAdmin/GerirEmpresa/GerirEmpresa.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void loadGerirProdutoPane(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/screens/MenuAdmin/GerirProduto/GerirProduto.fxml"));
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
