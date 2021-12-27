/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zlovoui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Pedro
 */
public class ZlovoUI extends Application{
    
    public static Stage guiStage;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }

    // cor do container #728da6
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        guiStage = primaryStage;
        
        Parent root = FXMLLoader.load(getClass().getResource("/LoginScreen/Login.fxml"));
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Zlovo App");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.setResizable(true);
        primaryStage.show();
    }
    
}
