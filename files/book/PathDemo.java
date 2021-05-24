import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class PathDemo extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    Pane pane = new Pane();
    
    // Create a Path
    Path path = new Path();
    path.getElements().add(new MoveTo(50.0, 50.0)); 
    path.getElements().add(new HLineTo(150.5)); 
    path.getElements().add(new VLineTo(100.5));
    path.getElements().add(new LineTo(200.5, 150.5));
    
    ArcTo arcTo = ArcToBuilder.create().x(250).y(100.5).radiusX(45)
      .radiusY(45).sweepFlag(true).build();
    path.getElements().add(arcTo);

    path.getElements().add(new QuadCurveTo(50, 50, 350, 100));
    path.getElements().add(
      new CubicCurveTo(250, 100, 350, 250, 450, 10));
    
    path.getElements().add(new ClosePath());
    
    pane.getChildren().add(path);
    path.setFill(Color.BLACK);
    Scene scene = new Scene(pane, 300, 250);           
    primaryStage.setTitle("PathDemo"); // Set the window title
    primaryStage.setScene(scene); // Place the scene in the window
    primaryStage.show(); // Display the window
  }

  // Lauch the program from command-line
  public static void main(String[] args) {
    launch(args);
  }
}


