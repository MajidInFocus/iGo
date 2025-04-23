import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static void main(String[] args) {
        // Check if running in headless environment
        if (GraphicsEnvironment.isHeadless()) {
            System.out.println("Running in headless environment. GUI not available.");
            System.out.println("Please run this application in an environment with display support.");
            return;
        }

        try {
            // Set look and feel to system default
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
            // loading page
            loading load = new loading();
            load.setVisible(true); // Make sure loading screen is visible

            // Set up a timer to switch to the home page after 4 seconds
            Timer timer = new Timer(4000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Close the loading frame
                    load.dispose();
                    // Load the home page
                    HomePage homePage = new HomePage();
                    homePage.setVisible(true);
                }
            });
            timer.setRepeats(false);
            timer.start();
        } catch (Exception e) {
            System.err.println("Error starting application: " + e.getMessage());
            e.printStackTrace();
            // Only show dialog if we're not in headless mode
            if (!GraphicsEnvironment.isHeadless()) {
                JOptionPane.showMessageDialog(null, "Error starting application: " + e.getMessage());
            }
        }
    }
}

