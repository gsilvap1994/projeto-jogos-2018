package com.jogosufabc.projeto.model;

import java.util.ArrayList;

public class LeaderBoard {
	private String _id;
	private String username;
	private Long score;
	
	
	public LeaderBoard(String id, String username, Long score) {
		this._id = id;
		this.username = username;
		this.score = score;
	}
	
	public LeaderBoard(String username, Long score) {
		this.username = username;
		this.score = score;
	}
	
	public LeaderBoard() {}

	public String get_id() {
		return _id;
	}
	
	public void set_id(String _id) {
		this._id = _id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}
	
	public void debug(LeaderBoard l) {
		System.out.println("id: " + l.get_id());
		System.out.println("username: " + l.getUsername());
		System.out.println("score: " + l.getScore());
	}
	
	public ArrayList<LeaderBoard> getJsonFromString(String jsonArray) {
		ArrayList<LeaderBoard> lbl = new ArrayList<LeaderBoard>();
		String[] stringArray = jsonArray.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\{", "").replaceAll("\\{", "").split(",");
		int counter = 0;
		LeaderBoard lb = new LeaderBoard();
		for(String s: stringArray) {
			if(counter == 0) {
				lb.set_id(s.split(":")[1].replace("}", ""));
			}
			if(counter == 1) {
				lb.setUsername(s.split(":")[1].replace("}", ""));
			}
			if(counter == 2) {
				lb.setScore((Long.parseLong(s.split(":")[1].replace("}", ""))));
				lbl.add(lb);
				lb = new LeaderBoard();
				counter = 0;
			}
			else {
				counter += 1;
				
			}
			
			if(lbl.size() == 10) {
				break;
			}
		}
		
		return lbl;
	}

	
	
}