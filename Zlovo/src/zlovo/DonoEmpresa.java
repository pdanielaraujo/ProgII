package zlovo;

import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class DonoEmpresa extends Utilizador{
    private static final long serialVersionUID = 1474749656502870802L;
    private boolean ativo;
    private ArrayList<Empresa> empresas = new ArrayList<>();
    
    public DonoEmpresa (){
        
    }
    
    public DonoEmpresa (String nome, String username, String password, int numCC, int nif, int numTelef, String morada, String localidade, boolean ativo) {
        super(nome, username, password, numCC, nif, numTelef, morada, localidade);
        this.ativo = ativo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    public ArrayList<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(ArrayList<Empresa> empresas) {
        this.empresas = empresas;
    }
    
    @Override
    public String toString() {
        return this.getUsername();
    }
    
}
