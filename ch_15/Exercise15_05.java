package ch_15;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * *15.5 (Create an investment-value calculator) Write a program that calculates the
 * future value of an investment at a given interest rate for a specified number of
 * years. The formula for the calculation is:
 * futureValue = investmentAmount * (1 + monthlyInterestRate)^ years * 12
 * Use text fields for the investment amount, number of years, and annual interest
 * rate. Display the future amount in a text field when the user clicks the Calculate
 * button, as shown in Figure 15.25b.
 */
public class Exercise15_05 extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        SimpleStringProperty displayResult = new SimpleStringProperty();

        VBox mainBox = new VBox(5);

        HBox investmentAmountBox = new HBox(5);
        TextField amountField = new TextField();
        Label amountLabel = new Label("Investment Amount:");
        HBox.setMargin(amountLabel, new Insets(10, 5, 5, 1));
        HBox.setMargin(amountField, new Insets(10, 5, 5, 1));
        investmentAmountBox.getChildren().addAll(amountLabel, amountField);

        HBox numYearsBox = new HBox(5);
        Label yearsLabel = new Label("Number Of Years:");
        TextField yearsField = new TextField();
        HBox.setMargin(yearsField, new Insets(1, 5, 5, 1));
        HBox.setMargin(yearsLabel, new Insets(1, 5, 5, 1));
        numYearsBox.getChildren().addAll(yearsLabel, yearsField);

        HBox interestRateBox = new HBox(5);
        Label interestLabel = new Label("Annual Interest Rate:");
        TextField interestField = new TextField();
        HBox.setMargin(interestLabel, new Insets(1, 5, 5, 1));
        HBox.setMargin(interestField, new Insets(1, 5, 5, 1));
        interestRateBox.getChildren().addAll(interestLabel, interestField);

        HBox futureValueBox = new HBox(5);
        Label futureValLabel = new Label("Future Value:");
        TextField resultField = new TextField();

        HBox.setMargin(futureValLabel, new Insets(1, 5, 5, 5));
        HBox.setMargin(resultField, new Insets(1, 5, 5, 5));

        resultField.textProperty().bind(displayResult);

        futureValueBox.getChildren().addAll(futureValLabel, resultField);

        HBox bottomBox = new HBox(5);
        Button calcBtn = new Button("Calculate");
        bottomBox.getChildren().add(calcBtn);
        HBox.setMargin(calcBtn, new Insets(1, 10, 0, 0));
        calcBtn.setOnAction(e -> {
            double fv = calculateFutureValue(amountField.getText(), yearsField.getText(), interestField.getText());
            displayResult.set(String.format("$%.2f", fv));
        });
        bottomBox.setAlignment(Pos.BOTTOM_RIGHT);

        mainBox.getChildren().addAll(investmentAmountBox, numYearsBox, interestRateBox, futureValueBox, bottomBox);

        Scene scene = new Scene(mainBox, 400, 225);
        primaryStage.setScene(scene);
        primaryStage.setTitle(getClass().getName());
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    double calculateFutureValue(String investmentAmount, String numYears, String annualInterestRate) {
        double amount = Double.parseDouble(investmentAmount);
        int years = Integer.parseInt(numYears);
        double monthRate = Double.parseDouble(annualInterestRate) / 100 / 12;
        double temp = Math.pow((1 + monthRate), (years * 12.0));
        return amount * temp;
    }
}
