import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

// Define constants
enum FigureType {LINE, RECTANGLE, ROUND_RECTANGLE, ELLIPSE};

public class FigurePane extends Pane { 
  private ObjectProperty<FigureType> type 
    = new SimpleObjectProperty<FigureType>(FigureType.LINE);
  private BooleanProperty filled = new SimpleBooleanProperty(false);

  // Shapes used in FigurePane
  private Line line1 = new Line(10, 10, 10, 10);
  private Line line2 = new Line(10, 10, 10, 10);
  private Rectangle rect1 = new Rectangle(10, 10, 100, 100);
  private Rectangle rect2 = new Rectangle(10, 10, 100, 100);
  private Ellipse ellipse = new Ellipse(10, 10, 100, 100);
  
  /** Construct a default FigurePane */
  public FigurePane() {
    this(FigureType.LINE, false);
  }

  /** Construct a FigurePane with the specified type */
  public FigurePane(FigureType type) {
    this(type, false);
  }

  /** Construct a FigurePane with the specified type and filled */
  public FigurePane(FigureType type, boolean filled) {
    this.type.set(type);
    setFilled(filled);
    rect2.setArcWidth(50);
    rect2.setArcHeight(50);
    display();
  }

  private void display() {
    getChildren().removeAll();
    switch (type.get()) {
      case LINE: // Display two cross lines
        getChildren().add(new Line(0, 0, 100, 100));
        break;
      case RECTANGLE: // Display a rectangle
        rect1.widthProperty().bind(widthProperty().subtract(10));
        rect1.heightProperty().bind(heightProperty().subtract(10));        
        getChildren().add(rect1);
        
        if (filled.get()) {
          rect1.setFill(Color.RED);
        }
        else {
          rect1.setFill(Color.WHITE);
          rect1.setStroke(Color.BLACK);
        }      
        break;
      case ROUND_RECTANGLE: // Display a round-cornered rectangle
        rect2.widthProperty().bind(widthProperty().subtract(10));
        rect2.heightProperty().bind(heightProperty().subtract(10));        
        getChildren().add(rect2);
        
        if (filled.get()) {
          rect2.setFill(Color.RED);
        }
        else {
          rect2.setFill(Color.WHITE);
          rect2.setStroke(Color.BLACK);
        }
        
        break;
      case ELLIPSE: // Display an oval
        getChildren().add(ellipse);
        break;
    }
  }
  
  /** value getter for a figure type */
  public FigureType getType() {
    return type.get();
  }

  /** value setter a new figure type */
  public void setType(FigureType type) {
    this.type.set(type);
  }

  /** property getter for a figure type */
  public ObjectProperty<FigureType> typeProperty() {
    return type;
  }

  /** value getter method for filled property */
  public boolean isFilled() {
    return filled.get();
  }
  
  /** value setter method for filled property */
  public void setFilled(boolean filled) {
    this.filled.set(filled);
  }

  /** property getter method for filled property */
  public BooleanProperty filledProperty() {
    return filled;
  }
}
