import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ContextMenuDemo extends Application {   
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {   
    ContextMenu contextMenu = new ContextMenu();       
    MenuItem menuItemNew = new MenuItem("New",
      new ImageView("image/new.gif"));
    MenuItem menuItemOpen = new MenuItem("Open",
      new ImageView("image/open.gif"));
    MenuItem menuItemPrint = new MenuItem("Print",
      new ImageView("image/print.gif"));
    MenuItem menuItemExit = new MenuItem("Exit");
    contextMenu.getItems().addAll(menuItemNew, menuItemOpen,
      menuItemPrint, menuItemExit);
   
    Pane pane = new Pane();
    Scene scene = new Scene(pane, 300, 250);  
    primaryStage.setTitle("ContextMenuDemo"); // Set the window title
    primaryStage.setScene(scene); // Place the scene in the window
    primaryStage.show(); // Display the window
    
    pane.setOnMousePressed(
      e -> contextMenu.show(pane, e.getScreenX(), e.getScreenY()));
    
    menuItemNew.setOnAction(e -> System.out.println("New"));
    menuItemOpen.setOnAction(e -> System.out.println("Open"));
    menuItemPrint.setOnAction(e -> System.out.println("Print"));
    menuItemExit.setOnAction(e -> System.exit(0));
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   * line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
