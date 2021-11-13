package ch_20;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * ***20.15 (Game: the 24-point card game) Improve Programming Exercise 20.13
 * to enable the computer to display the expression if one exists, as shown in
 * Figure 20.20. Otherwise, report that the expression does not exist. Place the
 * label for verification result at the bottom of UI. The expression must use all
 * four cards and evaluates to 24.
 */
public class Exercise20_15 extends Application {
    String[] cards;
    int[] picked = new int[4];
    int pick = 0;
    static final String CORRECT_RESULT = "Correct";
    static final String INCORRECT_RESULT = "Incorrect Result";
    static final String WRONG_NUMBERS = "The Numbers in the expression, don't match the number in the set.";

    private void setCards() {
        cards = new String[52];
        int cardNum = 1;
        for (int i = 0; i < cards.length; i++) {
            String path = "resources/images/card/" + cardNum + ".png";
            cardNum++;
            cards[i] = path;

        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        setCards();
        VBox vbox = new VBox();
        HBox cardBox = new HBox();
        HBox toolBarBottom = new HBox(15);
        VBox bottomBox = new VBox(10);
        HBox buttonBarTop = new HBox(10);
        vbox.setFillWidth(true);

        VBox.setMargin(cardBox, new Insets(10, 20, 20, 10));

        Text resultText = new Text("");
        SimpleStringProperty message = new SimpleStringProperty();
        message.bind(resultText.textProperty());

        Image i1 = new Image(cards[randomCard()]);
        Image i2 = new Image(cards[randomCard()]);
        Image i3 = new Image(cards[randomCard()]);
        Image i4 = new Image(cards[randomCard()]);

        ImageView card1 = new ImageView(i1);
        card1.setPreserveRatio(true);
        card1.setFitHeight(300);

        ImageView card2 = new ImageView(i2);
        card2.setPreserveRatio(true);
        card2.setFitHeight(300);

        ImageView card3 = new ImageView(i3);
        card3.setPreserveRatio(true);
        card3.setFitHeight(300);

        ImageView card4 = new ImageView(i4);
        card4.setPreserveRatio(true);
        card4.setFitHeight(300);

        TextField inputField = new TextField();
        inputField.setMinWidth(200);

        TextField findSolutionTxtFld = new TextField();
        findSolutionTxtFld.setPrefWidth(150);

        Button shuffleButton = new Button("Shuffle");
        shuffleButton.setOnAction(e -> {
            resultText.setText("");
            inputField.setText("");
            shuffleCards(cardBox);
            findSolutionTxtFld.setText("");

        });

        Button verifyButton = new Button("Verify");
        verifyButton.setOnAction(event -> {
            String result = verifyExpression(inputField.getText());
            resultText.setText(result);
        });

        Button findSolutionBtn = new Button("Find Solution");
        findSolutionBtn.setOnAction(event -> {
            // Find Solution
            String solution = calculateSolution();
            findSolutionTxtFld.setText(solution);
        });

        buttonBarTop.getChildren().add(findSolutionBtn);
        buttonBarTop.getChildren().add(findSolutionTxtFld);
        buttonBarTop.getChildren().add(shuffleButton);
        buttonBarTop.setAlignment(Pos.CENTER);
        HBox.setMargin(shuffleButton, new Insets(5, 10, 5, 5));
        HBox.setMargin(findSolutionBtn, new Insets(5, 10, 5, 5));
        HBox.setMargin(findSolutionTxtFld, new Insets(5, 10, 5, 5));

        Label inputLabel = new Label("Enter an expression: ");

        toolBarBottom.getChildren().add(inputLabel);
        toolBarBottom.getChildren().add(inputField);
        toolBarBottom.getChildren().add(verifyButton);
        bottomBox.getChildren().add(resultText);

        toolBarBottom.setAlignment(Pos.CENTER);
        toolBarBottom.setPadding(new Insets(10, 10, 10, 15));
        cardBox.getChildren().addAll(card1, card2, card3, card4);
        vbox.getChildren().add(buttonBarTop);
        vbox.getChildren().add(cardBox);
        vbox.getChildren().add(toolBarBottom);
        vbox.getChildren().add(bottomBox);
        VBox.setMargin(resultText, new Insets(10, 10, 10, 10));

        Scene scene = new Scene(vbox);
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


    private String calculateSolution() {
        int[] cards = new int[4];
        List<Integer> cardsValues = getPickedCardsValues();
        int x = 0;
        for (Integer i : cardsValues) {
            cards[x++] = i;
        }
        return findSolution(cards);
    }

    String findSolution(int[] cards) {
        for (int a = 0; a < 4; a++) {
            for (int b = 0; b < 4; b++) {
                if (a != b) {
                    for (int c = 0; c < 4; c++) {
                        if (a != c && b != c) {
                            for (int d = 0; d < 4; d++) {
                                // permutation of 4 cards, index is a,b,c,d
                                if (a != d && b != d && c != d) {
                                    for (int x = 0; x < 4; x++) {
                                        for (int y = 0; y < 4; y++) {
                                            // 3 ops '+-*/', in x,y,z
                                            for (int z = 0; z < 4; z++) {
                                                // 5 possible RPN(Reverse Polish Notation) : N-Number, O-Ops
                                                // Exp 1
                                                if (equals24(operate(cards[a], operate(cards[b], operate(cards[c], cards[d],
                                                        x), y), z))) {
                                                    return getExpressionString(1, cards[a], cards[b], cards[c], cards[d]
                                                            , x, y, z);
                                                }
                                                // Exp 2
                                                if (equals24(operate(cards[a], operate(operate(cards[b], cards[c], x),
                                                        cards[d], y), z))) {
                                                    return getExpressionString(2, cards[a], cards[b], cards[c], cards[d]
                                                            , x, y, z);
                                                }
                                                // Exp 3
                                                if (equals24(operate(operate(cards[a], operate(cards[b], cards[c], x), y),
                                                        cards[d], z))) {
                                                    return getExpressionString(3, cards[a], cards[b], cards[c], cards[d]
                                                            , x, y, z);
                                                }
                                                // Exp 4
                                                if (equals24(operate(operate(cards[a], cards[b], x), operate(cards[c],
                                                        cards[d], y), z))) {
                                                    return getExpressionString(4, cards[a], cards[b], cards[c], cards[d]
                                                            , x, y, z);
                                                }
                                                // Exp 5
                                                if (equals24(operate(operate(operate(cards[a], cards[b], x), cards[c], y),
                                                        cards[d], z))) {
                                                    return getExpressionString(5, cards[a], cards[b], cards[c], cards[d]
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


    private String verifyExpression(String text) {
        List<Integer> currentCards = getPickedCardsValues();

        List<Integer> inputNumbers = parseInputNumbers(text);

        for (int i = 0; i < inputNumbers.size(); i++) {
            boolean removed = currentCards.remove(inputNumbers.get(i));
            if (!removed) {
                return WRONG_NUMBERS;
            }
        }

        if (!(currentCards.size() == 0)) {
            return WRONG_NUMBERS;
        }

        if (evalExpression(text) == 24) {
            return CORRECT_RESULT;
        }

        return INCORRECT_RESULT;
    }

    private List<Integer> getPickedCardsValues() {
        String[] currentCards = new String[4];

        for (int i = 0; i < picked.length; i++) {
            currentCards[i] = cards[picked[i]];
        }

        String[] cardNums = new String[4];
        int i = 0;
        for (String card : currentCards) {
            String[] parts = card.split("/");
            String name = parts[parts.length - 1];
            String cardNum = name.split("\\.")[0];
            cardNums[i] = cardNum;
            i++;
        }
        List<Integer> cardValues = new ArrayList<>();

        for (i = 0; i < cardNums.length; i++) {
            cardValues.add(getNumberValue(cardNums[i]));
        }
        return cardValues;
    }

    private List<Integer> parseInputNumbers(String text) {
        List<Integer> values = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isDigit(ch)) {
                if (i + 1 < text.length()) {
                    i++;
                    char ch2 = text.charAt(i);
                    if (Character.isDigit(ch2)) {
                        values.add(Integer.parseInt(ch + "" + ch2));
                        continue;
                    }
                }
                values.add(Integer.parseInt(ch + ""));
            }
        }
        return values;
    }

    private void shuffleCards(HBox hBox) {
        pick = 0;
        Image i1 = new Image(cards[randomCard()]);
        Image i2 = new Image(cards[randomCard()]);
        Image i3 = new Image(cards[randomCard()]);
        Image i4 = new Image(cards[randomCard()]);

        ImageView card1 = new ImageView(i1);
        card1.setPreserveRatio(true);
        card1.setFitHeight(300);

        ImageView card2 = new ImageView(i2);
        card2.setPreserveRatio(true);
        card2.setFitHeight(300);

        ImageView card3 = new ImageView(i3);
        card3.setPreserveRatio(true);
        card3.setFitHeight(300);

        ImageView card4 = new ImageView(i4);
        card4.setPreserveRatio(true);
        card4.setFitHeight(300);
        hBox.getChildren().setAll(card1, card2, card3, card4);
    }

    int randomCard() {
        int ran = (int) (Math.random() * 52);
        picked[pick++] = ran;
        return ran;
    }

    private int getNumberValue(String card) {
        int cardValue = 0;
        Path p = Paths.get(card);
        String fileName = p.getFileName().toString();
        final int cardNum = Integer.parseInt(fileName);

        // Spades
        if (cardNum <= 13) {
            cardValue = cardNum;

            // Hearts
        } else {
            if (cardNum <= 26) {
                cardValue = reduceToValue(cardNum);

                // Diamonds
            } else if (cardNum <= 39) {
                cardValue = reduceToValue(cardNum);

                // Clubs
            } else {
                cardValue = reduceToValue(cardNum);
            }
        }
        return cardValue;
    }

    private int reduceToValue(int value) {
        /* get value regardless of suite */
        while (value > 13) {
            value -= 13;
        }
        return value;
    }

    private static int evalExpression(String exp) {
        // Stack to store the operands
        Stack<Integer> operandStack = new Stack<>();

        // Stack to store operators
        Stack<Character> operatorStack = new Stack<>();

        // Delimit expression with spaces to make consistent for evaluating
        exp = delimit(exp);

        String[] tokens = exp.split(" ");

        for (String token : tokens) {
            if (token.length() == 0) { // blank space
                continue;
            } else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                while (!operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-'
                        || operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
                    processOperator(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));

            } else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
                while (!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
                    processOperator(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));

            } else if (token.trim().charAt(0) == '(') {
                operatorStack.push('('); // Push '(' to stack
            } else if (token.trim().charAt(0) == ')') {
                // Process all the operators in the stack until seeing '(
                while (operatorStack.peek() != '(') {
                    processOperator(operandStack, operatorStack);
                }
                operatorStack.pop(); // Pop the '(' symbol from the stack
            } else { // An operand scanned
                // Push an operand to the stack
                operandStack.push(new Integer(token));
            }
        }
        // Phase 2: Process all the remaining operators in the stack
        while (!operatorStack.isEmpty()) {
            processOperator(operandStack, operatorStack);
        }
        // Return the result
        return operandStack.pop();
    }

    /**
     * Process one operator: Take an operator from operatorStack and apply it on the
     * operands in the operandStack
     */
    private static void processOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        int op1 = operandStack.pop();
        int op2 = operandStack.pop();
        if (op == '+')
            operandStack.push(op2 + op1);
        else if (op == '-')
            operandStack.push(op2 - op1);
        else if (op == '*')
            operandStack.push(op2 * op1);
        else if (op == '/')
            operandStack.push(op2 / op1);
    }

    private static String delimit(String str) {
        String res = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == ')' || str.charAt(i) == '+' || str.charAt(i) == '-'
                    || str.charAt(i) == '/' || str.charAt(i) == '*') {

                res += " " + str.charAt(i) + " ";

            } else {
                res += str.charAt(i);

            }

        }

        return res;
    }
}
