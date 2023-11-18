package ch_16;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * 16.16 (Use ComboBox and ListView) Write a program that demonstrates selecting
 * items in a list. The program uses a combo box to specify a selection mode, as
 * shown in Figure 16.43a. When you select items, they are displayed in a label
 * below the list.
 */
public class Exercise16_16 extends Application {
    private final double PANE_WIDTH = 280;
    private final double PANE_HEIGHT = 250;
    private Label label = new Label("No items selected");
    private ComboBox<String> cboSelectionMode = new ComboBox<>();
    private ListView<String> lv = new ListView();

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();

        lv.getItems().addAll("China", "Japan", "Korea", "India",
                "Malaysia", "Vietnam");

        cboSelectionMode.getItems().addAll("SINGLE", "MULTIPLE");
        cboSelectionMode.setValue("SINGLE");

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(new Label("Choose Selection Mode:"),
                cboSelectionMode);
        hBox.setAlignment(Pos.CENTER);
        pane.setTop(hBox);
        pane.setCenter(new ScrollPane(lv));
        pane.setBottom(label);

        Scene scene = new Scene(pane, PANE_WIDTH, PANE_HEIGHT);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

        cboSelectionMode.setOnAction(e -> {
            if (cboSelectionMode.getValue().equals("SINGLE")) {
                lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            } else {
                lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            }
        });

        lv.getSelectionModel().selectedItemProperty().addListener(ov -> {
            StringBuilder items = new StringBuilder();
            for (String s : lv.getSelectionModel().getSelectedItems()) {
                items.append(s).append(" ");
            }
            label.setText("Selected items are " + items);
        });
    }
}
