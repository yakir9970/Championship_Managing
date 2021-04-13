package View;

import Model.Model;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class View {
	private Stage stage;
	private Button addParticipants;
	private Button startChampionship;
	private TextField nameField;
	private Text participantName;
	private RadioButton tennis;
	private RadioButton basketBall;
	private RadioButton soccer;
	private VBox participantsNames;
	private VBox gameType;
	private VBox center;
	private HBox name;
	private HBox buttons;
	private ToggleGroup radioToggleGroup;
	private Label champioship;
	
	private TextField [] namesFields;
	private int numOfPlayers=0;

	private BorderPane bp;
	
	public View(Stage primaryStage) {
		champioship=new Label("Championship");
		champioship.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
		champioship.setTextFill(Color.web("#50a08d"));
		addParticipants=new Button("Add Participant");
		addParticipants.setPrefSize(260, 20);
		addParticipants.setFont(Font.font("Segoe", FontWeight.BOLD, 24));
		addParticipants.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		startChampionship=new Button("Start Championship");
		startChampionship.setFont(Font.font("Segoe", FontWeight.BOLD, 24));
		startChampionship.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		participantName=new Text("Participant Name:");
		participantName.setFont(Font.font("Segoe", FontWeight.BOLD, 24));
		nameField=new TextField();
		nameField.setFont(Font.font("Segoe", FontWeight.BOLD, 24));
		nameField.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		tennis=new RadioButton("Tennis");
		tennis.setFont(Font.font("Segoe", FontWeight.BOLD, 24));
		basketBall=new RadioButton("BasketBall");
		basketBall.setFont(Font.font("Segoe", FontWeight.BOLD, 24));
		soccer=new RadioButton("Soccer");
		soccer.setFont(Font.font("Segoe", FontWeight.BOLD, 24));
		namesFields=new TextField[8];
		for (int i = 0; i < namesFields.length; i++) {
			namesFields[i]=new TextField();
			namesFields[i].setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
			namesFields[i].setFont(Font.font("Segoe", FontWeight.BOLD, 24));
			namesFields[i].setMaxSize(300, 30);
		}
		participantsNames=new VBox();
		participantsNames.getChildren().addAll(namesFields);
		participantsNames.setSpacing(20);
		gameType=new VBox();
		gameType.getChildren().addAll(tennis,basketBall,soccer);
		gameType.setSpacing(10);
		name=new HBox();
		name.getChildren().addAll(participantName,nameField);
		name.setSpacing(40);
		buttons=new HBox();
		buttons.getChildren().addAll(addParticipants,startChampionship);
		buttons.setSpacing(40);
		center=new VBox();
		center.getChildren().addAll(name,buttons);
		center.setSpacing(40);
		// set disable
			setDisable();
			
		radioToggleGroup=new ToggleGroup();
		tennis.setToggleGroup(radioToggleGroup);
		soccer.setToggleGroup(radioToggleGroup);
		basketBall.setToggleGroup(radioToggleGroup);
		bp=new BorderPane();
		bp.setLeft(participantsNames);
		bp.setRight(gameType);
		bp.setCenter(center);
		bp.setTop(champioship);
				
		bp.setMargin(participantsNames, new Insets(80));
		bp.setMargin(gameType, new Insets(250,250,0,0));
		bp.setMargin(center, new Insets(250,0,0,200));
		bp.setMargin(champioship, new Insets(20,0,0,760));
		bp.styleProperty().set("-fx-background-color: #f3eace");	

		Rectangle2D screen = Screen.getPrimary().getBounds();
		Scene scene = new Scene(bp, screen.getMaxX()-50, screen.getMaxY()-130);
		stage=primaryStage;
		stage.setScene(scene);
		stage.setFullScreen(false);
		stage.show();
	}
	
	public void addEnable() {
		if(numOfPlayers!=8) {
		addParticipants.setDisable(false);
		nameField.setDisable(false);
		}
	}
	
	public void setDisable() {
		addParticipants.setDisable(true);
		startChampionship.setDisable(true);
		nameField.setDisable(true);
		participantsNames.setDisable(true);
	}
	
	
	public void addChangeListenerToToggleGroup(ChangeListener<Toggle> chl) {
		radioToggleGroup.selectedToggleProperty().addListener(chl);
	}

	public void addEventToAddParticipants(EventHandler<ActionEvent> addParticipantsPressed) {
		addParticipants.setOnAction(addParticipantsPressed);
	}
	
	public void addEventToStartChampionship(EventHandler<ActionEvent> startChampionshipPressed) {
		startChampionship.setOnAction(startChampionshipPressed);
	}


	public void addParticipants(Model theModel) {
		if(!nameField.getText().isEmpty()) {
		String name=nameField.getText();
		numOfPlayers++;
		namesFields[numOfPlayers-1].setText(name);
		theModel.addParticipant(namesFields[numOfPlayers-1].getText());
		}
		nameField.clear();
		if(numOfPlayers==8) {
			addParticipants.setDisable(true);
			nameField.setDisable(true);
			startChampionship.setDisable(false);
		}
	}
	
	public void startChampionship(Model theModel) {
		gameType.setDisable(true);
		String gameType="";
		if(tennis.isSelected()) {
			 gameType=tennis.getText();
		}
		else if(basketBall.isSelected()) {
			 gameType=basketBall.getText();
		}
		else if(soccer.isSelected()) {
			 gameType=soccer.getText();
		}
		theModel.setGameType(gameType);
		stage.close();
	}


	public void clearView() {
		addParticipants.setVisible(false);
		startChampionship.setVisible(false);
		participantName.setVisible(false);
		nameField.setVisible(false);
		tennis.setVisible(false);
		basketBall.setVisible(false);
		soccer.setVisible(false);
		participantsNames.setVisible(false);
	}
	public void showView() {
		addParticipants.setVisible(true);
		startChampionship.setVisible(true);
		participantName.setVisible(true);
		nameField.setVisible(true);
		tennis.setVisible(true);
		basketBall.setVisible(true);
		soccer.setVisible(true);
		participantsNames.setVisible(true);
	}

}
