/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zlovo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
        
        Admin admin = new Admin();
        admin.setNome("pedro");
        admin.setPassword("123");
        admin.setNumCC(123456789);
        admin.setNif(987654321);
        admin.setNumTelef(999888777);
        admin.setMorada("Rua do Santo, nº43, Alvelos");
        admin.setLocalidade("Barcelos");
        try{
            FileOutputStream fileOut = new FileOutputStream("admins.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(admin);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in" + "admins.txt");
        }catch(IOException ex){
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        guiStage = primaryStage;
        
        Parent root = FXMLLoader.load(getClass().getResource("/screens/LoginScreen/Login.fxml"));
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Zlovo App");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.setResizable(true);
        primaryStage.show();
    }
    
    public static void serializar(Admin admin) {
        // Serializar um objeto para ficheiro
        
    }
    
}
