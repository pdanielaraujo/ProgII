package zlovo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static zlovo.Singleton.instance;

/**
 *
 * @author Pedro
 */
public class Zlovo extends Application{

    public static Stage guiStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Singleton.lerDados();
        Admin admin = new Admin();
        admin.setIdUtilizador(0);
        admin.setNome("pedro admin");
        admin.setUsername("admin1");
        admin.setPassword("admin1");
        admin.setNumCC(000000000);
        admin.setNif(000000000);
        admin.setNumTelef(000000000);
        admin.setMorada("rua admin yyy");
        admin.setLocalidade("cidade yyy admin");
        System.out.println("antes: " + Singleton.instance.getUtilizadores());
        Singleton.instance.getUtilizadores().put(admin.getIdUtilizador(), admin);
        System.out.println("depois: " + Singleton.instance.getUtilizadores());
        System.out.println("Utilizadores: " + Singleton.instance.getUtilizadores());
        
        
//        Empresa empresa = new Empresa();
//        empresa.setIdEmpresa(0);
//        empresa.setNome("Zlovo");
//        empresa.setMorada("Rua da avenida, nº50, Alvelos");
//        empresa.setLocalidade("Barcelos");
//        empresa.setNumTelef(911347554);
//        empresa.setAtivo(true);
//        for(Empresa emp : Singleton.instance.getEmpresasLocalidade().values()) {
//            
//        }
        System.out.println("antes: " + Singleton.instance.getEmpresasLocalidade());
        System.out.println("empresaaaas: " + Singleton.instance.getEmpresas());
        for(Empresa emp : Singleton.instance.getEmpresas().values()) {
            System.out.println("nome emo: " + emp.getNome()+ " : " + emp.getProdutos());
        }
        
        for(Encomenda enc : Singleton.instance.getEncomendas().values()) {
            System.out.println("emp1: " + enc);
            for(Produto prod : enc.getProdutos()) {
                System.out.println("prod/emp: " + prod);
            }
        }
        System.out.println("produtoooos: " + Singleton.instance.getProdutos());
        System.out.println("encomendasss: " + Singleton.instance.getEncomendas());
//        Singleton.instance.adicionarEmpresas(empresa);
//        Singleton.instance.adicionarEmpresasLocalidade(empresa, empresa.getLocalidade());
//        System.out.println("depois: " + Singleton.instance.getEmpresasLocalidade().get(empresa.getLocalidade()));
//        System.out.println("Utilizadores: " + Singleton.instance.getEmpresasLocalidade());
        
        guiStage = primaryStage;
        
        Parent root = FXMLLoader.load(getClass().getResource("/screens/LoginScreen/Login.fxml"));
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Zlovo App");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.setResizable(true);
        primaryStage.show();
    }
}
