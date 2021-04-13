package Controller;

import java.util.Vector;

import Model.Model;
import Model.Participants;
import View.View;
import View.playGame;
import View.Competition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Toggle;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Controller {

	private View theView;
	private Model theModel;
	private Competition comp;
	private playGame play;

	public Controller(Model m, View v) {

		theView = v;
		theModel = m;

		ChangeListener<Toggle> chl = new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				theView.addEnable();
			}
		};

		theView.addChangeListenerToToggleGroup(chl);

		EventHandler<ActionEvent> addParticipantsPressed = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				theView.addParticipants(theModel);

			}
		};
		theView.addEventToAddParticipants(addParticipantsPressed);

		EventHandler<ActionEvent> startChampionshipPressed = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				theView.startChampionship(theModel);
				Stage secondStage = new Stage();
				comp = new Competition(secondStage);
				comp.setParticipants(theModel.getParticipants());

				EventHandler<ActionEvent> playGame1Pressed = new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						Stage playStage = new Stage();
						Vector<Participants> players = theModel.getPlayers(1);
						play = new playGame(playStage, players, theModel.getGameType());

						// event for done button
						EventHandler<ActionEvent> donePressed1 = new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								Participants winner = play.done();
								int tie = play.getTie();
								if (winner != null) {
									if (winner.getName() != "-1") {
										comp.updateWinner(1, winner);
									} else {
										if (tie == 1 && !play.getTied()) {
											play.firstTie();
										} else if (!play.getPenalties()) {
											play.secondTie();
											play.setLastRound();
										}
									}
								} else {
									Alert msg = new Alert(AlertType.ERROR);
									msg.setContentText("Must fill all the details!");
									msg.show();
								}
							}
						};
						play.addEventToDone1(donePressed1);
					}
				};
				comp.addEventToPlayGame1(playGame1Pressed);

				EventHandler<ActionEvent> playGame2Pressed = new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						Stage playStage = new Stage();
						Vector<Participants> players = theModel.getPlayers(2);
						play = new playGame(playStage, players, theModel.getGameType());

						// event for done button
						EventHandler<ActionEvent> donePressed2 = new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								Participants winner = play.done();
								int tie = play.getTie();
								if (winner != null) {
									if (winner.getName() != "-1") {
										comp.updateWinner(2, winner);
									} else {
										if (tie == 1 && !play.getTied()) {
											play.firstTie();
										} else if (!play.getPenalties()) {
											play.secondTie();
											play.setLastRound();
										}
									}
								} else {
									Alert msg = new Alert(AlertType.ERROR);
									msg.setContentText("Must fill all the details!");
									msg.show();
								}
							}
						};
						play.addEventToDone2(donePressed2);
					}
				};
				comp.addEventToPlayGame2(playGame2Pressed);

				EventHandler<ActionEvent> playGame3Pressed = new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						Stage playStage = new Stage();
						Vector<Participants> players = theModel.getPlayers(3);
						play = new playGame(playStage, players, theModel.getGameType());

						// event for done button
						EventHandler<ActionEvent> donePressed3 = new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								Participants winner = play.done();
								int tie = play.getTie();
								if (winner != null) {
									if (winner.getName() != "-1") {
										comp.updateWinner(3, winner);
									} else {
										if (tie == 1 && !play.getTied()) {
											play.firstTie();
										} else if (!play.getPenalties()) {
											play.secondTie();
											play.setLastRound();
										}
									}
								} else {
									Alert msg = new Alert(AlertType.ERROR);
									msg.setContentText("Must fill all the details!");
									msg.show();
								}
							}
						};
						play.addEventToDone3(donePressed3);
					}
				};
				comp.addEventToPlayGame3(playGame3Pressed);

				EventHandler<ActionEvent> playGame4Pressed = new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						Stage playStage = new Stage();
						Vector<Participants> players = theModel.getPlayers(4);
						play = new playGame(playStage, players, theModel.getGameType());

						// event for done button
						EventHandler<ActionEvent> donePressed4 = new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								Participants winner = play.done();
								int tie = play.getTie();
								if (winner != null) {
									if (winner.getName() != "-1") {
										comp.updateWinner(4, winner);
									} else {
										if (tie == 1 && !play.getTied()) {
											play.firstTie();
										} else if (!play.getPenalties()) {
											play.secondTie();
											play.setLastRound();
										}
									}
								} else {
									Alert msg = new Alert(AlertType.ERROR);
									msg.setContentText("Must fill all the details!");
									msg.show();
								}
							}
						};
						play.addEventToDone4(donePressed4);
					}
				};
				comp.addEventToPlayGame4(playGame4Pressed);

				EventHandler<ActionEvent> playGame5Pressed = new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						Stage playStage = new Stage();
						Vector<Participants> players = theModel.getPlayers(5);
						play = new playGame(playStage, players, theModel.getGameType());

						// event for done button
						EventHandler<ActionEvent> donePressed5 = new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								Participants winner = play.done();
								int tie = play.getTie();
								if (winner != null) {
									if (winner.getName() != "-1") {
										comp.updateWinner(5, winner);
									} else {
										if (tie == 1 && !play.getTied()) {
											play.firstTie();
										} else if (!play.getPenalties()) {
											play.secondTie();
											play.setLastRound();
										}
									}
								} else {
									Alert msg = new Alert(AlertType.ERROR);
									msg.setContentText("Must fill all the details!");
									msg.show();
								}
							}
						};
						play.addEventToDone5(donePressed5);
					}
				};
				comp.addEventToPlayGame5(playGame5Pressed);

				EventHandler<ActionEvent> playGame6Pressed = new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						Stage playStage = new Stage();
						Vector<Participants> players = theModel.getPlayers(6);
						play = new playGame(playStage, players, theModel.getGameType());

						// event for done button
						EventHandler<ActionEvent> donePressed6 = new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								Participants winner = play.done();
								int tie = play.getTie();
								if (winner != null) {
									if (winner.getName() != "-1") {
										comp.updateWinner(6, winner);
									} else {
										if (tie == 1 && !play.getTied()) {
											play.firstTie();
										} else if (!play.getPenalties()) {
											play.secondTie();
											play.setLastRound();
										}
									}
								} else {
									Alert msg = new Alert(AlertType.ERROR);
									msg.setContentText("Must fill all the details!");
									msg.show();
								}
							}
						};
						play.addEventToDone6(donePressed6);
					}
				};
				comp.addEventToPlayGame6(playGame6Pressed);

				EventHandler<ActionEvent> playGame7Pressed = new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						Stage playStage = new Stage();
						Vector<Participants> players = theModel.getPlayers(7);
						play = new playGame(playStage, players, theModel.getGameType());

						// event for done button
						EventHandler<ActionEvent> donePressed7 = new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								Participants winner = play.done();
								int tie = play.getTie();
								if (winner != null) {
									if (winner.getName() != "-1") {
										comp.updateWinner(7, winner);
									} else {
										if (tie == 1 && !play.getTied()) {
											play.firstTie();
										} else if (!play.getPenalties()) {
											play.secondTie();
											play.setLastRound();
										}
									}
								} else {
									Alert msg = new Alert(AlertType.ERROR);
									msg.setContentText("Must fill all the details!");
									msg.show();
								}
							}
						};
						play.addEventToDone7(donePressed7);
					}
				};
				comp.addEventToPlayGame7(playGame7Pressed);
			}

		};
		theView.addEventToStartChampionship(startChampionshipPressed);

	}

}
