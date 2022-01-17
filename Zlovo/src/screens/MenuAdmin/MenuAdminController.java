/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.MenuAdmin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import zlovo.Utilizador;

/**
 * FXML Controller class
 *
 * @author Pedro
 */
public class MenuAdminController implements Initializable {
    
    Stage stage = zlovo.Zlovo.guiStage;

    @FXML
    private ToggleButton goToAddAdminScreen;

    @FXML
    private ToggleButton goToGerirEmpresaScreen;
    
    @FXML
    private ToggleButton goToGerirEncomendasScreen;
    
    @FXML
    private ToggleButton goHome_btn;
    
    @FXML
    private Button terminarSessao_btn;
    
    @FXML
    private AnchorPane rootPane;
    
    @FXML
    private Label loggedUserName_label;
    
    private Utilizador utilizador = (Utilizador) stage.getUserData();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loggedUserName_label.setText(utilizador.getUsername());
        
        ToggleGroup buttonGroup = new ToggleGroup();
        goHome_btn.setToggleGroup(buttonGroup);
        goToAddAdminScreen.setToggleGroup(buttonGroup);
        goToGerirEmpresaScreen.setToggleGroup(buttonGroup);
        goToGerirEncomendasScreen.setToggleGroup(buttonGroup);
    }    
    
    @FXML
    void loadAddAdminPane(ActionEvent event) throws IOException {
//        goToAddAdminScreen.setBack;
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/screens/MenuAdmin/AddAdmin/AddAdmin.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void loadGerirEmpresaPane(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/screens/MenuAdmin/GerirEmpresa/GerirEmpresa.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    
    @FXML
    void loadGerirEncomendaPane(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/screens/MenuAdmin/GerirEncomendaPaga/GerirEncomendaPaga.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    
    @FXML
    void loadMainAdminPage(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/screens/MenuAdmin/HomeAdmin.fxml"));
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
