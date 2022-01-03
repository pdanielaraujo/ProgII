/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zlovo;

/**
 *
 * @author Pedro
 */
public class DonoEmpresa extends Utilizador{
    private boolean ativo;
    
    public DonoEmpresa (){
        
    }
    
    public DonoEmpresa (String nome, String username, String password, int numCC, int nif, int numTelef, String morada, String localidade, boolean ativo) {
        super(nome, username, password, numCC, nif, numTelef, morada, localidade);
        this.ativo = ativo;
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
    
    
}
