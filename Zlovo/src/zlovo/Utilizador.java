package zlovo;

import java.io.Serializable;

/**
 *
 * @author Pedro
 */
public abstract class Utilizador implements Serializable{
    private int idUtilizador;
    private String nome;
    private String username;
    private String password;
    private int numCC;
    private int nif;
    private int numTelef;
    private String morada;
    private String localidade;
    
    public Utilizador () {
        
    }
    
    public Utilizador (String nome, String username, String password, int numCC, int nif, int numTelef, String morada, String localidade) {
        this.nome = nome;
        this.username = username;
        this.password = password;
        this.numCC = numCC;
        this.nif = nif;
        this.numTelef = numTelef;
        this.morada = morada;
        this.localidade = localidade;
    }

    public int getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(int idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumCC() {
        return numCC;
    }

    public void setNumCC(int numCC) {
        this.numCC = numCC;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public int getNumTelef() {
        return numTelef;
    }

    public void setNumTelef(int numTelef) {
        this.numTelef = numTelef;
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
}
