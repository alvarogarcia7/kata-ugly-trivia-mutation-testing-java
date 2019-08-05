package com.adaptionsoft.games.uglytrivia;

public class Player {
	public final String name;

	private int coins;
	private int place;

	private boolean inPenaltyBox;
	public Player(String name) {
		this.name = name;
		this.coins = 0;
		this.place = 0;
	}

	public int winCoin() {
		return this.coins++;
	}

	public void roll(int roll) {
		place = place + roll;
		if (place > 11) place = place - 12;
	}

	public void toPenaltyBox() {
		inPenaltyBox = true;
	}

	public int getPlace() {
		return place;
	}

	public int getCoins() {
		return coins;
	}

	public boolean isInPenaltyBox() {
		return inPenaltyBox;
	}
}
