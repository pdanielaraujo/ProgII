package zlovo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.Random;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 *
 * @author Pedro
 */
public class Singleton implements Serializable {

    private static final long serialVersionUID = 2155357897024670195L;
    public static Singleton instance = new Singleton();

    private Utilizador utilizador;

    private HashMap<Integer, Utilizador> utilizadores = new HashMap<>();
    private HashMap<String, ArrayList<Empresa>> empresasLocalidade = new HashMap<>();
    private HashMap<String, ArrayList<Empresa>> empresasCategoria = new HashMap<>();
    private HashMap<Integer, Empresa> empresas = new HashMap<>();
    private HashMap<Integer, Produto> produtos = new HashMap<>();
    private HashMap<Integer, Encomenda> encomendas = new HashMap<>();
    private static int newIdUtilizador = 1;
    private static int newIdEmpresa = 1;
    private static int newIdProduto = 1;
    private static int newIdEncomenda = 1;
    private static int newEntidadeEmoresa = 0;

    private Singleton() {
    }

    protected Object readResolve() {
        return instance;
    }

    public HashMap<Integer, Utilizador> getUtilizadores() {
        return utilizadores;
    }

    public void setUtilizadores(HashMap<Integer, Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
    }

    public HashMap<String, ArrayList<Empresa>> getEmpresasLocalidade() {
        return empresasLocalidade;
    }

    public void setEmpresasLocalidade(HashMap<String, ArrayList<Empresa>> empresasLocalidade) {
        this.empresasLocalidade = empresasLocalidade;
    }

    public HashMap<Integer, Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(HashMap<Integer, Empresa> empresas) {
        this.empresas = empresas;
    }

    public HashMap<Integer, Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(HashMap<Integer, Produto> produtos) {
        this.produtos = produtos;
    }

    public HashMap<Integer, Encomenda> getEncomendas() {
        return encomendas;
    }

    public void setEncomendas(HashMap<Integer, Encomenda> encomendas) {
        this.encomendas = encomendas;
    }

    public int incrementIdUtilizador(Utilizador utilizador) {

        if (utilizador instanceof Admin) {
            newIdUtilizador++;
        } else if (utilizador instanceof Motard) {
            newIdUtilizador++;
        } else if (utilizador instanceof DonoEmpresa) {
            newIdUtilizador++;
        } else if (utilizador instanceof Cliente) {
            newIdUtilizador++;
        }
        return newIdUtilizador;
    }

    public int incrementIdEmpresa(Empresa empresa) {
        newIdEmpresa++;
        return newIdEmpresa;
    }
    
    public int incrementIdProduto(Produto produto) {
        newIdProduto++;
        return newIdProduto;
    }
    
    public int incrementIdEncomenda(Encomenda encomenda) {
        newIdEncomenda++;
        return newIdEncomenda;
    }
    
    public int newEntidadeEmpresa(Empresa empresa) {
        Random rand = new Random();
        newEntidadeEmoresa = 10000 + rand.nextInt(90000);
        return newEntidadeEmoresa;
    }

    public static void guardarDados() {
        try {
            FileOutputStream fileOut = new FileOutputStream("dados.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(instance.utilizadores);
            out.writeObject(instance.empresasLocalidade);
            out.writeObject(instance.empresas);
            out.writeObject(instance.produtos);
            out.writeObject(instance.encomendas);
            out.writeInt(newIdUtilizador);
            out.writeInt(newIdEmpresa);
            out.writeInt(newIdProduto);
            out.writeInt(newIdEncomenda);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in" + " dados.txt \n");
        } catch (IOException ex) {
            System.out.println("Erro: aaa" + ex.getMessage());
        }
    }

    public static void lerDados() {
        try {
            FileInputStream fileIn = new FileInputStream("dados.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            instance.utilizadores = (HashMap<Integer, Utilizador>) in.readObject();
            instance.empresasLocalidade = (HashMap<String, ArrayList<Empresa>>) in.readObject();
            instance.empresas = (HashMap<Integer, Empresa>) in.readObject();
            instance.produtos = (HashMap<Integer, Produto>) in.readObject();
            instance.encomendas = (HashMap<Integer, Encomenda>) in.readObject();
            Singleton.newIdUtilizador = in.readInt();
            Singleton.newIdEmpresa = in.readInt();
            Singleton.newIdProduto = in.readInt();
            Singleton.newIdEncomenda = in.readInt();
            in.close();
            fileIn.close();
            System.out.printf("Deserialized data is saved in" + " dados.txt \n");
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro, classe não foi encontrada: " + ex.getMessage());
        }
    }
    
    /**
     * Função para guardar empresas para um dono
     */
    public void adicionarEmpresas(Empresa empresa) {
        
        instance.empresas.putIfAbsent(empresa.getIdEmpresa(), empresa);
        Singleton.guardarDados();
    }
    
    /**
     * Função para guardar produtos
     */
    public void adicionarProdutos(Produto produto) {
        
        instance.produtos.putIfAbsent(produto.getIdProduto(), produto);
        Singleton.guardarDados();
    }
    
    /**
     * Função para guardar produtos
     */
    public void adicionarEncomendas(Encomenda encomenda) {
        
        instance.encomendas.putIfAbsent(encomenda.getIdEncomenda(), encomenda);
        Singleton.guardarDados();
    }

    /**
     * Função para guardar empresas por localidade para um dono
     */
    public void adicionarEmpresasLocalidade(Empresa empresa, String localidade) {
        ArrayList<Empresa> localEmpresa = new ArrayList<>();
        
        for(Empresa e : instance.empresas.values()) {
            if(e.getLocalidade().equals(empresa.getLocalidade())) {
                localEmpresa.add(e); 
                instance.empresasLocalidade.put(empresa.getLocalidade(), localEmpresa);
                Singleton.guardarDados();
            }
        }
    }

    /**
     * Função para guardar utilizadores
     */
    public void adicionarUtilizadores(Utilizador utilizador) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        Stage stage = zlovo.Zlovo.guiStage;
        
        // variável de controle de utilizadores existentes
        boolean exists = false;

        // se o hashmap estiver vazio, insere o utilizador
        if (instance.utilizadores.isEmpty()) {
            instance.utilizadores.putIfAbsent(utilizador.getIdUtilizador(), utilizador);
            Singleton.guardarDados();

            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setTitle("Info: Conta criada");
            alert.setHeaderText("A sua conta foi criada com sucesso.");
            alert.show();
        } else {
            /* se não estiver vazio, percorre os valores do hashmap, verifica se existe
            um utilizador como o username inserido, e se existir lança um alerta no ecrã
            e a variável de controle*/
            for (Utilizador u : instance.utilizadores.values()) {
                if (utilizador.getUsername().equals(u.getUsername())) {
                    exists = true;
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Erro: Conta já existe");
                    alert.setHeaderText("Uma conta com este username já existe.");
                    alert.show();
                }
            }
            if (!exists) {
                instance.utilizadores.putIfAbsent(utilizador.getIdUtilizador(), utilizador);
                Singleton.guardarDados();
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setTitle("Info: Conta criada");
                alert.setHeaderText("A sua conta foi criada com sucesso.");
                alert.show();
            }
        }
    }

    public Utilizador login(String username, String password) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        Utilizador utilizador = null;

        for (Utilizador u : instance.utilizadores.values()) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                utilizador = u;
            } 
        }
        return utilizador;
    }

    public void registo(Utilizador utilizador) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        Stage stage = zlovo.Zlovo.guiStage;
        boolean exists = false;

        if (instance.utilizadores.isEmpty()) {
            instance.utilizadores.putIfAbsent(utilizador.getIdUtilizador(), utilizador);
            Singleton.guardarDados();

            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setTitle("Info: Conta criada");
            alert.setHeaderText("A sua conta foi criada com sucesso.");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                System.out.println("BOTAO OK");
                try {
                    Thread.sleep(1000);
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/LoginScreen/Login.fxml"));
                        Parent root = loader.load();

                        stage.getScene().setRoot(root);
                        stage.show();
                    } catch (IOException ioe) {
                        ioe.getMessage();
                    }
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        } else {
            for (Utilizador u : instance.utilizadores.values()) {
                if (utilizador.getUsername().equals(u.getUsername())) {
                    exists = true;
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Erro: Conta já existe");
                    alert.setHeaderText("Uma conta com este username já existe.");
                    alert.show();
                }
            }
            if (!exists) {
                instance.utilizadores.putIfAbsent(utilizador.getIdUtilizador(), utilizador);
                Singleton.guardarDados();

                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setTitle("Info: Conta criada");
                alert.setHeaderText("A sua conta foi criada com sucesso.");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    System.out.println("BOTAO OK");
                    try {
                        Thread.sleep(1000);
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/LoginScreen/Login.fxml"));
                            Parent root = loader.load();

                            stage.getScene().setRoot(root);
                            stage.show();
                        } catch (IOException ioe) {
                            ioe.getMessage();
                        }
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

}
