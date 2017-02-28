import javax.swing.*;

/**
 * Created by cesar on 2/02/17.
 */
public class Main {
    public static void main(String [] args){
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.err.println("Error: Failed to load Look and Feel");
            e.printStackTrace();
        }

        Window myWindow = new Window();
        myWindow.setVisible(true);
    }
}
