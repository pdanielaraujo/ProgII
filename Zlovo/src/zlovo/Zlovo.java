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
import java.util.Properties;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static zlovo.Singleton.instance;

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
        
        Singleton.lerDados();
        Admin admin = new Admin();
        admin.setIdUtilizador(0);
        admin.setNome("pedro admin");
        admin.setUsername("admin1");
        admin.setPassword("admin1");
        admin.setNumCC(000000000);
        admin.setNif(000000000);
        admin.setNumTelef(000000000);
        admin.setMorada("rua admin yyy");
        admin.setLocalidade("cidade yyy admin");
        System.out.println("antes: " + Singleton.instance.getUtilizadores());
        Singleton.instance.getUtilizadores().putIfAbsent(admin.getIdUtilizador(), admin);
        System.out.println("depois: " + Singleton.instance.getUtilizadores());
        System.out.println("Utilizadores: " + Singleton.instance.getUtilizadores());
        
        guiStage = primaryStage;
        
        Parent root = FXMLLoader.load(getClass().getResource("/screens/LoginScreen/Login.fxml"));
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Zlovo App");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.setResizable(true);
        primaryStage.show();
        
        
//        System.out.println(primaryStage.getWidth());
//        System.out.println(primaryStage.getHeight());
//        System.out.println(primaryStage.getMaxWidth());
//        System.out.println(primaryStage.getMaxHeight());
    }
}
