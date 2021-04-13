package Model;

import java.util.Vector;

public class Championship {
	private Vector<Game> game;
	private Vector<Participants> participants;
	private String gameType;

	public Championship() {
		game = new Vector<Game>();
		participants = new Vector<Participants>();
	}

	public Championship(Vector<Participants> par) {
		participants = par;
	}

	public void addParticipant(String name) {
		Participants player = new Participants(name);
		participants.add(player);
	}

	public void setGameType(String gameType2) {
		gameType = gameType2;
	}

	public Vector<Participants> getParticipants() {
		return participants;
	}

	public Vector<Participants> getPlayers(int i) {
		Vector<Participants> players = new Vector<>();
		if (i == 1) {
			players.clear();
			players.add(participants.get(0));
			players.add(participants.get(1));
			return players;
		} else if (i == 2) {
			players.clear();
			players.add(participants.get(2));
			players.add(participants.get(3));
			return players;
		} else if (i == 3) {
			players.clear();
			players.add(participants.get(4));
			players.add(participants.get(5));
			return players;
		} else if (i == 4) {
			players.clear();
			players.add(participants.get(6));
			players.add(participants.get(7));
			return players;
		} else if (i == 5) {
			players.clear();
			for (int j = 0; j < 4; j++) {
				if (participants.get(j).getWins() == 1) {
					players.add(participants.get(j));
				}
			}
			return players;
		} else if (i == 6) {
			players.clear();
			for (int j = 4; j < 8; j++) {
				if (participants.get(j).getWins() == 1) {
					players.add(participants.get(j));
				}
			}
			return players;
		} else {
			players.clear();
			for (int j = 0; j < 8; j++) {
				if (participants.get(j).getWins() == 2) {
					players.add(participants.get(j));
				}
			}
			return players;
		}

	}

	public String getGameType() {
		return gameType;
	}

}
