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
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class Exercise31_02Server extends Application {
    private static final double KILOGRAMS_PER_POUND = 0.45359237;
    private static final double METERS_PER_INCH = 0.0254;

    private AtomicBoolean isRunning = new AtomicBoolean(true);

    public Exercise31_02Server() {
        System.out.println("##-_-_--_--_--__-_-- Starting: Exercise31_02Server --_-__--__--__--_--_--##");
    }


    @Override
    public void start(Stage primaryStage) {
        TextArea displayLogTextArea = new TextArea();
        Scene scene = new Scene(new ScrollPane(displayLogTextArea), 450, 200);
        primaryStage.setTitle("TicTacToeServer");
        primaryStage.setScene(scene);
        primaryStage.show();
        new Thread(() -> runServer(displayLogTextArea)).start();
    }

    private void runServer(TextArea displayLogTextArea) {
        /* Create a server socket. Use try with resources to close the socket automatically */
        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            // Listen for a connection request
            Socket socket = socket = serverSocket.accept();
            // Create data input and output streams
            try (ObjectInputStream inputFromClient = new ObjectInputStream(
                    socket.getInputStream())) {
                try (DataOutputStream outputToClient = new DataOutputStream(
                        socket.getOutputStream())) {

                    Platform.runLater(() -> displayLogTextArea.appendText(new Date() +
                            ": Server started at socket 8000\n"));
                    while (true) {
                        if (!isRunning.get()) {
                            break;
                        }
                        if (inputFromClient.available() > 0) {
                            // Receive Object from the client
                            Object object = inputFromClient.readObject();
                            if (Objects.nonNull(object) && object instanceof BmiDto) {
                                BmiDto bmiDto = (BmiDto) object;
                                double weight = bmiDto.getWeight();
                                double height = bmiDto.getHeight();
                                double bmi = calculateBmi(weight, height);
                                // Send area back to the client
                                outputToClient.writeDouble(bmi);
                            }
                        }

                    }
                }
            }

        } catch (ClassNotFoundException | IOException ex) {
            System.out.println("##----------- Server Error: Exception: " + ex.getMessage() + " -----------##");
        }
    }

    private double calculateBmi(double weight, double height) {
        double weightInKilograms = weight * KILOGRAMS_PER_POUND;
        double heightInMeters = height * METERS_PER_INCH;
        return weightInKilograms /
                (heightInMeters * heightInMeters);
    }

}
