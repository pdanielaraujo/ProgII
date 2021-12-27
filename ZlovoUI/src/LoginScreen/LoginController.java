/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginScreen;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Pedro
 */
public class LoginController implements Initializable {
    
    @FXML
    private TextField nome_txt;

    @FXML
    private TextField pass_txt;

    @FXML
    private Button login_btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    void entrarConta(ActionEvent event) {
        System.out.println("Entrou");
        //Admin admin = new Admin();
        //admin.login();
    }
    
}
