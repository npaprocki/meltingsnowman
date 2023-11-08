import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class main extends Application {

	public static void main(String[] args) {
		 launch(args);
	}
	
	public void start(Stage primaryStage) throws FileNotFoundException {
		Pane canvas = new Pane();
		Scene scene = new Scene(canvas, 1000, 720, Color.TAN);
		Stage stage = new Stage();
		DisappearingSnowmanGame ui = new DisappearingSnowmanGame();
		snowman makeSnowman = new snowman();
		
		Pane snowmanHolder = new Pane();
		snowmanHolder.setLayoutY(350);
		snowmanHolder.setLayoutX(-100);

	
		makeSnowman.paint(canvas, snowmanHolder);
		ui.paint(canvas, makeSnowman, snowmanHolder);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.setTitle("Melting Snowman");
		stage.show();
		
	}

}
