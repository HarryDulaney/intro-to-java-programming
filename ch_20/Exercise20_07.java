package ch_20;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.*;

/**
 * ***20.7 (Game: hangman) Programming Exercise 7.35 presents a console version of the
 * popular hangman game. Write a GUI program that lets a user play the game. The
 * user guesses a word by entering one letter at a time, as shown in Figure 20.18.
 * If the user misses seven times, a hanging man swings. Once a word is finished,
 * the user can press the Enter key to continue to guess another word.
 */
public class Exercise20_07 extends Application {
    private final static double HEIGHT = 400;
    private final static double WIDTH = 400;

    StringProperty DISPLAY_WORD = new SimpleStringProperty();
    StringProperty MISSED_LETTERS = new SimpleStringProperty();
    StringProperty USER_MESSAGE = new SimpleStringProperty();
    StringProperty GUESS_WORD_LBL = new SimpleStringProperty();

    Text currentWordPrompt = new Text();
    Text currentWordLbl = new Text();
    Text missedLetterPrompt = new Text();
    Text missedLettersLbl = new Text();

    int wrongAnswers = 0;
    Label gameOverLbl = new Label("GAME OVER");


    boolean wordComplete;

    ObservableList<Node> observableNodes;
    ArrayList<Shape> parts = new ArrayList<>();
    static int nextHangmanPart = 0;
    static String currentWord;


    ArrayList<String> words = new ArrayList<>(Arrays.asList("abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "class", "const",
            "continue", "default", "double", "enum",
            "protected", "public", "return", "short", "static",
            "super", "switch", "synchronized", "this",
            "throw", "throws", "transient", "void", "volatile",
            "while"));

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        observableNodes = pane.getChildren();
        currentWordLbl.textProperty().bind(DISPLAY_WORD);
        missedLettersLbl.textProperty().bind(MISSED_LETTERS);
        missedLetterPrompt.textProperty().bind(USER_MESSAGE);
        currentWordPrompt.textProperty().bind(GUESS_WORD_LBL);

        ArrayList<Character> playedLetters = new ArrayList<>();

        gameOverLbl.setMinSize(WIDTH / 2, HEIGHT / 2);
        gameOverLbl.setAlignment(Pos.CENTER);
        gameOverLbl.setCenterShape(true);
        gameOverLbl.setTextAlignment(TextAlignment.CENTER);

        Arc arc = new Arc(WIDTH / 4, HEIGHT - HEIGHT / 12, WIDTH / 5, HEIGHT / 12, 0, 180);
        arc.setFill(Color.TRANSPARENT);
        arc.setStroke(Color.BLACK);
        observableNodes.add(arc);

        Collections.shuffle(words);
        LinkedList<String> wordsList = new LinkedList<>(words);

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        Line pole = new Line(arc.getCenterX(), arc.getCenterY() - arc.getRadiusY(), arc.getCenterX(),
                pane.getHeight() / 12);
        observableNodes.add(pole);

        Line holder = new Line(pole.getEndX(), pole.getEndY(), pane.getWidth() / 1.7, pole.getEndY());
        observableNodes.add(holder);
        parts = getHangmanParts(pane, holder);

        double promptX = arc.getCenterX() + 50;
        double promptY = arc.getCenterY() - 55;
        currentWordPrompt.setTextAlignment(TextAlignment.RIGHT);
        currentWordPrompt.setX(promptX);
        currentWordPrompt.setY(promptY);
        observableNodes.add(currentWordPrompt);

        currentWordLbl.setTextAlignment(TextAlignment.RIGHT);
        currentWordLbl.setX(currentWordPrompt.getX() + 100);
        currentWordLbl.setY(currentWordPrompt.getY());
        observableNodes.add(currentWordLbl);

        missedLetterPrompt.setTextAlignment(TextAlignment.RIGHT);
        missedLetterPrompt.setX(promptX);
        missedLetterPrompt.setY(promptY + 20);
        observableNodes.add(missedLetterPrompt);

        missedLettersLbl.setTextAlignment(TextAlignment.RIGHT);
        missedLettersLbl.setX(missedLetterPrompt.getX() + 100);
        missedLettersLbl.setY(missedLetterPrompt.getY());
        observableNodes.add(missedLettersLbl);


        scene.setOnKeyPressed(e -> {
            KeyCode keyCode = e.getCode();
            if (keyCode.isLetterKey()) {
                String letter = keyCode.getName();
                handleGuess(letter, currentWord, playedLetters, parts, observableNodes);

            } else if (keyCode == KeyCode.ENTER && wordComplete) {
                // Next Word
                resetHangman(parts, observableNodes);
                nextHangmanPart = 0;
                currentWord = wordsList.poll();
                wrongAnswers = 0;
                playedLetters.clear();
                MISSED_LETTERS.set("");
                GUESS_WORD_LBL.set("Guess a word: ");
                USER_MESSAGE.set("Missed letters: ");
                DISPLAY_WORD.set(getDisplayWord(currentWord, playedLetters));
                wordComplete = false;

            }
        });

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle(getClass().getName());
        primaryStage.show();

        USER_MESSAGE.set("Missed letters: ");
        MISSED_LETTERS.set("");
        GUESS_WORD_LBL.set("Guess a word: ");
        currentWord = wordsList.pollFirst();
        DISPLAY_WORD.set(getDisplayWord(currentWord, playedLetters));

    }

    private void resetHangman(ArrayList<Shape> parts, ObservableList<Node> observableNodes) {
        for (Shape part : parts) {
            observableNodes.remove(part);
        }
    }


    void handleGuess(String letter, String currentWord, ArrayList<Character> playedLetters, ArrayList<Shape> parts,
                     ObservableList<Node> nodes) {
        char letterCh = Character.toLowerCase(letter.charAt(0));
        if (currentWord.contains(letterCh + "") && !wordComplete) {
            if (!playedLetters.contains(letterCh)) {
                playedLetters.add(letterCh);
                DISPLAY_WORD.set(getDisplayWord(currentWord, playedLetters));
                if (!DISPLAY_WORD.get().contains("*")) {
                    wordComplete = true;
                    MISSED_LETTERS.set("");
                    USER_MESSAGE.set("To continue the game, press ENTER");
                }
            }
        } else if (!wordComplete) {
            wrongAnswers += 1;
            if (wrongAnswers == 7) {
                wordComplete = true;
                drawHangMan(parts, nodes); // Hangman swings
                MISSED_LETTERS.set("");
                USER_MESSAGE.set("To continue the game, press ENTER");
                GUESS_WORD_LBL.set("The word is: ");
                DISPLAY_WORD.set(currentWord);
            } else {
                String missed = MISSED_LETTERS.get();
                MISSED_LETTERS.set(missed.concat(String.valueOf(letterCh)));
                drawHangMan(parts, nodes); // Draw next hangman part
            }

        }

    }

    void drawHangMan(ArrayList<Shape> parts, ObservableList<Node> nodes) {
        nodes.add(parts.get(nextHangmanPart));
        nextHangmanPart += 1;
    }

    String getDisplayWord(String word, ArrayList<Character> playedLetters) {
        StringBuilder result = new StringBuilder();
        for (char ch : word.toCharArray()) {
            if (!playedLetters.contains(ch)) {
                result.append("*");
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    ArrayList<Shape> getHangmanParts(Pane pane, Line connectingNode) {
        ArrayList<Shape> parts = new ArrayList<>();

        Line hang = new Line(connectingNode.getEndX(), connectingNode.getEndY(), connectingNode.getEndX(), pane.getHeight() / 6);
        parts.add(hang);

        double radius = WIDTH / 10;
        Circle c = new Circle(connectingNode.getEndX(), pane.getHeight() / 6 + radius, radius);
        c.setFill(Color.TRANSPARENT);
        c.setStroke(Color.BLACK);
        parts.add(c);

        Line leftArm = new Line(pane.getWidth() / 2, pane.getHeight() / 2,
                c.getCenterX() + c.getRadius() * Math.cos(Math.toRadians(220)),
                c.getCenterY() - c.getRadius() * Math.sin(Math.toRadians(220)));
        parts.add(leftArm);

        Line rightArm = new Line(pane.getWidth() / 1.2, pane.getHeight() / 2,
                c.getCenterX() + c.getRadius() * Math.cos(Math.toRadians(315)),
                c.getCenterY() - c.getRadius() * Math.sin(Math.toRadians(315)));
        parts.add(rightArm);

        Line body = new Line(c.getCenterX() + c.getRadius() * Math.cos(Math.toRadians(270)),
                c.getCenterY() - c.getRadius() * Math.sin(Math.toRadians(270)),
                c.getCenterX() + c.getRadius() * Math.cos(Math.toRadians(270)), pane.getHeight() / 1.6);
        parts.add(body);

        Line leftLeg = new Line(body.getEndX(), body.getEndY(),
                pane.getWidth() / 2, pane.getHeight() / 1.3);
        parts.add(leftLeg);

        Line rightLeg = new Line(body.getEndX(), body.getEndY(),
                pane.getWidth() / 1.2, pane.getHeight() / 1.3);
        parts.add(rightLeg);

        return parts;
    }

}