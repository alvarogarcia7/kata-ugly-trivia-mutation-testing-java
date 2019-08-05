package com.adaptionsoft.games.uglytrivia;

public class Players {
	private Game game;
	private int[] purses = new int[6];
	private int[] places = new int[6];
	private boolean[] inPenaltyBox  = new boolean[6];


	public Players(Game game) {
		this.game = game;
	}

	int currentPlayerCoins() {
		return purses[game.currentPlayer];
	}

	int currentPlayerWinsACoin() {
		return purses[game.currentPlayer]++;
	}

	int currentPlayerPlace() {
		return places[game.currentPlayer];
	}

	void currentPlayerRoll(int roll) {
		places[game.currentPlayer] = currentPlayerPlace() + roll;
		if (currentPlayerPlace() > 11) places[game.currentPlayer] = currentPlayerPlace() - 12;
	}

	void currentPlayerToPenaltyBox() {
		inPenaltyBox[game.currentPlayer] = true;
	}

	boolean isCurrentPlayerInPenaltyBox() {
		return inPenaltyBox[game.currentPlayer];
	}
}
