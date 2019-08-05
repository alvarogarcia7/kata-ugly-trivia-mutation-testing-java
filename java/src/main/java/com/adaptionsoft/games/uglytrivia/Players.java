package com.adaptionsoft.games.uglytrivia;

public class Players {
	private Game game;
	private int[] purses = new int[6];
	private int[] places = new int[6];
	private boolean[] inPenaltyBox = new boolean[6];


	public Players(Game game) {
		this.game = game;
	}

	int currentPlayerCoins() {
		return purses[game.getCurrentPlayerAsInt()];
	}

	int currentPlayerWinsACoin() {
		return purses[game.getCurrentPlayerAsInt()]++;
	}

	int currentPlayerPlace() {
		return places[game.getCurrentPlayerAsInt()];
	}

	void currentPlayerRoll(int roll) {
		places[game.getCurrentPlayerAsInt()] = currentPlayerPlace() + roll;
		if (currentPlayerPlace() > 11) places[game.getCurrentPlayerAsInt()] = currentPlayerPlace() - 12;
	}

	void currentPlayerToPenaltyBox() {
		inPenaltyBox[game.getCurrentPlayerAsInt()] = true;
	}

	boolean isCurrentPlayerInPenaltyBox() {
		return inPenaltyBox[game.getCurrentPlayerAsInt()];
	}
}
