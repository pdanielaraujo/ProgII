/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.MenuDonoEmpresa.AddEmpresa;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import zlovo.DonoEmpresa;
import zlovo.Empresa;
import zlovo.Singleton;

/**
 * FXML Controller class
 *
 * @author Pedro
 */
public class AddEmpresaController implements Initializable {
    
    Stage stage = zlovo.Zlovo.guiStage;
    
    @FXML
    private TextField nome_txt;

    @FXML
    private TextField morada_txt;

    @FXML
    private TextField localidade_txt;

    @FXML
    private TextField numTelef_txt;

    @FXML
    private Button criarEmpresa_btn;
    
    private DonoEmpresa donoemp = (DonoEmpresa) stage.getUserData();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void receberDadosDono(DonoEmpresa dono) {
        System.out.println("aaaaa: " + donoemp);
    }
    
    @FXML
    void criarEmpresa(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        boolean exists = false;
        Empresa empresa = new Empresa();
        empresa.setIdEmpresa(Singleton.instance.incrementIdEmpresa(empresa));
        empresa.setNome(nome_txt.getText());
        empresa.setMorada(morada_txt.getText());
        empresa.setLocalidade(localidade_txt.getText());
        empresa.setNumTelef(Integer.parseInt(numTelef_txt.getText()));
        empresa.setAtivo(true);
        empresa.setDono(donoemp);
        
        if(nome_txt.getText().trim().isEmpty() || morada_txt.getText().trim().isEmpty() || localidade_txt.getText().trim().isEmpty()
                || numTelef_txt.getText().trim().isEmpty()) {
            
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Erro: Campos vazios");
            alert.setHeaderText("Tem de preencher os campos todos.");
            alert.show();
        } else {
            if(Singleton.instance.getEmpresas().isEmpty()) {
                Singleton.instance.adicionarEmpresas(empresa);
                Singleton.instance.adicionarEmpresasLocalidade(empresa, empresa.getLocalidade());
                System.out.println("dono: " + donoemp);
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setTitle("Info: Empresa criada");
                alert.setHeaderText("A sua empresa foi criada com sucesso.");
                alert.show();
            } else {
                for(Empresa e : Singleton.instance.getEmpresas().values()) {
                    if(empresa.getNome().equals(e.getNome())) {
                        exists = true;
                        alert.setAlertType(Alert.AlertType.ERROR);
                        alert.setTitle("Erro: Empresa já existe");
                        alert.setHeaderText("Uma empresa com este nome já existe.");
                        alert.show();
                    }
                }
            
                if(!exists) {
                    Singleton.instance.adicionarEmpresas(empresa);
                    Singleton.instance.adicionarEmpresasLocalidade(empresa, empresa.getLocalidade());
                    System.out.println("ID Empresa: " + empresa.getIdEmpresa());
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setTitle("Info: Empresa criada");
                    alert.setHeaderText("A sua empresa foi criada com sucesso.");
                    alert.show();
                }
            }
        }
    }
    
}
