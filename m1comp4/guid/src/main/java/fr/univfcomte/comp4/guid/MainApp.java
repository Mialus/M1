package fr.univfcomte.comp4.guid;

import javafx.application.Application;
import static javafx.application.Application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import fr.univfcomte.comp4.analyseur.*;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
      MiniJaja parser;
      if (args.length == 0) {
      System.out.println("JavaCC Parser:  Reading from standard input . . .");
      parser = new MiniJaja(System.in);
    } else if (args.length == 1) {
      System.out.println("JavaCC Parser:  Reading from file " + args[0] + " . . .");
      try {
        parser = new MiniJaja(new java.io.FileInputStream(/*args[0]*/"../1.jj"));
      } catch (java.io.FileNotFoundException e) {
        System.out.println("JavaCC Parser:  File " + args[0] + " not found.");
        return;
      }
    } else {
      System.out.println("JavaCC Parser:  Usage is one of:");
      System.out.println("         java MiniJaja < inputfile");
      System.out.println("OR");
      System.out.println("         java MiniJaja inputfile");
      return;
    }
    try {
      SimpleNode n = parser.classe();
        n.dump("");
      System.out.println("JavaCC Parser:  Java program parsed successfully.");
    } catch (ParseException e) {
      System.out.println(e.getMessage());
      System.out.println("JavaCC Parser:  Encountered errors during parse.");
    }
    }

}
