package com.adaptionsoft.games.uglytrivia;

public class Player {
	private final String name;
	private int place;

	public Player(String playerName, int place) {
		this.name = playerName;
		this.place = place;
	}

	public String getName() {
		return name;
	}

	public void movePlayer(int roll) {
		this.place = this.place + roll;
		if (this.place > 11) this.place = this.place - 12;
	}

	public int getPlace() {
		return this.place;
	}
}
