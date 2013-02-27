package lib.helpers;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class SwingHelper {

    public static void errorMessage(Component component, String error) {
        JOptionPane.showMessageDialog(component, "<html><body>"
                + error + "</body></html>", "Error!", JOptionPane.ERROR_MESSAGE);
    }
}
