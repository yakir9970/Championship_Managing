package Model;

import java.util.Vector;

public class Game {
	protected Participants player1, player2;
	protected int numOfSets;
	protected int tie;

	public Game(int num) {
		numOfSets = num;
	}

	public Participants winner() {
		return null;
	}

	public void setTie() {

	}

	public void setPenalties() {

	}

	public boolean getPenalties() {
		return false;
	}

	public int getTie() {
		return tie;
	}

	public boolean isTechnicalWin() {
		return false;
	}

	public void resetWins() {
		
	}
}
