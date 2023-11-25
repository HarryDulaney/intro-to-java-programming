package ch_32.common;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class BarChart extends Pane implements EventHandler<ActionEvent> {
  Color[] colors = {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE,
    Color.CYAN, Color.MAGENTA, Color.ORANGE, Color.PINK,
    Color.GRAY};
  private ChartModel model;

  public BarChart() {
    repaint();
  }

  double width = 200;
  double height = 200;
  
  public void repaint() {
   if (model == null) return;

    String[] dataName = model.getDataName();
    double[] data = model.getData();

    // Find the maximum value in the data
    double max = data[0];
    for (int i=1; i<data.length; i++)
      max = Math.max(max, data[i]);

    double barWidth = (width - 10.0) / data.length - 10;
    double maxBarHeight = height - 30;

    getChildren().add(new Line(5, height - 10, width - 5, height - 10));

    int x = 15;
    for (int i = 0; i < data.length; i++) {
      double newHeight = maxBarHeight * data[i] / max;
      double y = height - 10 - newHeight;
      Rectangle rectangle = new Rectangle(x, y, barWidth, newHeight);
      rectangle.setFill(colors[i % colors.length]);
     
      getChildren().add(rectangle);
      getChildren().add(new Text(x, y - 7, dataName[i]));
      x += barWidth + 10;
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
