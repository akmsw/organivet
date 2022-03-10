/**
 * Clase correspondiente a la ventana del
 * menú principal del programa.
 * 
 * @author Bonino, Francisco Ignacio.
 * @version 0.0.1
 * @since 09/03/2021
 */

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class MainMenu extends JFrame implements ActionListener {

    /* ---------------------------------------- Campos públicos ---------------------------------- */

    public static ImageIcon icon, smallIcon;

    /* ---------------------------------------- Campos privados ---------------------------------- */

    private ImageIcon bgImage;

    private JButton newRecordButton, searchRecordButton, updateButton, deleteRecordButton;

    private JLabel bgLabel;

    private JPanel leftPanel, rightPanel, masterPanel;

    /**
     * Constructor de la ventana principal.
     * 
     * @version 0.0.1
     */
    public MainMenu() {
        buildFrame();
    }

    /* ---------------------------------------- Métodos privados --------------------------------- */

    /**
     * Inicialización de componentes del menú principal.
     * 
     * @version 0.0.2
     * @since 09/03/2022
     */
    private void buildFrame() {
        bgImage = new ImageIcon(Main.IMG_PATH + "bg.png");
        icon = new ImageIcon(Main.IMG_PATH + "icon.png");
        smallIcon = new ImageIcon(icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

        newRecordButton = new JButton("Nuevo registro");
        searchRecordButton = new JButton("Buscar registro");
        updateButton = new JButton("Actualizar registro");
        deleteRecordButton = new JButton("Eliminar registro");

        bgLabel = new JLabel("", bgImage, JLabel.CENTER);

        leftPanel = new JPanel(new MigLayout("wrap"));
        rightPanel = new JPanel(new MigLayout("wrap"));
        masterPanel = new JPanel(new MigLayout("wrap 2"));

        setupButtonAndPlaceInPanel(newRecordButton, leftPanel);
        setupButtonAndPlaceInPanel(searchRecordButton, leftPanel);
        setupButtonAndPlaceInPanel(updateButton, leftPanel);
        setupButtonAndPlaceInPanel(deleteRecordButton, leftPanel);

        leftPanel.setBackground(Main.FRAMES_BG_COLOR);

        rightPanel.add(bgLabel, "grow");

        rightPanel.setBackground(Main.FRAMES_BG_COLOR);

        masterPanel.add(leftPanel, "west");
        masterPanel.add(rightPanel, "east");

        add(masterPanel);

        setResizable(false);
        setTitle(Main.PROGRAM_TITLE + " " + Main.PROGRAM_VERSION);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(icon.getImage());

        pack();

        setLocationRelativeTo(null);
    }

    /**
     * Configuración y posicionamiento de un botón en el
     * panel del menú principal.
     * 
     * @param button Botón a configurar y colocar.
     * @param panel  Panel en el que se colocará el botón.
     * 
     * @version 0.0.1
     */
    private void setupButtonAndPlaceInPanel(JButton button, JPanel panel) {
        button.setEnabled(true);
        button.addActionListener(this);
        button.setBorder(BorderFactory.createBevelBorder(0));

        panel.add(button, "span2, push, grow");
    }

    /* ---------------------------------------- Métodos públicos --------------------------------- */

    /**
     * Override para indicar qué hacer en base a cada boton pulsado.
     * 
     * @param e Evento de click.
     * 
     * @version 0.0.1
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newRecordButton) {
            System.out.println("NEW RECORD");
        } else if (e.getSource() == searchRecordButton) {
            System.out.println("SEARCH RECORD");
        } else if (e.getSource() == updateButton) {
            System.out.println("UPDATE RECORD");
        } else {
            System.out.println("DELETE RECORD");
        }
    }
}