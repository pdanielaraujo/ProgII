/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zlovo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Pedro
 */
public class Zlovo extends Application{

    public static Stage guiStage;
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Singleton s = Singleton.instance;
//        s.lerDados();
        
        Admin admin = new Admin();
        admin.setIdUtilizador(0);
        admin.setNome("pedro");
        admin.setPassword("123");
        admin.setNumCC(123456789);
        admin.setNif(987654321);
        admin.setNumTelef(999888777);
        admin.setMorada("Rua do Santo, nº43, Alvelos");
        admin.setLocalidade("Barcelos");
//        admin.guardarDados();
        Cliente cliente = new Cliente();
        cliente.setIdUtilizador(1);
        cliente.setNome("marco");
        cliente.setPassword("marco123");
        cliente.setNumCC(222222222);
        cliente.setNif(345654123);
        cliente.setNumTelef(977888666);
        cliente.setMorada("Rua de Baixo, nº99, Faria");
        cliente.setLocalidade("Braga");
//        cliente.guardarDados();
        s.adicionarUtilizadores(admin);
        s.adicionarUtilizadores(cliente);
        s.guardarDados();
        
        guiStage = primaryStage;
        
        Parent root = FXMLLoader.load(getClass().getResource("/screens/LoginScreen/Login.fxml"));
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Zlovo App");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.setResizable(true);
        primaryStage.show();
        
        
        System.out.println(primaryStage.getWidth());
        System.out.println(primaryStage.getHeight());
        System.out.println(primaryStage.getMaxWidth());
        System.out.println(primaryStage.getMaxHeight());
    }
    
    public static void serializar(Admin admin) {
        // Serializar um objeto para ficheiro
        
    }
    
}
