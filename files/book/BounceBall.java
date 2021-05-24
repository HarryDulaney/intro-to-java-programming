import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class BounceBall extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    BallPane pane = new BallPane();
            
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 250, 150);
    primaryStage.setTitle("BounceBall"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    
    // Pause and resume animation
    pane.setOnMousePressed(e -> pane.pause());
    pane.setOnMouseReleased(e -> pane.play());

    pane.setFocusTraversable(true);
    pane.setOnKeyPressed(e -> {
      switch (e.getCode()) {
        case S:
          pane.decreaseSpeed();
          break;
        case F:
          pane.increaseSpeed();
          break;
      }
    });
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
