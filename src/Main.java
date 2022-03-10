/**
 * Clase principal, sólo para inicialización del programa
 * y declaración de campos útiles.
 * 
 * @author Bonino, Francisco Ignacio.
 * @version 0.0.1
 * @since 09/03/2022
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import java.io.File;

import java.util.Enumeration;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class Main {

    /* ---------------------------------------- Constantes privadas ------------------------------ */

    private static final String TTF_PATH = "src/resources/fonts/";
    private static final String FONT_NAME = "Comfortaa";

    /* ---------------------------------------- Constantes públicas ------------------------------ */

    public static final float FONT_SIZE = 18f; // Tamaño de fuente para el programa

    public static final String PROGRAM_TITLE = "OrganiVet";
    public static final String PROGRAM_VERSION = "v0.1";
    public static final String IMG_PATH = "src/resources/images/";

    public static final Color FRAMES_BG_COLOR = new Color(176, 189, 162);
    public static final Color BUTTONS_BG_COLOR = new Color(41, 71, 74);

    /* ---------------------------------------- Campos públicos ---------------------------------- */

    public static Font PROGRAM_FONT;

    /**
     * Método principal.
     * 
     * Aquí se instancia y ejecuta todo el programa.
     * 
     * @param args Argumentos para ejecutar el programa.
     * 
     * @version 0.0.1
     */
    public static void main(String[] args) {
        setGUIProperties();

        MainMenu mainMenu = new MainMenu();

        mainMenu.setVisible(true);
    }

    /* ---------------------------------------- Métodos privados --------------------------------- */

    /**
     * Este método se encarga de setear las propiedades
     * de la interfaz gráfica del programa.
     * 
     * @version 0.0.1
     */
    private static void setGUIProperties() {
        UIManager.put("OptionPane.background", FRAMES_BG_COLOR);
        UIManager.put("Panel.background", FRAMES_BG_COLOR);
        UIManager.put("Button.background", BUTTONS_BG_COLOR);
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Button.focus", BUTTONS_BG_COLOR);
        UIManager.put("ToggleButton.focus", BUTTONS_BG_COLOR);
        UIManager.put("CheckBox.focus", FRAMES_BG_COLOR);
        UIManager.put("CheckBox.background", FRAMES_BG_COLOR);
        UIManager.put("ComboBox.focus", Color.WHITE);
        UIManager.put("Separator.background", FRAMES_BG_COLOR);

        try {
            // Se registra la fuente para poder setearla
            PROGRAM_FONT = Font.createFont(Font.TRUETYPE_FONT,
                                           new File(TTF_PATH + FONT_NAME + ".ttf"))
                                               .deriveFont(FONT_SIZE);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

            ge.registerFont(PROGRAM_FONT);
        } catch (Exception ex) {
            ex.printStackTrace();

            System.exit(-1);
        }

        setUIFont(PROGRAM_FONT);
    }

    /**
     * Este método se encarga de setear la fuente utilizada para el programa.
     * 
     * @param f Fuente a utilizar.
     * 
     * @version 0.0.1
     */
    private static void setUIFont(Font f) {
        Enumeration<Object> keys = UIManager.getDefaults().keys();

        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);

            if (value instanceof FontUIResource)
                UIManager.put(key, f);
        }
    }
}