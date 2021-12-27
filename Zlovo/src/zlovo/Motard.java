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
    
    public Motard (){
        
    }
    
    public Motard (String nome, String password, int numCC, int nif, int numTelef, String morada, String localidade) {
        super(nome, password, numCC, nif, numTelef, morada, localidade);
    }
    
}
