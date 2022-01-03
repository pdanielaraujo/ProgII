/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zlovo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 *
 * @author Pedro
 */
public class Singleton implements Serializable {
    private static final long serialVersionUID = 2155357897024670195L;
    public static Singleton instance = new Singleton();
    
    private HashMap<Integer, Utilizador> utilizadores = new HashMap<>();
    private int newIdUtilizador = 1;
    
    private Singleton() {}
    
    protected Object readResolve()
    {
        return instance;
    }

    /**
     * @return the utilizadores
     */
    public HashMap<Integer, Utilizador> getUtilizadores() {
        return utilizadores;
    }

    /**
     * @param utilizadores the utilizadores to set
     */
    public void setUtilizadores(HashMap<Integer, Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
    }
    
    public int incrementIdUtilizador(Utilizador utilizador) {
        
        if(utilizador instanceof Admin) {
            newIdUtilizador++;
        } else if(utilizador instanceof Motard) {
            newIdUtilizador++;
        } else if(utilizador instanceof DonoEmpresa) {
            newIdUtilizador++;
        } else if(utilizador instanceof Cliente) {
            newIdUtilizador++;
        }
        return newIdUtilizador;
    }
    
    public static void guardarDados() {
        try{
            FileOutputStream fileOut = new FileOutputStream("dados.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(instance.utilizadores);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in" + " dados.txt \n");
        }catch(IOException ex){
            System.out.println("Erro: " + ex.getMessage());
        }
    }
    
    public static void lerDados() {
        try{
            FileInputStream fileIn = new FileInputStream("dados.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            instance.utilizadores = (HashMap<Integer, Utilizador>) in.readObject();
            in.close();
            fileIn.close();
            System.out.printf("Deserialized data is saved in" + " dados.txt \n");
        }catch(IOException ex){
            System.out.println("Erro: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro, classe não foi encontrada: " + ex.getMessage());
        }
    }
    
    /**
     * Função para guardar utilizadores
     */
    public void adicionarUtilizadores(Utilizador utilizador) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        Stage stage = zlovo.Zlovo.guiStage;
        boolean exists = false;
        
        if(instance.utilizadores.isEmpty()){
            instance.utilizadores.putIfAbsent(utilizador.getIdUtilizador(), utilizador);
            Singleton.guardarDados();
            
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setTitle("Info: Conta criada");
            alert.setHeaderText("A sua conta foi criada com sucesso.");
            alert.show();
        } else {
            for(Utilizador u : instance.utilizadores.values()) {
                if(utilizador.getUsername().equals(u.getUsername())) {
                    exists = true;
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Erro: Conta já existe");
                    alert.setHeaderText("Uma conta com este username já existe.");
                    alert.show();
                }
            }
            if(!exists) {
                instance.utilizadores.putIfAbsent(utilizador.getIdUtilizador(), utilizador);
                Singleton.guardarDados();
                System.out.println("REGISTO NAO EXISTE");
                System.out.println("ID USER: " + utilizador.getIdUtilizador());
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setTitle("Info: Conta criada");
                alert.setHeaderText("A sua conta foi criada com sucesso.");
                alert.show();
            }
        } 
    }
    
    public Utilizador login(String username, String password) {
        Utilizador utilizador = null;
        
        for(Utilizador u : instance.utilizadores.values()){
            if(u.getUsername().equals(username) && u.getPassword().equals(password)){
                utilizador = u;
                System.out.println(utilizador.getUsername());
                break;
            }
        }
        return utilizador;
    }
    
    public void registo(Utilizador utilizador) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        Stage stage = zlovo.Zlovo.guiStage;
        boolean exists = false;
        
        if(instance.utilizadores.isEmpty()){
            instance.utilizadores.putIfAbsent(utilizador.getIdUtilizador(), utilizador);
            Singleton.guardarDados();
            
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setTitle("Info: Conta criada");
            alert.setHeaderText("A sua conta foi criada com sucesso.");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK) {
                System.out.println("BOTAO OK");
                try {
                    Thread.sleep(1000);
                    try{
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/LoginScreen/Login.fxml"));
                        Parent root = loader.load();
        
                        stage.getScene().setRoot(root);
                        stage.show();
                    } catch (IOException ioe) {
                        ioe.getMessage();
                    }
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        } else {
            for(Utilizador u : instance.utilizadores.values()) {
                if(utilizador.getUsername().equals(u.getUsername())) {
                    exists = true;
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Erro: Conta já existe");
                    alert.setHeaderText("Uma conta com este username já existe.");
                    alert.show();
                }
            }
            if(!exists) {
                System.out.println("REGISTO NAO EXISTE");
                System.out.println("ID USER: " + utilizador.getIdUtilizador());
                instance.utilizadores.putIfAbsent(utilizador.getIdUtilizador(), utilizador);
                Singleton.guardarDados();
                
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setTitle("Info: Conta criada");
                alert.setHeaderText("A sua conta foi criada com sucesso.");
                Optional<ButtonType> result = alert.showAndWait();
                if(result.get() == ButtonType.OK) {
                    System.out.println("BOTAO OK");
                    try {
                        Thread.sleep(1000);
                        try{
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/LoginScreen/Login.fxml"));
                            Parent root = loader.load();
            
                            stage.getScene().setRoot(root);
                            stage.show();
                        } catch (IOException ioe) {
                            ioe.getMessage();
                        }
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        } 
    }
}
