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
public class Motard extends Utilizador{
    
    private boolean emServico;
    
    public Motard (){
        
    }
    
    public Motard (String nome, String username, String password, int numCC, int nif, int numTelef, String morada, String localidade) {
        super(nome, username, password, numCC, nif, numTelef, morada, localidade);
    }

    public boolean isEmServico() {
        return emServico;
    }

    public void setEmServico(boolean emServico) {
        this.emServico = emServico;
    }
    
    @Override
    public String toString() {
        return this.getNome();
    }
    
}
