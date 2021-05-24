import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.PaneBuilder;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;

public class BuilderClassDemo extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    Pane pane = PaneBuilder.create().build();
    
    TextBuilder textBuilder = TextBuilder.create().fill(Color.RED)
      .font(Font.font("Times", 20)).x(40);
    Text text1 = textBuilder.y(20).text("Java").build();
    Text text2 = textBuilder.y(40).text("C++").build();
    Text text3 = textBuilder.y(60).text("Python").build();

    pane.getChildren().addAll(text1, text2, text3);
    
    Scene scene = new Scene(pane, 300, 250);           
    primaryStage.setTitle("BuilderClassDemo"); // Set the window title
    primaryStage.setScene(scene); // Place the scene in the window
    primaryStage.show(); // Display the window
  }

  // Lauch the program from command-line
  public static void main(String[] args) {
    launch(args);
  }
}
