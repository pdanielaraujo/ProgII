/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zlovo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Pedro
 */
public class Admin extends Utilizador{
    
    public Admin (){
        
    }
    
    public Admin (String nome, String password, int numCC, int nif, int numTelef, String morada, String localidade) {
        super(nome, password, numCC, nif, numTelef, morada, localidade);
    }
    
    
}
