package View;

import java.util.Vector;

import Model.Participants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Competition {

	private TextField [] namesFields;
	private TextField [] namesFields2;
	private TextField [] namesFields3;
	private TextField winner;
	private BorderPane bp;
	private Button game1;
	private Button game2;
	private Button game3;
	private Button game4;
	private Button game5;
	private Button game6;
	private Button game7;
	private Label winnerLabel;
	private Label quarter;
	private Label semi;
	private Label Final;
	private VBox set1;
	private VBox set2;
	private VBox participantsNames;
	private VBox participantsNames2;
	private VBox participantsNames3;
	private VBox winnerBox;
	private HBox left;
	private HBox center;
	private HBox right;
	private HBox stages;
	
	public Competition(Stage primaryStage) {
		
		game1=new Button();
		game2=new Button();
		game3=new Button();
		game4=new Button();
		game5=new Button();
		game6=new Button();
		game7=new Button();
		
		game5.setDisable(true);
		game6.setDisable(true);
		game7.setDisable(true);

		
		game1.setPrefSize(150, 25);
		game2.setPrefSize(150, 25);
		game3.setPrefSize(150, 25);
		game4.setPrefSize(150, 25);
		game5.setPrefSize(150, 25);
		game6.setPrefSize(150, 25);
		game7.setPrefSize(150, 25);
		
		game1.setText("Play A Game");
		game2.setText("Play A Game");
		game3.setText("Play A Game");
		game4.setText("Play A Game");
		game5.setText("Play A Game");
		game6.setText("Play A Game");
		game7.setText("Play A Game");
		
		game1.setFont(Font.font("Segoe", FontWeight.BOLD, 16));
		game2.setFont(Font.font("Segoe", FontWeight.BOLD, 16));
		game3.setFont(Font.font("Segoe", FontWeight.BOLD, 16));
		game4.setFont(Font.font("Segoe", FontWeight.BOLD, 16));
		game5.setFont(Font.font("Segoe", FontWeight.BOLD, 16));
		game6.setFont(Font.font("Segoe", FontWeight.BOLD, 16));
		game7.setFont(Font.font("Segoe", FontWeight.BOLD, 16));

		game1.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		game2.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		game3.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		game4.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		game5.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		game6.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		game7.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");

		winnerLabel=new Label("Winner!");
		winnerLabel.setFont(Font.font("Segoe", FontWeight.BOLD, 25));
		winnerLabel.setTextFill(Color.web("#f3bb05"));
		
		quarter=new Label("Quarter Final");
		quarter.setFont(Font.font("Segoe", FontWeight.BOLD, 25));
		quarter.setTextFill(Color.web("#50a08d"));

		semi=new Label("Semi Final");
		semi.setFont(Font.font("Segoe", FontWeight.BOLD, 25));
		semi.setTextFill(Color.web("#50a08d"));
		
		Final=new Label("Final");
		Final.setFont(Font.font("Segoe", FontWeight.BOLD, 25));
		Final.setTextFill(Color.web("#50a08d"));
		
		set1=new VBox();
		set2=new VBox();
		
		set1.getChildren().addAll(game1,game2,game3,game4);
		set2.getChildren().addAll(game5,game6);
		set1.setSpacing(110);
		set2.setSpacing(220);
		
		namesFields=new TextField[8];
		namesFields2=new TextField[4];
		namesFields3=new TextField[2];
		winner=new TextField();
		winner.setStyle("-fx-background-color: #f3bb05;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		winner.setFont(Font.font("Segoe", FontWeight.BOLD, 24));
		winner.setMaxSize(230, 30);
		winner.setDisable(true);

		for (int i = 0; i < namesFields.length; i++) {
			namesFields[i]=new TextField();
			namesFields[i].setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
			namesFields[i].setFont(Font.font("Segoe", FontWeight.BOLD, 24));
			namesFields[i].setMaxSize(230, 30);
			namesFields[i].setDisable(true);
		}
		for (int i = 0; i < namesFields2.length; i++) {
			namesFields2[i]=new TextField();
			namesFields2[i].setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
			namesFields2[i].setFont(Font.font("Segoe", FontWeight.BOLD, 24));
			namesFields2[i].setMaxSize(230, 30);
			namesFields2[i].setDisable(true);
		}
		for (int i = 0; i < namesFields3.length; i++) {
			namesFields3[i]=new TextField();
			namesFields3[i].setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
			namesFields3[i].setFont(Font.font("Segoe", FontWeight.BOLD, 24));
			namesFields3[i].setMaxSize(230, 30);
			namesFields3[i].setDisable(true);
		}
		
		participantsNames=new VBox();
		participantsNames.getChildren().addAll(namesFields);
		participantsNames.setSpacing(20);
		participantsNames2=new VBox();
		participantsNames2.getChildren().addAll(namesFields2);
		participantsNames2.setSpacing(95);
		participantsNames3=new VBox();
		participantsNames3.getChildren().addAll(namesFields3);
		participantsNames3.setSpacing(205);
		
		winnerBox=new VBox();
		winnerBox.getChildren().addAll(winnerLabel,winner);
		winnerBox.setMargin(winnerLabel, new Insets(0,0,30,65));
		
		stages=new HBox();
		stages.getChildren().addAll(quarter,semi,Final);
		stages.setSpacing(410);
		
		left=new HBox();
		left.getChildren().addAll(participantsNames,set1);
		left.setMargin(set1, new Insets(50,0,0,80));
		
		center=new HBox();
		center.getChildren().addAll(participantsNames2,set2,participantsNames3);
		center.setMargin(set2, new Insets(95,0,0,80));
		center.setMargin(participantsNames2, new Insets(15,0,0,0));
		center.setMargin(participantsNames3, new Insets(90,0,0,80));
		
		right=new HBox();
		right.getChildren().addAll(game7,winnerBox);
		right.setMargin(game7, new Insets(5,60,0,60));
		right.setMargin(winnerBox, new Insets(-65,0,00,0));
		
		bp=new BorderPane();
		bp.setTop(stages);
		bp.setLeft(left);
		bp.setCenter(center);
		bp.setRight(right);
		
		bp.setMargin(stages, new Insets(50,0,0,70));
		bp.setMargin(left, new Insets(100,0,0,30));
		bp.setMargin(center, new Insets(130,0,0,100));
		bp.setMargin(right, new Insets(350,60,0,0));

		bp.styleProperty().set("-fx-background-color: #f3eace");	

		
		Rectangle2D screen = Screen.getPrimary().getBounds();
		Scene scene = new Scene(bp, screen.getMaxX()-50, screen.getMaxY()-130);
		
		primaryStage.setScene(scene);
		primaryStage.setFullScreen(false);
		primaryStage.show();
	}
	
	public void setParticipants(Vector<Participants> part){
		for (int i = 0; i < namesFields.length; i++) {
			namesFields[i].setText(part.get(i).getName());
		}
	}
	
	public void updateWinner(int i,Participants winner) {
		if(i==1) {
			namesFields2[0].setText(winner.getName());
			game1.setDisable(true);
			if(!namesFields2[1].getText().isEmpty()) {
				game5.setDisable(false);
			}
		}
		else if(i==2) {
			namesFields2[1].setText(winner.getName());
			game2.setDisable(true);
			if(!namesFields2[0].getText().isEmpty()) {
				game5.setDisable(false);
			}
		}
		else if(i==3) {
			namesFields2[2].setText(winner.getName());
			game3.setDisable(true);
			if(!namesFields2[3].getText().isEmpty()) {
				game6.setDisable(false);
			}
		}
		else if(i==4) {
			namesFields2[3].setText(winner.getName());
			game4.setDisable(true);
			if(!namesFields2[2].getText().isEmpty()) {
				game6.setDisable(false);
			}
		}
		else if(i==5) {
			namesFields3[0].setText(winner.getName());
			game5.setDisable(true);
			if(!namesFields3[1].getText().isEmpty()) {
				game7.setDisable(false);
			}
		}
		else if(i==6) {
			namesFields3[1].setText(winner.getName());
			game6.setDisable(true);
			if(!namesFields3[0].getText().isEmpty()) {
				game7.setDisable(false);
			}
		}
		else {
			this.winner.setText(winner.getName());
			game7.setDisable(true);
		}
	}


	public void addEventToPlayGame1(EventHandler<ActionEvent> playGame1Pressed) {
		game1.setOnAction(playGame1Pressed);
	}
	
	public void addEventToPlayGame2(EventHandler<ActionEvent> playGame2Pressed) {
		game2.setOnAction(playGame2Pressed);
	}
	
	public void addEventToPlayGame3(EventHandler<ActionEvent> playGame3Pressed) {
		game3.setOnAction(playGame3Pressed);
	}
	
	public void addEventToPlayGame4(EventHandler<ActionEvent> playGame4Pressed) {
		game4.setOnAction(playGame4Pressed);
	}

	public void addEventToPlayGame5(EventHandler<ActionEvent> playGame5Pressed) {
		game5.setOnAction(playGame5Pressed);
	}

	public void addEventToPlayGame6(EventHandler<ActionEvent> playGame6Pressed) {
		game6.setOnAction(playGame6Pressed);
	}

	public void addEventToPlayGame7(EventHandler<ActionEvent> playGame7Pressed) {
		game7.setOnAction(playGame7Pressed);
	}


}
