package Model;

import java.util.Vector;

public class BasketBallGame extends Game {
	private static final int SETS=4;

	public BasketBallGame() {
		super(SETS);
		
	}
	
	public BasketBallGame(Participants player1, Participants player2) {
		super(4);
		this.player1=player1;
		this.player2=player2;
	}

	public Participants winner() {
		int player1Sum = 0,player2Sum=0;
		Vector <Integer> player1Results=player1.getResults();
		Vector <Integer> player2Results=player2.getResults();
		for (int i = 0; i < player1Results.size(); i++) {
			player1Sum+=player1Results.get(i);
			player2Sum+=player2Results.get(i);
		}
		if(player1Sum>=player2Sum) {
			player1.setWins();
			return player1;
		}
		else {
			player2.setWins();
			return player2;
		}
		
	}
}
