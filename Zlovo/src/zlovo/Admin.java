package zlovo;

/**
 *
 * @author Pedro
 */
public class Admin extends Utilizador{
    
    public Admin (){
        
    }
    
    public Admin (String nome, String username, String password, int numCC, int nif, int numTelef, String morada, String localidade) {
        super(nome, username, password, numCC, nif, numTelef, morada, localidade);
    }
    
}
