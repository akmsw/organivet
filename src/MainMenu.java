/**
 * Clase correspondiente a la ventana del
 * menú principal del programa.
 * 
 * @author Bonino, Francisco Ignacio.
 * 
 * @version 0.0.1
 * 
 * @since 09/03/2021
 */

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    private JButton newRecordButton, searchRecordButton, deleteRecordButton;

    private JLabel bgLabel;

    private JPanel leftPanel, rightPanel, masterPanel;

    /**
     * Constructor de la ventana principal.
     */
    public MainMenu() {
        initializeComponents();
    }

    /* ---------------------------------------- Métodos privados --------------------------------- */

    /**
     * Este método se encarga de inicializar los botones y la imagen de fondo de la
     * ventana principal.
     */
    private void initializeComponents() {
        bgImage = new ImageIcon(Main.IMG_PATH + "bg.png");
        icon = new ImageIcon(Main.IMG_PATH + "icon.png");
        smallIcon = new ImageIcon(icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

        newRecordButton = new JButton("Nuevo registro");
        searchRecordButton = new JButton("Buscar registro");
        deleteRecordButton = new JButton("Eliminar registro");

        bgLabel = new JLabel("", bgImage, JLabel.CENTER);

        leftPanel = new JPanel(new MigLayout("wrap"));
        rightPanel = new JPanel(new MigLayout("wrap"));
        masterPanel = new JPanel(new MigLayout("wrap 2"));

        newRecordButton.setEnabled(true);
        newRecordButton.addActionListener(this);

        searchRecordButton.setEnabled(true);
        searchRecordButton.addActionListener(this);

        deleteRecordButton.setEnabled(true);
        deleteRecordButton.addActionListener(this);

        leftPanel.add(newRecordButton, "span2, push, grow");
        leftPanel.add(searchRecordButton, "span2, push, grow");
        leftPanel.add(deleteRecordButton, "span2, push, grow");

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

    /* ---------------------------------------- Métodos públicos --------------------------------- */

    /**
     * Override para indicar qué hacer en base a cada boton pulsado.
     * 
     * @param e Evento de click.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newRecordButton) {
            // TODO
        } else if (e.getSource() == searchRecordButton) {
            // TODO
        }
        else {
            // TODO
        }
    }
}