	import java.io.FileNotFoundException;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Collections;
	import java.util.List;

	import javafx.geometry.Pos;
	import javafx.scene.control.Alert;
	import javafx.scene.control.Button;
	import javafx.scene.control.ContentDisplay;
	import javafx.scene.control.Label;
	import javafx.scene.control.Menu;
	import javafx.scene.control.MenuBar;
	import javafx.scene.control.MenuItem;
	import javafx.scene.control.TextField;
	import javafx.scene.control.Alert.AlertType;
	import javafx.scene.layout.Background;
	import javafx.scene.layout.BackgroundFill;
	import javafx.scene.layout.HBox;
	import javafx.scene.layout.Pane;
	import javafx.scene.layout.VBox;
	import javafx.scene.paint.Color;
	import javafx.scene.text.Text;
	


public class DisappearingSnowmanGame {


		private int wordSizeLower = 0;
		private int wordSizeUpper = 5;

		private wordBank bank;
		
		private String word;

		private ArrayList<String> list = new ArrayList<String>();

		private Label[] blanks = new Label[23];
		
		private Label numberGuess = new Label("6");
		
		private VBox blankBoxCenter = new VBox();

		private HBox blankBox = new HBox();
		
		private snowman makeSnowman;
		
		private int i = 0;
		
		private String guessedLetters = "";
		

		public void paint(Pane P, snowman input, Pane snowmanHolder) throws FileNotFoundException {

			makeSnowman = input;
			
			blankBoxCenter.setLayoutY(300);
			blankBoxCenter.setPrefWidth(1000);
			blankBoxCenter.setAlignment(Pos.CENTER);
			
			blankBox.setLayoutY(300);
			blankBox.setPrefWidth(1000);
			blankBox.setSpacing(40);
			blankBox.setAlignment(Pos.CENTER);
			
			menu(P, snowmanHolder);
			makeBank();
			displayWord(P, snowmanHolder);
			
		}

		public void menu(Pane P, Pane snowmanHolder) {
			//default level
			
			HBox menuBox = new HBox();


			MenuBar mb = new MenuBar();

			Background background1 = new Background(new BackgroundFill(Color.LIGHTGREY, null, null));

			menuBox.setBackground(background1);
		//	menuBox.setPadding(new Insets(10,10,10,10));
			menuBox.setPrefWidth(1000);

			Menu level = new Menu("Difficulty");
			Menu systemFN = new Menu("Game Options");


			//system Functions
		       MenuItem exit = new MenuItem("Exit");

		       exit.setOnAction(e -> {
		    	   
		    	   System.exit(0);

		       });

		       MenuItem newWord = new MenuItem("Generate New Word");

		       newWord.setOnAction(e -> {

		    	   displayWord(P, snowmanHolder);

		       });
		       


			//easy
		       MenuItem easyMode = new MenuItem("Easy");

		       easyMode.setOnAction(e -> {

		       wordSizeLower = 0; wordSizeUpper = 5;
		       displayWord(P, snowmanHolder);

		       });

		   //medium
		       MenuItem mediumMode = new MenuItem("Medium");

		       mediumMode.setOnAction(e -> {

		       wordSizeLower = 6; wordSizeUpper = 10;
		       displayWord(P, snowmanHolder);

		       });

		   //hard
		       MenuItem hardMode = new MenuItem("Hard");

		       hardMode.setOnAction(e -> {

		       wordSizeLower = 11; wordSizeUpper = 23;
		       displayWord(P, snowmanHolder);


		       });


		  // add menu items to menu
		   level.getItems().addAll(easyMode, mediumMode, hardMode);
		   systemFN.getItems().addAll(newWord, exit);

		   mb.getMenus().addAll(systemFN, level);


		   menuBox.getChildren().add(mb);



		   P.getChildren().add(menuBox);
		}

		public void makeBank() throws FileNotFoundException {
			

			bank = new wordBank();
				
			 	
			list.addAll(bank.createWordBank("WordList.txt"));
			
		}
		
		public void makeBlanks() {
			for (int index = 0; index < 23; index++) {
				Label lb1 = new Label("");
				lb1.setAlignment(Pos.CENTER);
				lb1.setPrefWidth(20);
				lb1.setStyle("-fx-border-style: hidden hidden solid hidden; -fx-border-width: 3; -fx-border-color: black;");
				blanks[index] = lb1;
			}
		}

		public void reset(Pane P, Pane snowmanHolder) {
			//reset values
			i = 0;
			guessedLetters = "";
			
			makeBlanks();
			
			makeSnowman.clear(snowmanHolder);
			
			P.getChildren().clear();
			blankBoxCenter.getChildren().clear();
			
			menu(P, snowmanHolder);
			
			makeSnowman.paint(P, snowmanHolder);
			
			
			guessBlock(P, blankBoxCenter);
			
		}
		
		public void displayWord(Pane P, Pane snowmanHolder) {
			reset(P, snowmanHolder);
			
			numberGuess.setText("6");
			
			//new word
			word = bank.randomWord(wordSizeLower, wordSizeUpper).toUpperCase();
			
			//clear spaces
			blankBox.getChildren().clear();
			
			for (int index = 0; index < word.length(); index++) {

				Label lb2 = blanks[index];
				
				//center blanks
				blankBox.getChildren().add(lb2);
				
			}
			
			//add blanks
			blankBoxCenter.getChildren().add(blankBox);
			P.getChildren().add(blankBox);
			
			System.out.print(word + " ");
			

		}

		public void guessBlock(Pane P, VBox blankBoxCenter) {
			
			
			
			TextField guess = new TextField();
			guess.setPrefWidth(100);
			guess.setAlignment(Pos.CENTER);
			
			Background background1 = new Background(new BackgroundFill(Color.LIGHTGREY, null, null));
			
			guess.setBackground(background1);
			
			VBox box2 = new VBox();
			box2.setLayoutY(400);
			box2.setAlignment(Pos.CENTER);
			box2.setSpacing(10);
			
			VBox center = new VBox();
			center.setAlignment(Pos.CENTER);
			center.setLayoutY(400);
			center.setLayoutX(450);
			
			
			Label lb2 = new Label("Remaining Guesses");
			lb2.setContentDisplay(ContentDisplay.TOP);
			
			numberGuess.setBackground(background1);
			numberGuess.setAlignment(Pos.CENTER);
			numberGuess.setPrefSize(100, 20);
			
			box2.getChildren().addAll(lb2, numberGuess);
			center.getChildren().add(box2);
			
			
			
			Label lb1 = new Label("Enter Guess:");
			lb1.setContentDisplay(ContentDisplay.TOP);
			
			Text letter = new Text("");
			
			guess.setOnAction(e -> {
				String lettertoString = (guess.getText()).toUpperCase();
				letter.setText(lettertoString);
			});
			
			Button makeGuess = new Button("Guess");
			
			Alert missingInfo = new Alert (AlertType.ERROR, "Please make to type a value and hit enter.");
			Alert wrongInput = new Alert (AlertType.ERROR, "Please make to only guess letters!");
			
			makeGuess.setOnAction(e -> {
				
				try {
					if( Character.isAlphabetic((letter.getText()).charAt(0)) == true) {
						makeGuess(P, ((letter.getText()).charAt(0)));
						guess.setText("");
					}
					else {
						wrongInput.show();
						guess.setText("");
					}

				}
				catch (IndexOutOfBoundsException ex) {
					missingInfo.show();
				}
				
			});
			
			
			VBox box1 = new VBox();
			box1.setLayoutY(500);
			box1.setPrefSize(100, 500);
			box1.setAlignment(Pos.CENTER);
			box1.setSpacing(10);
			
			HBox contentBox = new HBox();
			contentBox.setAlignment(Pos.CENTER);
			contentBox.setLayoutY(400);
			contentBox.setPrefWidth(100);
			
			box1.getChildren().addAll(lb1,guess, makeGuess);
			contentBox.getChildren().add(box1);
			blankBoxCenter.getChildren().add(contentBox);
			P.getChildren().addAll(blankBoxCenter, center);
			
		}
		
		public void makeGuess(Pane P, char letter) {
			
			boolean valid = false;

			//make random word to array
			char[] wordLetters = word.toCharArray();
		
			
			
			for (int index = 0; index < wordLetters.length; index++) {
				
				if(wordLetters[index] == letter) {
					valid = true;
					i++;

					
					guessedLetters = guessedLetters + letter + " ";
					
					
					updateBlanks(index, letter);
				}
				
			}
		
			
			if (valid == false) {
				numberGuess.setText(String.valueOf(Integer.parseInt(numberGuess.getText())-1));
				makeSnowman.remove(Integer.parseInt(numberGuess.getText()));
				
			}
			
			checkStatus(P);
			
		}

		public void updateBlanks(int index, char letter) {
		
			String letterToString = String.valueOf(letter);
			
			blanks[index].setText(letterToString);
			

		}

		public void checkStatus(Pane P) { 
			//EOG
			Alert endOfGameL = new Alert (AlertType.INFORMATION, "Sorry, you lost. The word was " + word);
			Alert endOfGameW = new Alert (AlertType.INFORMATION, "You Win!");
			
			if (Integer.parseInt(numberGuess.getText()) == 0) {
				endOfGameL.show();
			}
			
			//make win
			if (i == word.length()) {
				endOfGameW.show();
				
			}
		
			
		}
		

	}

