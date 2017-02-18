/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

/**
 *
 * @author Producao
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//import br.com.model.Usuario;
import config.ConfigurationFactory;
import org.ini4j.Profile.Section;

/**
 *
 * @author thiago
 */
public class Variaveis { 

   // private static Usuario usuario;
    private static Section section;
    public static String TITULO;
    public static String SIGLA;

    public static String getSIGLA() {
        if(SIGLA == null){
            section = ConfigurationFactory.getConfiguration();
            SIGLA = section.get("titulo");
        
        }
        return SIGLA;
    }

    public static String getTITULO() {
        if(TITULO == null){
            section = ConfigurationFactory.getConfiguration();
            TITULO = section.get("titulo");
        
        }
        return TITULO;
    }
    public static String getNomeExtensoSistema(){
        return "Teste Titulo";
    }
    
    public static String getSiglaSistema(){
        if(TITULO == null){
            section = ConfigurationFactory.getConfiguration();
            TITULO = section.get("titulo");
        
        }
        return TITULO;
    }
    
}

