/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zlovo;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Pedro
 */
public class Produto implements Serializable{
    private static final long serialVersionUID = 7086318999034384055L;
    private int idProduto;
    private String nome;
    private String categoria;
    private String descricao;
    private Empresa empresa;
    private HashMap<String, Float> preco = new HashMap<>();
    
    public Produto() {
        
    }
    
    public Produto(String nome, String categoria, String descricao, HashMap<String, Float> preco) {
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public HashMap<String, Float> getPreco() {
        return preco;
    }
    
    public void setPreco(HashMap<String, Float> preco) {
        this.preco = preco;
    }
    
    public Empresa getEmpresa() {
        return empresa;
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
}
