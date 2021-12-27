import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.awt.image.*;
import javax.swing.JButton;

/**
 * @author COLNOT Clémence
 * @version 2021.12.15
 */
public class UserInterface implements ActionListener {
    private GameEngine aEngine;
    private JFrame aMyFrame;
    private JTextField aEntryField;
    private JTextArea aLog;
    private JLabel aImage;
    private JButton aButton;

    /**
     * UserInterface Constructor
     *
     * @param GameEngine pGameEngine
     */
    public UserInterface(final GameEngine pGameEngine) {
        this.aEngine = pGameEngine;
        this.createGUI();
    }

    /**
     * Print out some text
     *
     * @param String pText
     */
    public void print(final String pText) {
        this.aLog.append(pText);
        this.aLog.setCaretPosition(this.aLog.getDocument().getLength());
    } // print(.)

    /**
     * Print out some text followed by a line break.
     *
     * @param String pText
     */
    public void println(final String pText) {
        this.print(pText + "\n");
    } // println(.)

    /**
     * Show an image file in the interface.
     *
     * @param String pImageName
     */
    public void showImage(final String pImageName) {
        String vImagePath = "" + pImageName; // to change the directory
        URL vImageURL = this.getClass().getClassLoader().getResource(vImagePath);
        if (vImageURL == null)
            System.out.println("Image not found : " + vImagePath);
        else {
            ImageIcon vIcon = new ImageIcon(vImageURL);
            this.aImage.setIcon(vIcon);
            this.aMyFrame.pack();
        }
    } // showImage(.)

    /**
     * Enable or disable input in the input field.
     *
     * @param boolean pOnOff
     */
    public void enable(final boolean pOnOff) {
        this.aEntryField.setEditable(pOnOff); // enable/disable
        if (!pOnOff) { // disable
            this.aEntryField.getCaret().setBlinkRate(0); // cursor won't blink
            this.aEntryField.removeActionListener(this); // won't react to entry
        }
    } // enable(.)

    /**
     * Set up graphical user interface.
     */
    private void createGUI() {
        this.aMyFrame = new JFrame("Surviving History"); // change the title
        this.aEntryField = new JTextField(34);

        this.aLog = new JTextArea();
        this.aLog.setEditable(false);
        JScrollPane vListScroller = new JScrollPane(this.aLog);
        vListScroller.setPreferredSize(new Dimension(200, 200));
        vListScroller.setMinimumSize(new Dimension(100, 100));

        JPanel vPanel = new JPanel();
        this.aImage = new JLabel();
        this.aButton = new JButton("OK");

        vPanel.setLayout(new BorderLayout()); // ==> only five places
        vPanel.add(this.aImage, BorderLayout.NORTH);
        vPanel.add(vListScroller, BorderLayout.CENTER);
        vPanel.add(this.aEntryField, BorderLayout.SOUTH);
        vPanel.add(this.aButton, BorderLayout.EAST);

        this.aMyFrame.getContentPane().add(vPanel, BorderLayout.CENTER);

        // add some event listeners to some components
        this.aEntryField.addActionListener(this);
        this.aButton.addActionListener(this);

        // to end program when window is closed
        this.aMyFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.aMyFrame.pack();
        this.aMyFrame.setVisible(true);
        this.aEntryField.requestFocus();
    } // createGUI()

    /**
     * Actionlistener interface for entry textfield.
     *
     * @param ActionEvent pE
     */
    public void actionPerformed(final ActionEvent pE) {
        // no need to check the type of action at the moment
        // because there is only one possible action (text input) :
        if (pE.getSource() == this.aButton)
            this.processCommand(); // never suppress this line
    } // actionPerformed(.)

    /**
     * A command has been entered. Read the command and do whatever is
     * necessary to process it.
     */
    private void processCommand() {
        String vInput = this.aEntryField.getText();
        this.aEntryField.setText("");
        this.aEngine.interpretCommand(vInput);
    } // processCommand()

}