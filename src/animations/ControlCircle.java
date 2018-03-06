// package events;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;

public class ControlCircle extends Application {
	// Create pane
	CirclePaneSimp circlePane = new CirclePaneSimp();
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create HBox and buttons and add buttons to HBox
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		Button btEnlarge = new Button("Enlarge");
		Button btShrink = new Button("Shrink");
		hBox.getChildren().add(btEnlarge);
		hBox.getChildren().add(btShrink);
		
		// create and register handlers
		EnlargeHandler largeHand = new EnlargeHandler();
		btEnlarge.setOnAction(largeHand);
		ShrinkHandler shrinkHand = new ShrinkHandler();
		btShrink.setOnAction(shrinkHand);		

		// Align and place the circle's pane and the buttons
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(circlePane);
		borderPane.setBottom(hBox);
		BorderPane.setAlignment(hBox, Pos.CENTER);

		// Create a scene and place it in the stage
		Scene scene = new Scene(borderPane, 400, 400);
		primaryStage.setTitle("ControlCircle"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
                
                
	}
	
	class EnlargeHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			circlePane.enlarge();
		}	
	}
	
	class ShrinkHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent evet) {
			circlePane.shrink();
		}
	}

	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}

class CirclePaneSimp extends Pane {
	private Circle circle = new Circle(50); 

	public CirclePaneSimp() {
		getChildren().add(circle);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.WHITE);
	}

	public void enlarge() {
		circle.setRadius(circle.getRadius() + 5);
	}

	public void shrink() {
		circle.setRadius(circle.getRadius() > 5 ? 
				circle.getRadius() - 5 : circle.getRadius());
	}
        
        public void moveLeft(){
            circle.setCenterX(circle.getCenterX() > 10 ? circle.getCenterX() - 10 : circle.getCenterX());
        }
        
        public void moveRight(){
            circle.setCenterX(circle.getCenterX() < getWidth() ?  circle.getCenterX() + 10 : circle.getCenterX());
        }
        public void move(double x , double y){
            circle.setCenterX(x);
            circle.setCenterY(y);
        }
}
