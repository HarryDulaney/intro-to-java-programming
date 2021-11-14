package ch_20;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * **20.17 (Game: the 24-point card game) This exercise is a variation of the 24-point
 * card game described in Programming Exercise 20.13. Write a program to
 * check whether there is a 24-point solution for the four specified numbers. The
 * program lets the user enter four values, each between 1 and 13, as shown in
 * Figure 20.21. The user can then click the Solve button to display the solution or
 * display “No solution” if none exist.
 */
public class Exercise20_17 extends Application {

    static int[] numbers = new int[4];

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vbox = new VBox();
        HBox numberBox = new HBox();
        HBox topBox = new HBox(10);
        vbox.setFillWidth(true);
        VBox.setMargin(numberBox, new Insets(5, 5, 5, 5));


        TextField num1TextField = new TextField();
        num1TextField.setPrefWidth(60);
        num1TextField.setPrefHeight(50);
        num1TextField.setFont(new Font(25));
        num1TextField.setAlignment(Pos.CENTER);
        HBox.setMargin(num1TextField, new Insets(0, 5, 0, 0));

        num1TextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                try {
                    int val = Integer.parseInt(newValue);
                    if (val <= 13 && val >= 1) {
                        numbers[0] = Integer.parseInt(newValue);
                    } else {
                        num1TextField.setText(oldValue);
                        numbers[0] = 0;
                    }
                } catch (NumberFormatException numberFormatException) {
                    num1TextField.setText(oldValue);
                }

            }
        });

        TextField num2TextField = new TextField();
        num2TextField.setPrefWidth(60);
        num2TextField.setPrefHeight(50);
        num2TextField.setFont(new Font(25));
        num2TextField.setAlignment(Pos.CENTER);
        HBox.setMargin(num2TextField, new Insets(0, 5, 0, 0));

        num2TextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                try {
                    int val = Integer.parseInt(newValue);
                    if (val <= 13 && val >= 1) {
                        numbers[1] = Integer.parseInt(newValue);
                    } else {
                        num2TextField.setText(oldValue);
                        numbers[1] = 0;
                    }
                } catch (NumberFormatException numberFormatException) {
                    num2TextField.setText(oldValue);
                }

            }
        });


        TextField num3TextField = new TextField();
        num3TextField.setPrefWidth(60);
        num3TextField.setPrefHeight(50);
        num3TextField.setFont(new Font(25));
        num3TextField.setAlignment(Pos.CENTER);
        HBox.setMargin(num3TextField, new Insets(0, 5, 0, 0));
        num3TextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                try {
                    int val = Integer.parseInt(newValue);
                    if (val <= 13 && val >= 1) {
                        numbers[2] = Integer.parseInt(newValue);
                    } else {
                        num3TextField.setText(oldValue);
                        numbers[2] = 0;
                    }
                } catch (NumberFormatException numberFormatException) {
                    num3TextField.setText(oldValue);
                }

            }
        });

        TextField num4TextField = new TextField();
        num4TextField.setPrefWidth(60);
        num4TextField.setPrefHeight(50);
        num4TextField.setFont(new Font(25));
        num4TextField.setAlignment(Pos.CENTER);
        HBox.setMargin(num4TextField, new Insets(0, 5, 0, 0));
        num4TextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                try {
                    int val = Integer.parseInt(newValue);
                    if (val <= 13 && val >= 1) {
                        numbers[3] = Integer.parseInt(newValue);
                    } else {
                        num4TextField.setText(oldValue);
                        numbers[3] = 0;
                    }
                } catch (NumberFormatException numberFormatException) {
                    num4TextField.setText(oldValue);
                }

            }
        });

        TextField findSolutionTxtFld = new TextField();
        findSolutionTxtFld.setPrefWidth(180);
        numberBox.getChildren().addAll(num1TextField, num2TextField, num3TextField, num4TextField);
        numberBox.setAlignment(Pos.CENTER);

        Button findSolutionBtn = new Button("Solve");
        findSolutionBtn.setOnAction(event -> {
            if (numbers[0] != 0 && numbers[1] != 0 && numbers[2] != 0 && numbers[3] != 0) {
                String solution = findSolution(numbers);
                findSolutionTxtFld.setText(solution);
            } else {
                findSolutionTxtFld.setText("Invalid number values..");
            }

        });

        HBox.setMargin(findSolutionBtn, new Insets(5, 10, 5, 5));
        HBox.setMargin(findSolutionTxtFld, new Insets(5, 5, 5, 5));

        topBox.getChildren().add(findSolutionTxtFld);
        topBox.getChildren().add(findSolutionBtn);
        topBox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(topBox);
        vbox.getChildren().add(numberBox);

        Scene scene = new Scene(vbox, 300, 120);
        primaryStage.setScene(scene);
        primaryStage.setTitle(getClass().getName());
        primaryStage.show();

    }

    static boolean equals24(double i) {
        return i >= 23.999 && i <= 24.001;
    }

    double operate(double a, double b, int op) {
        if (op == 0) return a + b;
        if (op == 1) return a - b;
        if (op == 2) return a * b;
        if (op == 3) {
            return a / b;
        }
        throw new IllegalArgumentException("operate( " + a + ", " + b + ", " + op + " )");

    }

    String findSolution(int[] numbers) {
        for (int a = 0; a < 4; a++) {
            for (int b = 0; b < 4; b++) {
                if (a != b) {
                    for (int c = 0; c < 4; c++) {
                        if (a != c && b != c) {
                            for (int d = 0; d < 4; d++) {
                                // permutation of 4 numbers, index is a,b,c,d
                                if (a != d && b != d && c != d) {
                                    for (int x = 0; x < 4; x++) {
                                        for (int y = 0; y < 4; y++) {
                                            // 3 ops '+-*/', in x,y,z
                                            for (int z = 0; z < 4; z++) {
                                                // Exp 1
                                                if (equals24(operate(numbers[a], operate(numbers[b], operate(numbers[c], numbers[d],
                                                        x), y), z))) {
                                                    return getExpressionString(1, numbers[a], numbers[b], numbers[c], numbers[d]
                                                            , x, y, z);
                                                }
                                                // Exp 2
                                                if (equals24(operate(numbers[a], operate(operate(numbers[b], numbers[c], x),
                                                        numbers[d], y), z))) {
                                                    return getExpressionString(2, numbers[a], numbers[b], numbers[c], numbers[d]
                                                            , x, y, z);
                                                }
                                                // Exp 3
                                                if (equals24(operate(operate(numbers[a], operate(numbers[b], numbers[c], x), y),
                                                        numbers[d], z))) {
                                                    return getExpressionString(3, numbers[a], numbers[b], numbers[c], numbers[d]
                                                            , x, y, z);
                                                }
                                                // Exp 4
                                                if (equals24(operate(operate(numbers[a], numbers[b], x), operate(numbers[c],
                                                        numbers[d], y), z))) {
                                                    return getExpressionString(4, numbers[a], numbers[b], numbers[c], numbers[d]
                                                            , x, y, z);
                                                }
                                                // Exp 5
                                                if (equals24(operate(operate(operate(numbers[a], numbers[b], x), numbers[c], y),
                                                        numbers[d], z))) {
                                                    return getExpressionString(5, numbers[a], numbers[b], numbers[c], numbers[d]
                                                            , x, y, z);
                                                }
                                            }
                                        }

                                    }

                                }

                            }

                        }

                    }


                }

            }
        }

        return "No Solution";
    }

    String getOp(int op) {
        switch (op) {
            case 0:
                return "+";
            case 1:
                return "-";
            case 2:
                return "*";
            case 3:
                return "/";
        }
        return "";
    }

    String getExpressionString(int exp,
                               int a,
                               int b,
                               int c,
                               int d,
                               int x,
                               int y,
                               int z) {
        switch (exp) {
            case 1:
                return "" + a + getOp(z) + "(" + b + getOp(y) + "(" + c + getOp(x) + d + ")" + ")";
            case 2:
                return "" + a + getOp(z) + "(" + y + getOp(y) + "(" + b + getOp(x) + c + ")" + ")";
            case 3:
                return "" + d + getOp(z) + "(" + a + getOp(y) + "(" + b + getOp(x) + c + ")" + ")";
            case 4:
                return "(" + a + getOp(x) + b + ")" + getOp(z) + "(" + c + getOp(y) + d + ")";
            case 5:
                return "" + d + getOp(z) + "(" + c + getOp(y) + "(" + a + getOp(x) + b + ")" + ")";
        }
        return "";
    }

}
