package ch_16;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * *16.12 (Demonstrate TextArea properties) Write a program that demonstrates the
 * properties of a text area. The program uses a checkbox to indicate whether the
 * text is wrapped onto next line, as shown in Figure 16.41a.
 */
public class Exercise16_12 extends Application {
    private final double PANE_WIDTH = 600;
    private final double PANE_HEIGHT = 250;

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        TextArea ta = new TextArea();
        pane.setCenter(new ScrollPane(ta));

        HBox hBox = new HBox(10);
        CheckBox editableCheckBox = new CheckBox("Editable");
        editableCheckBox.setSelected(true);
        ta.setEditable(true);
        CheckBox wrapCheckBox = new CheckBox("Wrap");
        hBox.getChildren().addAll(editableCheckBox, wrapCheckBox);
        wrapCheckBox.setSelected(true);
        ta.setWrapText(true);
        hBox.setAlignment(Pos.CENTER);
        pane.setBottom(hBox);

        Scene scene = new Scene(pane, PANE_WIDTH, PANE_HEIGHT);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

        editableCheckBox.setOnAction(e -> {
            ta.setEditable(editableCheckBox.isSelected());
        });

        wrapCheckBox.setOnAction(e -> {
            ta.setWrapText(wrapCheckBox.isSelected());
        });
    }

}
