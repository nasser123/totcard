/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.awt.AWTKeyStroke;
import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashSet;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Define configurações padrão das telas
 *
 * @author nasser
 */
public class ConfigTelas {

    private JFrame janela;
    private Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
    private int larg;
    private int alt;
    private JPanel panel;

    /**
     * @param janela informa a janela que está sendo configurada
     * @param larg informa a largura da tela em pixels (padrão: 1024)
     * @param alt informa a altura da tela em pixels (padrão: 680)
     */
    public ConfigTelas(JFrame janela, int larg, int alt) {
        this.janela = janela;
        this.larg = larg;
        this.alt = alt;

    }

    public ConfigTelas(JPanel jp, int larg, int alt) {
        this.larg = larg;
        this.alt = alt;
        this.panel = jp;

    }

    public ConfigTelas(JFrame jf) {
        this.larg = jf.getWidth();
        this.alt = jf.getHeight();

    }

    /**
     * NÃO IMPLEMENTADO
     * @param jp 
     */
    public void carregaIcone(JFrame jp) {
//        BufferedImage ico = null;
//        try {
//            System.out.println(jp.getClass().getCanonicalName().toString());
//            ico = ImageIO.read(jp.getClass().getResource("../imagens/loja.png"));
//            jp.setIconImage(ico);
//        } catch (IllegalArgumentException iae) {
//            System.out.println("Erro ao carregar icone-argumento!");
//        } catch (java.lang.NullPointerException npe) {
//            System.out.println("Erro ao carregar icone-nullpointer!");
//        } catch (IOException e) {
//            System.out.println("Erro ao carregar icone-geral!");
//        }

    }

    public void carregarConfig(JFrame jp) {
        
        //faz com que a tecla ENTER funcione conforme a tecla TAB
        HashSet conj = new HashSet(jp.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        jp.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);
        jp.pack();
        jp.setResizable(false);
       


        jp.setTitle(Variaveis.getTITULO());

        //jp.setResizable(false);


        //Altera o icone padrão do java
        BufferedImage ico = null;
        try {
            ico = ImageIO.read(jp.getClass().getResource("../icones32/logo_32x32.png"));
            jp.setIconImage(ico);
        } catch (IllegalArgumentException iae) {
            System.out.println("Erro ao carregar icone!");
        } catch (IOException e) {
            System.out.println("Erro ao carregar icone!");
        }

    }

    
}
