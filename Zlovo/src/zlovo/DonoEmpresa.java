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
    
    public DonoEmpresa (){
        
    }
    
    public DonoEmpresa (String nome, String password, int numCC, int nif, int numTelef, String morada, String localidade) {
        super(nome, password, numCC, nif, numTelef, morada, localidade);
    }
}
