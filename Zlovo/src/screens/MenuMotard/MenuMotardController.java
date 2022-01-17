/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.MenuMotard;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import zlovo.Motard;

/**
 * FXML Controller class
 *
 * @author Pedro
 */
public class MenuMotardController implements Initializable {
    
    Stage stage = zlovo.Zlovo.guiStage;
    
    @FXML
    private AnchorPane rootPane;

    @FXML
    private ToggleButton goToConfirmarEntregaScreen;

    @FXML
    private Button terminarSessao_btn;

    @FXML
    private ToggleButton goHome_btn;
    
    @FXML
    private Label loggedUserName_label;
    
    private Motard motard = (Motard) stage.getUserData();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loggedUserName_label.setText(motard.getUsername());
        
        ToggleGroup buttonGroup = new ToggleGroup();
        goHome_btn.setToggleGroup(buttonGroup);
        goToConfirmarEntregaScreen.setToggleGroup(buttonGroup);
    }    
    
    @FXML
    void loadConfirmarEntregaPane(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/screens/MenuMotard/ConfirmarEntrega/ConfirmarEntrega.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void loadMainMotardPage(ActionEvent event) {

    }

    @FXML
    void terminarSessao(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/LoginScreen/Login.fxml"));
        Parent root = loader.load();
            
        stage.getScene().setRoot(root);
        stage.show();
    }
    
}
