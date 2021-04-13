package Model;

import java.util.Vector;

public class Participants {
	private String name;
	private Vector<Integer> results;
	private int wins;

	public Participants(String name2) {
		name=name2;
		results=new Vector<Integer>();
		wins=0;
	}
	
	public void setWins() {
		wins++;
	}
	
	public void setResults(int i) {
		results.add(i);
	}

	public Vector<Integer> getResults() {
		return results;
	}
	
	public String getName() {
		return name;
	}

	public int getWins() {
		return wins;
	}

	public void resetResult() {
		results.clear();
	}

}
