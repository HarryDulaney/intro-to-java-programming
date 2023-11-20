package ch_31.exercise31_02;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Exercise31_02Client extends Application {
    ObjectOutputStream toServer = null;
    DataInputStream fromServer = null;
    private TextField weightTextInput = new TextField();
    private TextField heightTextInput = new TextField();

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        weightTextInput.setAlignment(Pos.BASELINE_RIGHT);
        heightTextInput.setAlignment(Pos.BASELINE_RIGHT);
        Button btSubmit = new Button("Submit");
        GridPane paneForBmiInfo = new GridPane();
        paneForBmiInfo.add(new Label("Weight in pounds"), 0, 0);
        paneForBmiInfo.add(weightTextInput, 1, 0);
        paneForBmiInfo.add(new Label("Height in inches"), 0, 1);
        paneForBmiInfo.add(heightTextInput, 1, 1);
        paneForBmiInfo.add(btSubmit, 2, 1);
        TextArea ta = new TextArea();
        pane.setTop(paneForBmiInfo);
        pane.setCenter(new ScrollPane(ta));

        Scene scene = new Scene(pane, 560, 300);
        primaryStage.setTitle("Exercise31_02Client");
        primaryStage.setScene(scene);
        primaryStage.show();

        btSubmit.setOnAction(e -> {
            try {
                double weight = Double.parseDouble(weightTextInput.getText().trim());
                double height = Double.parseDouble(heightTextInput.getText().trim());
                BmiDto dto = new BmiDto(weight, height);
                // Send the BMI information to the server
                toServer.writeObject(dto);
                toServer.flush();

                // Get string from the server
                String bmi = fromServer.readUTF();

                // Display to text area
                ta.appendText("Weight: " + weight + '\n');
                ta.appendText("Height: " + height + '\n');
                ta.appendText(bmi + '\n');
            } catch (IOException ex) {
                System.err.println(ex);
            }
        });

        try {
            // Create a socket to connect to the server
            Socket socket = new Socket("localhost", 8000);

            // Create an input stream to receive data from the server
            fromServer = new DataInputStream(socket.getInputStream());

            // Create an output stream to send data to the server
            toServer = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            ta.appendText(ex.toString() + '\n');
        }
    }
}