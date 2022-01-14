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
public class Encomenda implements Serializable{
    private int idEncomenda;
    private String descricao;
    private int qtd;
    private float precoTotal;
    
    /**
     * 0 = Por Confirmar
     * 1 = Confirmada
     * 2 = Efetuada
     * 3 = Paga ::::???????????????
     */
    private int estado;
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private Empresa empresa;
    
    
    public Encomenda() {
        
    }
    
    public Encomenda(String descricao, int qtd, float precoTotal) {
        this.descricao = descricao;
        this.qtd = qtd;
        this.precoTotal = precoTotal;
    }

    /**
     * @return the idEncomenda
     */
    public int getIdEncomenda() {
        return idEncomenda;
    }

    /**
     * @param idEncomenda the idEncomenda to set
     */
    public void setIdEncomenda(int idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    /**
     * @return the qtd
     */
    public int getQtd() {
        return qtd;
    }

    /**
     * @param qtd the qtd to set
     */
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    /**
     * @return the precoTotal
     */
    public float getPrecoTotal() {
        return precoTotal;
    }

    /**
     * @param precoTotal the precoTotal to set
     */
    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }

    /**
     * @return the produtos
     */
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    /**
     * @param produtos the produtos to set
     */
    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
    
}
