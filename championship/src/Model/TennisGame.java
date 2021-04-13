package Model;

import java.util.Vector;

public class TennisGame extends Game {
		
		private static final int SETS=5;
		private int player1Sum = 0,player2Sum=0;

		public TennisGame() {
			super(SETS);
		}
		
		public TennisGame(Participants player1, Participants player2) {
			super(5);
			this.player1=player1;
			this.player2=player2;
		}
		
		public boolean isTechnicalWin() {
			if(player1Sum==3||player2Sum==3) {
				return true;
			}
			return false;
		}
		
		public void resetWins() {
			player1Sum=0;
			player2Sum=0;
		}

		public Participants winner() {
			Vector <Integer> player1Results=new Vector<Integer>();
			Vector <Integer> player2Results=new Vector<Integer>();
			player1Results.clear();
			player2Results.clear();
			player1Results=player1.getResults();
			player2Results=player2.getResults();
			for (int i = 0; i < player1Results.size(); i++) {
				if(player1Results.get(i)>=player2Results.get(i)) {
					player1Sum++;
				}
				else if(player1Results.get(i)<player2Results.get(i)) {
					player2Sum++;
				}
			}
			if(player1Sum>player2Sum&&player1Sum>=3) {
				return player1;
				
			}
			else if(player2Sum>player1Sum&&player2Sum>=3) {
				return player2;
			}
			else {
				return null;
			}
		}
	}

