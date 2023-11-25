package ch_32.common;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Text;

public class PieChart extends Pane implements EventHandler<ActionEvent> {
    public PieChart() {
        repaint();
    }

    private Color[] colors = {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE,
            Color.CYAN, Color.MAGENTA, Color.ORANGE, Color.PINK,
            Color.GRAY};
    private ChartModel model;

    double width = 200;
    double height = 200;

    private void repaint() {
        if (model == null) return;

        double radius = Math.min(width, height) * 0.5 * 0.9;
        double x = width / 2;
        double y = height / 2;

        String[] dataName = model.getDataName();
        double[] data = model.getData();

        double total = 0;
        for (int i = 0; i < data.length; i++) {
            total += data[i];
        }

        double angle1 = 0;
        double angle2 = 0;
        for (int i = 0; i < data.length; i++) {
            angle1 = angle1 + angle2;
            angle2 = Math.ceil(360 * data[i] / total);
            Arc arc = new Arc(x, y, radius, radius, angle1, angle2);
            arc.setType(ArcType.ROUND);
            arc.setFill(colors[i % colors.length]);
            getChildren().add(arc);
            getChildren().add(new Text(
                    width / 2 + radius * Math.cos((angle1 + angle2 / 2) * 2 * Math.PI / 360),
                    height / 2 - radius * Math.sin((angle1 + angle2 / 2) * 2 * Math.PI / 360), dataName[i]));
        }
    }

    public void setModel(ChartModel newModel) {
        model = newModel;
        model.addActionListener(this);
        repaint();
    }

    public ChartModel getModel() {
        return model;
    }

    @Override
    public void handle(ActionEvent e) {
        repaint();
    }
}
