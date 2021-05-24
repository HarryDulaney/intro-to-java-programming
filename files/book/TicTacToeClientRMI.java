import java.rmi.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Ellipse;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class TicTacToeClientRMI extends Application {
  // marker is used to indicate the token type
  private char marker;

  // myTurn indicates whether the player can move now
  private boolean myTurn = false;

  // Indicate which player has a turn, initially it is the X player
  private char whoseTurn = 'X';

  // Create and initialize cell
  private Cell[][] cell =  new Cell[3][3];

  // Create and initialize a status label
  private Label lblStatus = new Label("X's turn to play");

  // ticTacToe is the game server for coordinating 
  // with the players
  private TicTacToeInterface ticTacToe;

  private Label lblIdentification = new Label();

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Pane to hold cell
    GridPane pane = new GridPane(); 
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 3; j++)
        pane.add(cell[i][j] = new Cell(i, j), j, i);

    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(pane);
    borderPane.setTop(lblStatus);
    borderPane.setBottom(lblIdentification);
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 450, 170);
    primaryStage.setTitle("TicTacToe"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage   
    
    new Thread( () -> {
    try {
      initializeRMI();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }}).start();
  }

  /** Initialize RMI */
  protected boolean initializeRMI() throws Exception {
    String host = "";

    try {
      Registry registry = LocateRegistry.getRegistry(host);
      ticTacToe = (TicTacToeInterface) 
        registry.lookup("TicTacToeImpl");
      System.out.println
        ("Server object " + ticTacToe + " found");
    } 
    catch (Exception ex) {
      System.out.println(ex);
    }

    // Create callback for use by the 
    // server to control the client
    CallBackImpl callBackControl = new CallBackImpl(this);

    if (
      (marker = 
        ticTacToe.connect((CallBack)callBackControl)) != ' ')
    {
      System.out.println("connected as " + marker + " player.");
      lblIdentification.setText("You are player " + marker);
      return true;
    }
    else {
      System.out.println("already two players connected as ");
      return false;
    }
  }

  /** Set variable myTurn to true or false */
  public void setMyTurn(boolean myTurn) {
    this.myTurn = myTurn;
  }

  /** Set message on the status label */
  public void setMessage(String message) {
    lblStatus.setText(message);
  }

  /** Mark the specified cell using the token */
  public void mark(int row, int column, char token) {
    cell[row][column].setToken(token);
  }

  // An inner class for a cell
  public class Cell extends Pane {
    // marked indicates whether the cell has been used
    private boolean marked = false;

    // row and column indicate where the cell appears on the board
    int row, column;

   // Token used for this cell
    private char token = ' ';

    public Cell(final int row, final int column) {
      this.row = row;
      this.column = column;
      setStyle("-fx-border-color: black"); 
      this.setPrefSize(2000, 2000);
      this.setOnMouseClicked(e -> handleMouseClick());
    }

    /** Return token */
    public char getToken() {
      return token;
    }

    /** Set a new token */
    public void setToken(char c) {
      token = c;
      marked = true;
      
      if (token == 'X') {
        Line line1 = new Line(10, 10, 
          this.getWidth() - 10, this.getHeight() - 10);
        line1.endXProperty().bind(this.widthProperty().subtract(10));
        line1.endYProperty().bind(this.heightProperty().subtract(10));
        Line line2 = new Line(10, this.getHeight() - 10, 
          this.getWidth() - 10, 10);
        line2.startYProperty().bind(
          this.heightProperty().subtract(10));
        line2.endXProperty().bind(this.widthProperty().subtract(10));
        
        // Add the lines to the pane
        this.getChildren().addAll(line1, line2); 
      }
      else if (token == 'O') {
        Ellipse ellipse = new Ellipse(this.getWidth() / 2, 
          this.getHeight() / 2, this.getWidth() / 2 - 10, 
          this.getHeight() / 2 - 10);
        ellipse.centerXProperty().bind(
          this.widthProperty().divide(2));
        ellipse.centerYProperty().bind(
            this.heightProperty().divide(2));
        ellipse.radiusXProperty().bind(
            this.widthProperty().divide(2).subtract(10));        
        ellipse.radiusYProperty().bind(
            this.heightProperty().divide(2).subtract(10));   
        ellipse.setStroke(Color.BLACK);
        ellipse.setFill(Color.WHITE);
        
        getChildren().add(ellipse); // Add the ellipse to the pane
      }
    }

    /* Handle a mouse click event */
    private void handleMouseClick() {
      if (myTurn && !marked) {
        // Mark the cell
        setToken(marker);

        // Notify the server of the move
        try {
          ticTacToe.myMove(row, column, marker);
        }
        catch (RemoteException ex) {
          System.out.println(ex);
        }
      }
    }
  }
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
