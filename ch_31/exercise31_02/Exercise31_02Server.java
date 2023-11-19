package ch_31.exercise31_02;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class Exercise31_02Server extends Application {
    private static final double KILOGRAMS_PER_POUND = 0.45359237;
    private static final double METERS_PER_INCH = 0.0254;

    @Override
    public void start(Stage primaryStage) {
        TextArea displayLogTextArea = new TextArea();
        Scene scene = new Scene(new ScrollPane(displayLogTextArea), 450, 200);
        primaryStage.setTitle("TicTacToeServer");
        primaryStage.setScene(scene);
        primaryStage.show();
        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8000);
                Platform.runLater(() ->
                        displayLogTextArea.appendText("Exercise31_02Server started at "
                                + new Date() + '\n'));

                Socket socket = serverSocket.accept();
                DataInputStream inputFromClient = new DataInputStream(
                        socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(
                        socket.getOutputStream());

                while (true) {
                    Date date = new Date();
                    double weight = inputFromClient.readDouble();
                    double height = inputFromClient.readDouble();
                    double weightInKilograms = weight * KILOGRAMS_PER_POUND;
                    double heightInMeters = height * METERS_PER_INCH;
                    double bmi = calculateBmi(weightInKilograms, heightInMeters);
                    StringBuilder bmiString = new StringBuilder("BMI is " +
                            String.format("%.2f", bmi) + ". ");

                    if (bmi < 18.5) {
                        bmiString.append("Underweight");
                    } else if (bmi < 25) {
                        bmiString.append("Normal");
                    } else if (bmi < 30) {
                        bmiString.append("Overweight");
                    } else {
                        bmiString.append("Obese");
                    }
                    outputToClient.writeUTF(bmiString.toString());

                    Platform.runLater(() -> {
                        displayLogTextArea.appendText("Connected to a client at " + date + '\n');
                        displayLogTextArea.appendText("Weight: " + weight + '\n');
                        displayLogTextArea.appendText("Height: " + height + '\n');
                        displayLogTextArea.appendText(bmiString.toString() + '\n');
                    });
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    private double calculateBmi(double weight, double height) {
        double weightInKilograms = weight * KILOGRAMS_PER_POUND;
        double heightInMeters = height * METERS_PER_INCH;
        return weightInKilograms /
                (heightInMeters * heightInMeters);
    }

}
