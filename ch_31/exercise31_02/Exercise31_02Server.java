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
        primaryStage.setTitle("Exercise31_02Server");
        primaryStage.setScene(scene);
        primaryStage.show();
        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8000);
                Platform.runLater(() ->
                        displayLogTextArea.appendText("Exercise31_02Server started at "
                                + new Date() + '\n'));

                Socket socket = serverSocket.accept();
                ObjectInputStream inputFromClient = new ObjectInputStream(
                        socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(
                        socket.getOutputStream());

                while (true) {
                    Object object = inputFromClient.readObject();
                    String result = handleObjectInput(object);
                    outputToClient.writeUTF(result);

                    log(result, new Date(), displayLogTextArea);
                }
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println("Sever Error: " + ex.getMessage());
            }
        }).start();
    }

    private String handleObjectInput(Object object) throws IOException, ClassNotFoundException {
        BmiDto dto = (BmiDto) object;
        double bmi = calculateBmi(dto);
        return "BMI is " +
                String.format("%.2f", bmi) +
                ". " +
                getBmiString(bmi) +
                ". ";
    }

    private double calculateBmi(BmiDto dto) {
        double weightInKilograms = dto.getWeight() * KILOGRAMS_PER_POUND;
        double heightInMeters = dto.getHeight() * METERS_PER_INCH;
        return weightInKilograms /
                (heightInMeters * heightInMeters);
    }

    private String getBmiString(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        }

        if (bmi < 25) {
            return "Normal";
        }

        if (bmi < 30) {
            return "Overweight";
        }
        return "Obese";
    }

    private void log(String result,
                     Date date,
                     TextArea displayLogTextArea) {
        Platform.runLater(() -> {
            displayLogTextArea.appendText("Connected to a client at " + date + '\n');
            displayLogTextArea.appendText(result + '\n');
        });
    }
}
