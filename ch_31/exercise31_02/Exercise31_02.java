package ch_31.exercise31_02;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 * *31.2 (BMI server) Write a server for a client. The client sends the weight and
 * height for a person to the server (see Figure  31.18a). The server computes
 * BMI (Body Mass Index) and sends back to the client a string that reports the
 * BMI (see Figure 31.18b). See Section 3.8 for computing BMI. Name the client
 * Exercise31_02Client and the server Exercise31_02Server.
 */
public class Exercise31_02 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("##-_-_--_--_--__-_-- Starting: Exercise31_02 --_-__--__--__--_--_--##");
        new Thread(() -> {
            Platform.runLater(() -> new Exercise31_02Server().start(new Stage()));
            Platform.runLater(() -> new Exercise31_02Client().start(new Stage()));
        }).start();

    }
}
