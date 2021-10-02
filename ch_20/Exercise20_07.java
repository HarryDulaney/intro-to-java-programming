package ch_20;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
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

    int wrongAnswers = 0;

    Text currentWordPrompt = new Text("Guess a word: ");
    Text currentWordLbl = new Text();
    Text missedLetterPrompt = new Text("Missed letters: ");
    Text missedLettersLbl = new Text();
    boolean wordComplete;

    ObservableList<Node> observableNodes;
    StringProperty DISPLAY_WORD = new SimpleStringProperty();
    static String currentWord;
    StringProperty MISSED_LETTERS = new SimpleStringProperty();
    static String missedLetters = "";
    StringProperty USER_MESSAGE = new SimpleStringProperty();

    String[] words = {"abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "class", "const",
            "continue", "default", "double", "enum",
            "protected", "public", "return", "short", "static",
            "super", "switch", "synchronized", "this",
            "throw", "throws", "transient", "void", "volatile",
            "while"};

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        observableNodes = pane.getChildren();
        currentWordLbl.textProperty().bind(DISPLAY_WORD);
        missedLettersLbl.textProperty().bind(MISSED_LETTERS);

        Queue<Shape> parts = new LinkedList<>();
        ArrayList<Character> playedLetters = new ArrayList<>();

        Arc arc = new Arc(WIDTH / 4, HEIGHT - HEIGHT / 12, WIDTH / 5, HEIGHT / 12, 0, 180);
        arc.setFill(Color.TRANSPARENT);
        arc.setStroke(Color.BLACK);
        observableNodes.add(arc);

        Queue<String> wordsList = new LinkedList<>(Arrays.asList(words));
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        Line pole = new Line(arc.getCenterX(), arc.getCenterY() - arc.getRadiusY(), arc.getCenterX(),
                pane.getHeight() / 12);
        observableNodes.add(pole);

        Line holder = new Line(pole.getEndX(), pole.getEndY(), pane.getWidth() / 1.7, pole.getEndY());
        observableNodes.add(holder);

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

        Line hang = new Line(holder.getEndX(), holder.getEndY(), holder.getEndX(), pane.getHeight() / 6);
        parts.add(hang);

        double radius = WIDTH / 10;
        Circle c = new Circle(holder.getEndX(), pane.getHeight() / 6 + radius, radius);
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


        scene.setOnKeyPressed(e -> {
            KeyCode keyCode = e.getCode();
            if (keyCode.isLetterKey()) {
                String letter = keyCode.getName();
                System.out.println(letter);
                handleGuess(letter, currentWord, playedLetters, parts, observableNodes);

            } else if (keyCode == KeyCode.ENTER && wordComplete) {
                // Next Word
                currentWord = wordsList.poll();
                wrongAnswers = 0;
                missedLetters = "";
                playedLetters.clear();
                MISSED_LETTERS.set(missedLetters);
                DISPLAY_WORD.set(getDisplayWord(currentWord, playedLetters));
                wordComplete = false;

            }
        });

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle(getClass().getName());
        primaryStage.show();

        if (wordsList.peek() != null) {
            currentWord = wordsList.poll();
            DISPLAY_WORD.set(getDisplayWord(currentWord, playedLetters));
        }
    }

    void handleGuess(String letter, String currentWord, ArrayList<Character> playedLetters, Queue<Shape> parts,
                     ObservableList<Node> nodes) {
        char letterCh = Character.toLowerCase(letter.charAt(0));
        if (currentWord.contains(letterCh + "") && !wordComplete) {
            if (!playedLetters.contains(letterCh)) {
                playedLetters.add(letterCh);
                DISPLAY_WORD.set(getDisplayWord(currentWord, playedLetters));
                if (!DISPLAY_WORD.get().contains("*")) {
                    wordComplete = true;
                    MISSED_LETTERS.set("");
                }
            }
        } else if (!wordComplete) {
            wrongAnswers += 1;
            if (wrongAnswers == 7) {
                observableNodes.clear();
                observableNodes.add(new Label("Game Over"));
            }
            drawHangMan(parts, nodes);
            missedLetters += letter;
            MISSED_LETTERS.set(missedLetters.toLowerCase());

        }

    }

    void drawHangMan(Queue<Shape> parts, ObservableList<Node> nodes) {
        if (parts.peek() != null) {
            nodes.add(parts.poll());
        }
    }

    String getDisplayWord(String word, ArrayList<Character> playedLetters) {
        StringBuilder result = new StringBuilder();
        System.out.println(word);
        for (char ch : word.toCharArray()) {
            if (!playedLetters.contains(ch)) {
                result.append("*");
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}