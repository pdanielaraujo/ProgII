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

/**
 *
 * @author Pedro
 */
public class Singleton implements Serializable {
    public static Singleton instance = new Singleton();
    
    private HashMap<Integer, Utilizador> utilizadores = new HashMap<>();
    
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
    
    public static void guardarDados() {
        
        try{
            FileOutputStream fileOut = new FileOutputStream("dados.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(instance);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in" + " dados.txt");
        }catch(IOException ex){
            System.out.println("Erro: " + ex.getMessage());
        }
    }
    
    public static void lerDados() {
        try{
            FileInputStream fileIn = new FileInputStream("dados.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            instance = (Singleton) in.readObject();
            in.close();
            fileIn.close();
            System.out.printf("Serialized data is saved in" + " dados.txt");
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
        if(!utilizadores.containsKey(utilizador.getIdUtilizador())){
            utilizadores.put(utilizador.getIdUtilizador(), utilizador);
        } else {
            System.out.println("Já existe este utilizador!");
        }
    }
    
    public Utilizador login(String nome, String password) {
        Utilizador utilizador = null;
        
        for(Utilizador u : utilizadores.values()){
            if(u.getNome().equals(nome) && u.getPassword().equals(password)){
                utilizador = u;
                System.out.println(utilizador.getNome());
                break;
            }
        }
        return utilizador;
    }
}
