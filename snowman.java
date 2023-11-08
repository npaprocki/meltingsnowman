
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class snowman {
	private VBox container1 = new VBox();
	private VBox container2 = new VBox();
	private VBox container4 = new VBox();
	private Pane box = new Pane();
	private VBox container3 = new VBox();
	private HBox eyeBox = new HBox();
	private HBox armBox = new HBox();
	private Circle middle = new Circle();
	private Circle bottom = new Circle();
	private Arc smile = new Arc(30, 20, 15, 15, 0, -180);
	
	public void paint(Pane P, Pane snowmanHolder) {
		
		snowmanHolder.getChildren().clear();
		
		P.getChildren().add(snowmanHolder);

		
		
		container1.setLayoutY(100);
		container1.setLayoutX(200);
		container1.setPrefWidth(120);
		container1.setAlignment(Pos.CENTER);
		container1.setSpacing(-10);
		
		bottom.setRadius(60);
		bottom.setFill(Color.WHITE);
		
		
		middle.setRadius(45);
		middle.setFill(Color.WHITE);
		
		Circle top = new Circle();
		top.setRadius(30);
		top.setFill(Color.WHITE);
		
		
		container1.getChildren().addAll(top, middle, bottom);
		snowmanHolder.getChildren().add(container1);

		Rectangle part1 = new Rectangle(245, 60, 30, 30);
		Rectangle part2 = new Rectangle(235, 90, 50, 15);
		
		container4.setLayoutX(135);
		container4.setLayoutY(65);
		container4.setPrefWidth(250);
		container4.setAlignment(Pos.CENTER);
		container4.getChildren().addAll(part1, part2);
		
		snowmanHolder.getChildren().add(container4);
		
		
		container2.setSpacing(10);
		container2.setLayoutX(255);
		container2.setLayoutY(170);
		container2.setAlignment(Pos.CENTER);
		
		Circle btn1 = new Circle();
		btn1.setRadius(5);
		btn1.setFill(Color.BLACK);
		
		Circle btn2 = new Circle();
		btn2.setRadius(5);
		btn2.setFill(Color.BLACK);
		
		Circle btn3 = new Circle();
		btn3.setRadius(5);
		btn3.setFill(Color.BLACK);
		
		container2.getChildren().addAll(btn1, btn2, btn3);
		snowmanHolder.getChildren().add(container2);
		
		
		
		box.setLayoutY(100);
		box.setLayoutX(200);
		
		
		container3.setLayoutY(115);
		container3.setLayoutX(230);
		container3.setAlignment(Pos.CENTER);
		
		
		eyeBox.setPrefWidth(60);
		eyeBox.setSpacing(15);
		eyeBox.setAlignment(Pos.CENTER);
		
		Circle eye1 = new Circle();
		eye1.setRadius(5);
		eye1.setFill(Color.BLACK);
		
		Circle eye2 = new Circle();
		eye2.setRadius(5);
		eye2.setFill(Color.BLACK);
		
		eyeBox.getChildren().addAll(eye1, eye2);
		
		Polygon nose = new Polygon();
		
		nose.getPoints().addAll(30.0, 10.0, 10.0, 
				15.0, 30.0, 20.0);
		
		nose.setFill(Color.ORANGE);
		
		
		smile.setType(ArcType.OPEN);
		
		box.getChildren().addAll(eyeBox, smile, nose);
		container3.getChildren().add(box);
		
		snowmanHolder.getChildren().add(container3);
		

		
		armBox.setLayoutY(200);
		armBox.setLayoutX(180);
		armBox.setSpacing(90);
		
		Line armL = new Line();
		armL.setStartX(0);
		armL.setStartY(0);
		armL.setEndX(-30);
		armL.setEndY(30);
		
		armL.setStroke(Color.SADDLEBROWN);
		armL.setStrokeWidth(3);
		
		Line armR = new Line(0, 0, 20, 20);
		armR.setStartX(0);
		armR.setStartY(0);
		armR.setEndX(30);
		armR.setEndY(30);
		
		armR.setStroke(Color.SADDLEBROWN);
		armR.setStrokeWidth(3);
		
		armBox.getChildren().addAll(armL, armR);
		
		snowmanHolder.getChildren().add(armBox);
		

		Rectangle ground = new Rectangle();
		ground.setX(150);
		ground.setY(350);
		ground.setWidth(200);
		ground.setHeight(10);
		
		ground.setFill(Color.rgb(106, 171, 250));
		
		snowmanHolder.getChildren().add(ground);
		
	}
	
	public void remove(int numGuessLeft) {
		
		switch (numGuessLeft) {
			case 5: container4.getChildren().clear(); break;
			case 4: container2.getChildren().clear(); break;
			case 3: armBox.getChildren().remove(1); break;
			case 2: armBox.getChildren().clear(); break;
			case 1: container1.getChildren().remove(bottom); break;
			case 0: container1.getChildren().remove(middle); 
					container3.getChildren().clear();
					eyeBox.getChildren().clear();
					box.getChildren().remove(smile);
					
					Circle eye1 = new Circle();
					eye1.setRadius(5);
					eye1.setFill(Color.BLACK);
					
					Circle eye2 = new Circle();
					eye2.setRadius(5);
					eye2.setFill(Color.BLACK);
					
					eyeBox.getChildren().addAll(eye1, eye2);
					
					Polygon nose = new Polygon();
					
					nose.getPoints().addAll(30.0, 10.0, 10.0, 
							15.0, 30.0, 20.0);
					
					nose.setFill(Color.ORANGE);
					
					Arc smile = new Arc(30, 30, 15, 15, 0, 180);
					smile.setType(ArcType.OPEN);
					
					box.getChildren().addAll(smile, nose);
					container3.getChildren().add(box);
					
			
			break;
			}
		}
	
	public void clear (Pane P) {
		
		container1.getChildren().clear();
		container2.getChildren().clear();
		container4.getChildren().clear();
		box.getChildren().clear();
		container3.getChildren().clear();
		eyeBox.getChildren().clear();
		armBox.getChildren().clear();
		
	}
		
	}
	



