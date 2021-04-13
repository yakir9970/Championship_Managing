package Model;

import java.util.Vector;

public class Model {
	private Championship championship;

	public Model() {
		championship=new Championship();
	}

	public void addParticipant(String name) {
		championship.addParticipant(name);
	}

	public void setGameType(String gameType) {
		championship.setGameType(gameType);
	}

	public Vector<Participants> getParticipants() {
		return championship.getParticipants();
	}

	public Vector<Participants> getPlayers(int i) {
		return championship.getPlayers(i);
	}

	public String getGameType() {
		return championship.getGameType();
	}
}
