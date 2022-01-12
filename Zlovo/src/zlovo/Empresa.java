/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zlovo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class Empresa implements Serializable{
    private static final long serialVersionUID = -8602905907904291258L;
    private int idEmpresa;
    private String nome;
    private String morada;
    private String localidade;
    private int numTelef;
    private boolean ativo;
    private ArrayList<Produto> produtos = new ArrayList<>();
    private DonoEmpresa dono;
    
    public Empresa() {
        
    }
    
    public Empresa(String nome, String morada, String localidade, int numTelef, boolean ativo, DonoEmpresa dono) {
        this.nome = nome;
        this.morada = morada;
        this.localidade = localidade;
        this.numTelef = numTelef;
        this.ativo = ativo;
        this.dono = dono;
    }

    /**
     * @return the idEmpresa
     */
    public int getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * @param idEmpresa the idEmpresa to set
     */
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    /**
     * @return the nome
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
     * @return the ativo
     */
    public boolean isAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * @return the dono
     */
    public DonoEmpresa getDono() {
        return dono;
    }

    /**
     * @param dono the dono to set
     */
    public void setDono(DonoEmpresa dono) {
        this.dono = dono;
    }
    
    
    
}
