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
    private int entidade;
    private boolean ativo;
    private ArrayList<Produto> produtos = new ArrayList<>();
    private ArrayList<Encomenda> encomendas = new ArrayList<>();
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

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public int getNumTelef() {
        return numTelef;
    }

    public void setNumTelef(int numTelef) {
        this.numTelef = numTelef;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public DonoEmpresa getDono() {
        return dono;
    }

    public void setDono(DonoEmpresa dono) {
        this.dono = dono;
    }
    
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
    
    public ArrayList<Encomenda> getEncomendas() {
        return encomendas;
    }

    public void setEncomendas(ArrayList<Encomenda> encomendas) {
        this.encomendas = encomendas;
    }
    
    public int getEntidade() {
        return entidade;
    }

    public void setEntidade(int entidade) {
        this.entidade = entidade;
    }
    
    @Override
    public String toString() {
        return this.getNome();
    }
    
}
