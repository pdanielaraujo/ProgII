/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.MenuDonoEmpresa;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import zlovo.DonoEmpresa;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Pedro
 */
public class HomeDonoEmpresaController implements Initializable {
    
    Stage stage = zlovo.Zlovo.guiStage;
    
    @FXML
    private Label nomeDono_label;
    
    @FXML
    private Label usernameDono_label;

    @FXML
    private Label numCCDono_label;

    @FXML
    private Label nifDono_label;

    @FXML
    private Label numTelefDono_label;

    @FXML
    private Label moradaDono_label;

    @FXML
    private Label localidadeDono_label;
    
    private DonoEmpresa donoemp = (DonoEmpresa) stage.getUserData();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nomeDono_label.setText(donoemp.getNome());
        usernameDono_label.setText(donoemp.getUsername());
        numCCDono_label.setText(String.valueOf(donoemp.getNumCC()));
        nifDono_label.setText(String.valueOf(donoemp.getNif()));
        numTelefDono_label.setText(String.valueOf(donoemp.getNumTelef()));
        moradaDono_label.setText(donoemp.getMorada());
        localidadeDono_label.setText(donoemp.getLocalidade());
    }
    
    
}
