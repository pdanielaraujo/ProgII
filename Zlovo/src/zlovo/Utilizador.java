/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zlovo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Pedro
 */
public abstract class Utilizador implements Serializable{
    private int idUtilizador;
    private String nome;
    private String password;
    private int numCC;
    private int nif;
    private int numTelef;
    private String morada;
    private String localidade;
    
    public Utilizador () {
        
    }
    
    public Utilizador (String nome, String password, int numCC, int nif, int numTelef, String morada, String localidade) {
        this.nome = nome;
        this.password = password;
        this.numCC = numCC;
        this.nif = nif;
        this.numTelef = numTelef;
        this.morada = morada;
        this.localidade = localidade;
    }
    
    /**
     * @return the idUtilizador
     */
    public int getIdUtilizador() {
        return idUtilizador;
    }

    /**
     * @param idUtilizador the idUtilizador to set
     */
    public void setIdUtilizador(int idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    /**
     * @return the idUtilizador
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the numCC
     */
    public int getNumCC() {
        return numCC;
    }

    /**
     * @param numCC the numCC to set
     */
    public void setNumCC(int numCC) {
        this.numCC = numCC;
    }

    /**
     * @return the nif
     */
    public int getNif() {
        return nif;
    }

    /**
     * @param nif the nif to set
     */
    public void setNif(int nif) {
        this.nif = nif;
    }

    /**
     * @return the numTelef
     */
    public int getNumTelef() {
        return numTelef;
    }

    /**
     * @param numTelef the numTelef to set
     */
    public void setNumTelef(int numTelef) {
        this.numTelef = numTelef;
    }

    /**
     * @return the morada
     */
    public String getMorada() {
        return morada;
    }

    /**
     * @param morada the morada to set
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * @return the localidade
     */
    public String getLocalidade() {
        return localidade;
    }

    /**
     * @param localidade the localidade to set
     */
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
}
