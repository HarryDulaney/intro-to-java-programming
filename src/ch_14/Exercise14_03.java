package ch_14;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * *14.3 (Display three cards) Write a program that displays three cards randomly
 * selected from a deck of 52, as shown in Figure 14.43c. The card image files
 * are named 1.png, 2.png, …, 52.png and stored in the image/card directory.
 * All three cards are distinct and selected randomly. Hint: You can select random
 * cards by storing the numbers 1–52 to an array list, perform a random shuffle
 * introduced in Section 11.12, and use the first three numbers in the array list as
 * the file names for the image.
 */
public class Exercise14_03 extends Application {
    Image[] cards;
    int[] picked = new int[3];
    int pick = 0;

    private void setCards() {
        cards = new Image[52];
        int cardNum = 1;
        for (int i = 0; i < cards.length; i++) {
            Image card = new Image("resources/cards/" + cardNum + ".png");
            cards[i] = card;

            cardNum++;

        }

    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        setCards();
        VBox vbox = new VBox();
        HBox cardBox = new HBox();
        HBox buttonBar = new HBox();
        vbox.setFillWidth(true);

        ImageView card1 = new ImageView(cards[randomCard()]);
        card1.setPreserveRatio(true);
        card1.setFitHeight(300);

        ImageView card2 = new ImageView(cards[randomCard()]);
        card2.setPreserveRatio(true);
        card2.setFitHeight(300);

        ImageView card3 = new ImageView(cards[randomCard()]);
        card3.setPreserveRatio(true);
        card3.setFitHeight(300);

        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> {
            refreshCards(vbox);
        });

        buttonBar.getChildren().add(refreshButton);
        buttonBar.setAlignment(Pos.CENTER);

        cardBox.getChildren().addAll(card1, card2, card3);
        vbox.getChildren().add(cardBox);
        vbox.getChildren().add(buttonBar);
        Scene scene = new Scene(vbox);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void refreshCards(VBox vBox) {
        pick = 0;
        HBox nuCardBox = new HBox();
        ImageView c1 = new ImageView(cards[randomCard()]);
        c1.setPreserveRatio(true);
        c1.setFitHeight(300);

        ImageView c2 = new ImageView(cards[randomCard()]);
        c2.setPreserveRatio(true);
        c2.setFitHeight(300);

        ImageView c3 = new ImageView(cards[randomCard()]);
        c3.setPreserveRatio(true);
        c3.setFitHeight(300);
        nuCardBox.getChildren().addAll(c1, c2, c3);
        vBox.getChildren().set(0, nuCardBox);

    }

    int randomCard() {
        int ran = -1;
        do {
            ran = (int) (Math.random() * 52);

        } while (ran == picked[0] || ran == picked[1] || ran == picked[2]);

        picked[pick++] = ran;

        return ran;
    }

}
