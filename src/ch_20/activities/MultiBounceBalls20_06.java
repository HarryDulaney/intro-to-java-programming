package ch_20.activities;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MultiBounceBalls20_06 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		MultiBallPane mbPane = new MultiBallPane();

		Button addButton = new Button("+");
		Button subtractButton = new Button("-");

		HBox hBox = new HBox(10);
		hBox.getChildren().addAll(addButton, subtractButton);
		hBox.setAlignment(Pos.CENTER);

		addButton.setOnAction(ev1 -> {
			mbPane.addOne();
		});
		subtractButton.setOnAction(ev2 -> {
			mbPane.removeOne();
		});

		// Pause and resume animation
		mbPane.setOnMousePressed(e -> mbPane.pause());
		mbPane.setOnMouseReleased(e -> mbPane.play());
		// Use a scroll bar to control animation speed
		ScrollBar sbSpeed = new ScrollBar();
		sbSpeed.setMax(20);
		sbSpeed.setValue(10);
		mbPane.rateProperty().bind(sbSpeed.valueProperty());

		BorderPane pane = new BorderPane();
		pane.setCenter(mbPane);
		pane.setTop(sbSpeed);
		pane.setBottom(hBox);
		// Create a scene and place the pane in the stage
		Scene scene = new Scene(pane, 450, 350);
		primaryStage.setResizable(false);
		primaryStage.setTitle("The Bouncing Ballz"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

	}

	public static void main(String[] args) {
		launch(args);
	}

	private class MultiBallPane extends Pane {
		private Timeline animation;

		MultiBallPane() {
			animation = new Timeline(new KeyFrame(Duration.millis(50), event -> moveBall()));
			animation.setCycleCount(Timeline.INDEFINITE);
			animation.play();
		}

		public void addOne() {
			Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
			getChildren().add(new Ball(30, 30, 20, color));
		}

		public void removeOne() {
			if (getChildren().size() > 0) {
				getChildren().remove(getChildren().size() - 1);
			}
		}

		public void play() {
			animation.play();
		}

		public void pause() {
			animation.pause();
		}

		public void increaseSpeed() {
			animation.setRate(animation.getRate() + 0.1);
		}

		public void decreaseSpeed() {
			animation.setRate(animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
		}

		public DoubleProperty rateProperty() {
			return animation.rateProperty();
		}

		protected void moveBall() {
			for (Node node : this.getChildren()) {
				Ball ball = (Ball) node;
				// Calculate boundaries 
				if (ball.getCenterX() < ball.getRadius() || ball.getCenterX() > getWidth() - ball.getRadius()) {
					ball.dx *= -1; // Change ball move direction
				}
				if (ball.getCenterY() < ball.getRadius() || ball.getCenterY() > getHeight() - ball.getRadius()) {
					ball.dy *= -1; // Change ball move direction
				}
				//Move ball forward
				ball.setCenterX(ball.dx + ball.getCenterX());
				ball.setCenterY(ball.dy + ball.getCenterY());
			}
		}

	}

	class Ball extends Circle {
		private double dx = 1, dy = 1;

		Ball(double x, double y, double radius, Color color) {
			super(x, y, radius);
			setFill(color);
		}
	}
}
