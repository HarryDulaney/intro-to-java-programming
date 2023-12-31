package ch_16.exercise16_11;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Histogram extends Pane {
    private int[] counts;


    public Histogram(int[] counts) {
        this.counts = counts;
        getChildren().clear();
        paint();
    }

    void paint() {
        getChildren().clear();
        double frameWidth = getWidth();
        double frameHeight = getHeight();
        double unitWidth = frameWidth / counts.length - 10;

        for (int i = 0; i < counts.length; i++) {
            double labelX = i * unitWidth;
            double labelY = frameHeight;
            double unitHeight = counts[i];
            double unitY = frameHeight - unitHeight;
            double unitX = i * unitWidth;
            Text label = new Text(labelX + 5, labelY - 5, (char) (65 + i) + "");
            Rectangle chartShape = new Rectangle(unitX, unitY - label.getLayoutBounds().getHeight(), unitWidth, unitHeight);
            chartShape.setFill(Color.WHITE);
            chartShape.setStroke(Color.BLACK);
            getChildren().add(chartShape);
            getChildren().add(label);
        }
    }

    public void setCounts(int[] counts) {
        this.counts = counts;
        // redraw the histogram
        paint();
    }
}
