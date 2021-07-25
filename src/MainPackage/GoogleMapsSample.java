package MainPackage;



import java.awt.BorderLayout;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.swing.*;



public class GoogleMapsSample {


   public JFXPanel jfxPanel ;
   
   public void createAndShowWindow() {
        JFrame frame = new JFrame();
        JButton quit = new JButton("Quit");
     
        jfxPanel = new JFXPanel();
        Platform.runLater(this::createJFXContent);

        JPanel buttonPanel = new JPanel();
 

        frame.add(BorderLayout.CENTER, jfxPanel);
        frame.add(BorderLayout.SOUTH, buttonPanel);

       
        frame.setSize(800,  800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
    }

   
   
    private void createJFXContent() {
        WebView webView = new WebView();
        webView.getEngine().load("https://www.google.com/maps/@7.26511,80.6215903,15z");
        Scene scene = new Scene(webView);
        jfxPanel.setScene(scene);
    }

    public static void main(String[] args) {
        GoogleMapsSample swingApp = new GoogleMapsSample();
        SwingUtilities.invokeLater(swingApp::createAndShowWindow);
    }
   
   

    }
   
