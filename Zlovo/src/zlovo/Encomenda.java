package zlovo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class Encomenda implements Serializable{
    private static final long serialVersionUID = 7044540340619659266L;
    private int idEncomenda;
    private String descricao;
    private int qtd;
    private float precoTotal;
    
    /**
     * 0 = Por pagar
     * 1 = Paga
     * 2 = Em entrega
     * 3 = Entregue
     * 4 = Anulada ::::???????????????
     */
    private int estado;
    private ArrayList<Produto> produtos = new ArrayList<>();
    private Empresa empresa;
    private Motard motard;
    
    public Encomenda() {
        
    }
    
    public Encomenda(String descricao, int qtd, float precoTotal) {
        this.descricao = descricao;
        this.qtd = qtd;
        this.precoTotal = precoTotal;
    }

    public int getIdEncomenda() {
        return idEncomenda;
    }

    public void setIdEncomenda(int idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Motard getMotard() {
        return motard;
    }

    public void setMotard(Motard motard) {
        this.motard = motard;
    }
    
}
