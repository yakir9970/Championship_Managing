package View;

import java.awt.Window;
import java.util.Vector;

import Model.BasketBallGame;
import Model.Game;
import Model.Participants;
import Model.SoccerGame;
import Model.TennisGame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class playGame {

	private Participants player1, player2;
	private String gameType;
	private BorderPane bp;
	private Label first, second, type;
	private Button done;
	private VBox names;
	private HBox firstResults, secondResults;
	private VBox results;
	private HBox center;
	private TextField[] firstArray;
	private TextField[] secondArray;
	private Game game;
	private Stage stage;
	private boolean tied;
	private boolean lastRound;

	public playGame(Stage primaryStage, Vector<Participants> players, String gameType) {
		player1 = players.get(0);
		player2 = players.get(1);
		this.gameType = gameType;
		first = new Label(player1.getName());
		second = new Label(player2.getName());
		type = new Label(gameType + " Game");
		type.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
		done = new Button("Done");
		done.setPrefSize(260, 20);
		done.setFont(Font.font("Segoe", FontWeight.BOLD, 30));
		done.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		names = new VBox();
		names.getChildren().addAll(first, second);
		first.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
		second.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
		firstArray = new TextField[5];
		secondArray = new TextField[5];
		for (int i = 0; i < firstArray.length; i++) {
			firstArray[i] = new TextField();
			firstArray[i].setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
			firstArray[i].setFont(Font.font("Segoe", FontWeight.BOLD, 14));
			firstArray[i].setPrefSize(50, 45);
			secondArray[i] = new TextField();
			secondArray[i]
					.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
			secondArray[i].setFont(Font.font("Segoe", FontWeight.BOLD, 14));
			secondArray[i].setPrefSize(50, 45);
		}
		firstResults = new HBox(firstArray);
		secondResults = new HBox(secondArray);
		results = new VBox();
		results.getChildren().addAll(firstResults, secondResults);
		center = new HBox();
		center.getChildren().addAll(names, results);

		if (gameType == "BasketBall") {
			firstArray[4].setVisible(false);
			secondArray[4].setVisible(false);
		} else if (gameType == "Soccer") {
			firstArray[2].setVisible(false);
			secondArray[2].setVisible(false);
			firstArray[3].setVisible(false);
			secondArray[3].setVisible(false);
			firstArray[4].setVisible(false);
			secondArray[4].setVisible(false);
		}

		bp = new BorderPane();

		results.setSpacing(50);
		names.setSpacing(80);
		firstResults.setSpacing(20);
		secondResults.setSpacing(20);
		center.setSpacing(50);

		bp.setTop(type);
		bp.setCenter(center);
		bp.setBottom(done);

		bp.setMargin(center, new Insets(30, 0, 0, 30));
		bp.setMargin(type, new Insets(20, 0, 0, 60));
		bp.setMargin(done, new Insets(0, 0, 110, 125));
		bp.styleProperty().set("-fx-background-color: #f3eace");

		Scene scene = new Scene(bp, 500, 500);

		primaryStage.setScene(scene);
		primaryStage.setFullScreen(false);
		primaryStage.show();
		stage = primaryStage;
	}

	public Participants done() {
		if (gameType == "Tennis") {
			game = new TennisGame(player1, player2);
			Participants winner;
			player1.resetResult();
			player2.resetResult();
			for (int i = 0; i < firstArray.length; i++) {
					if (firstArray[i].getText().isEmpty() || secondArray[i].getText().isEmpty()) {
						player1.resetResult();
						player2.resetResult();
						return null;
					}
					player1.setResults(Integer.parseInt(firstArray[i].getText()));
					player2.setResults(Integer.parseInt(secondArray[i].getText()));
					
					if(i==2) {
						winner= game.winner();
						if(game.isTechnicalWin()&&winner!=null) {
							stage.close();
							winner.setWins();
							return winner;
						}						
					}
			}
			
			stage.close();
			game.resetWins();
			winner= game.winner();
			winner.setWins();
			return winner;
		} else if (gameType == "BasketBall") {
			game = new BasketBallGame(player1, player2);
			player1.resetResult();
			player2.resetResult();
			for (int i = 0; i < firstArray.length; i++) {
				if (firstArray[i].isVisible()) {
					if (firstArray[i].getText().isEmpty() || secondArray[i].getText().isEmpty()) {
						player1.resetResult();
						player2.resetResult();
						return null;
					}
					player1.setResults(Integer.parseInt(firstArray[i].getText()));
					player2.setResults(Integer.parseInt(secondArray[i].getText()));
				}
			}
			stage.close();
			return game.winner();

		} else {
			game = new SoccerGame(player1, player2);
			player1.resetResult();
			player2.resetResult();
			for (int i = 0; i < firstArray.length; i++) {
				if (firstArray[i].isVisible()) {
					if (firstArray[i].getText().isEmpty() || secondArray[i].getText().isEmpty()) {
						player1.resetResult();
						player2.resetResult();
						return null;
					}
					player1.setResults(Integer.parseInt(firstArray[i].getText()));
					player2.setResults(Integer.parseInt(secondArray[i].getText()));
				}
			}
			Participants winner = game.winner();
			if (winner.getName() == "-1") {
				if (lastRound) {
					stage.close();
					return player1;
				}
				return winner;
			} else {
				stage.close();
				return winner;
			}
		}
	}

	public boolean getTied() {
		return tied;
	}
	
	public int getTie() {
		return game.getTie();
	}

	public boolean getPenalties() {
		return game.getPenalties();
	}

	public void setLastRound() {
		lastRound = true;

	}

	public void firstTie() {
		Alert msg = new Alert(AlertType.ERROR);
		msg.setContentText("Must fill Over Time Results!");
		msg.show();
		firstArray[4].setVisible(true);
		secondArray[4].setVisible(true);
		firstArray[0].setDisable(true);
		firstArray[1].setDisable(true);
		secondArray[0].setDisable(true);
		secondArray[1].setDisable(true);
		tied = true;
	}

	public void secondTie() {
		Alert msg = new Alert(AlertType.ERROR);
		msg.setContentText("Must fill Penalties Results!");
		msg.show();
		for (int i = 0; i < firstArray.length; i++) {
			firstArray[i].setDisable(false);
			secondArray[i].setDisable(false);
			firstArray[i].clear();
			secondArray[i].clear();
			firstArray[i].setVisible(true);
			secondArray[i].setVisible(true);
		}
		game.setPenalties();
	}

	public void addEventToDone1(EventHandler<ActionEvent> donePressed1) {
		done.setOnAction(donePressed1);
	}

	public void addEventToDone2(EventHandler<ActionEvent> donePressed2) {
		done.setOnAction(donePressed2);
	}

	public void addEventToDone3(EventHandler<ActionEvent> donePressed3) {
		done.setOnAction(donePressed3);
	}

	public void addEventToDone4(EventHandler<ActionEvent> donePressed4) {
		done.setOnAction(donePressed4);
	}

	public void addEventToDone5(EventHandler<ActionEvent> donePressed5) {
		done.setOnAction(donePressed5);
	}

	public void addEventToDone6(EventHandler<ActionEvent> donePressed6) {
		done.setOnAction(donePressed6);
	}

	public void addEventToDone7(EventHandler<ActionEvent> donePressed7) {
		done.setOnAction(donePressed7);
	}

}
