package ch_31.exercise31_02;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class Exercise31_02Client extends Application {
    private TextField weightTextInput = new TextField();
    private TextField heightTextInput = new TextField();
    private TextArea displayResultTextArea = new TextArea();

    private Button submitButton = new Button("Submit");

    // Host name or ip
    String host = "localhost";

    private ObjectOutputStream toServer;
    private DataInputStream fromServer;

    public Exercise31_02Client() {
        System.out.println("##-_-_--_--_--__-_-- Starting: Exercise31_02Client --_-__--__--__--_--_--##");
    }

    @Override
    public void start(Stage primaryStage) {
        Stage stage = new Stage();
        GridPane pane = new GridPane();
        pane.add(new Label("Weight in pounds"), 0, 0);
        pane.add(weightTextInput, 1, 0);
        pane.add(new Label("Height in inches"), 0, 1);
        pane.add(heightTextInput, 1, 1);
        pane.add(submitButton, 1, 3);
        pane.add(displayResultTextArea, 1, 4);
        GridPane.setHalignment(submitButton, HPos.RIGHT);
        GridPane.setValignment(displayResultTextArea, VPos.BOTTOM);
        pane.setAlignment(Pos.CENTER);
        weightTextInput.setPrefColumnCount(15);
        heightTextInput.setPrefColumnCount(15);
        submitButton.setOnAction(new ButtonListener());

        Scene scene = new Scene(pane, 450, 200);
        stage.setTitle("BMI Client");
        stage.setScene(scene);
        stage.show();

        try (Socket socket = new Socket(host, 8000)) {
            // Create an output stream to the server
            toServer = new ObjectOutputStream(socket.getOutputStream());
            // Create an input stream from the server
            fromServer = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            System.out.println("##----------- Client Error: IOException: " + ex.getMessage() + " -----------##");
        }
    }

    /**
     * Custom event handler for the submit button
     */
    private class ButtonListener implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            try {
                // Get weight and height from the text fields
                double weight = Double.parseDouble(weightTextInput.getText().trim());
                double height = Double.parseDouble(heightTextInput.getText().trim());
                // Create a BmiDto and send to the server
                BmiDto s = new BmiDto(weight, height);
                toServer.writeObject(s);
                toServer.flush();
                // Get resulting BMI from the server
                double bmi = fromServer.readDouble();
                // Display to the text area
                displayResultTextArea.setText("Weight: " + weight + "\nHeight: " + height + "\nBMI is: " + bmi
                        + "\n" + getCategory(bmi));
            } catch (IOException ex) {
                System.out.println("##----------- Client Error: IOException: " + ex.getMessage() + " -----------##");
            }
        }
    }

    private String getCategory(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

}