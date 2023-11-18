package ch_16;

import java.util.List;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * **16.14 (Select a font) Write a program that can dynamically change the font of a text
 * in a label displayed on a stack pane. The text can be displayed in bold and
 * italic at the same time. You can select the font name or font size from combo
 * boxes, as shown in Figure 16.42a. The available font names can be obtained
 * using Font.getFamilies(). The combo box for the font size is initialized
 * with numbers from 1 to 100.
 */
public class Exercise16_14 extends Application {
    private double paneWidth = 680;
    private double paneHeight = 250;
    private Label label = new Label("Programming is fun");
    private ComboBox<String> cboFontName = new ComboBox<>();
    private ComboBox<Integer> cboFontSize = new ComboBox<>();
    private CheckBox chkBold = new CheckBox("Bold");
    private CheckBox chkItalic = new CheckBox("Italic");

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        pane.setCenter(label);

        List<String> fontNames = Font.getFontNames();
        cboFontName.getItems().addAll(fontNames);
        cboFontName.setValue(fontNames.get(0));
        for (int i = 1; i <= 100; i++) {
            cboFontSize.getItems().add(i);
        }
        cboFontSize.setValue(20);

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(new Label("Font Name"),
                cboFontName, new Label("Font Size"), cboFontSize);
        hBox.setAlignment(Pos.CENTER);
        pane.setTop(hBox);

        HBox hBox2 = new HBox(10);
        hBox2.getChildren().addAll(chkBold, chkItalic);
        hBox2.setAlignment(Pos.CENTER);
        pane.setBottom(hBox2);

        Scene scene = new Scene(pane, paneWidth, paneHeight);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

        cboFontName.setOnAction(e -> {
            setFont();
        });

        cboFontSize.setOnAction(e -> {
            setFont();
        });

        chkBold.setOnAction(e -> {
            setFont();
        });

        chkItalic.setOnAction(e -> {
            setFont();
        });
    }

    private void setFont() {
        FontWeight weight;
        if (chkBold.isSelected()) {
            weight = FontWeight.BOLD;
        } else {
            weight = FontWeight.NORMAL;
        }

        FontPosture posture;
        if (chkItalic.isSelected()) {
            posture = FontPosture.ITALIC;
        } else {
            posture = FontPosture.REGULAR;
        }
        label.setFont(Font.font(cboFontName.getValue(), weight, posture,
                cboFontSize.getValue()));
    }
}
