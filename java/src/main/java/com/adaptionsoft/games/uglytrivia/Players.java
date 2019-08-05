package com.adaptionsoft.games.uglytrivia;

public class Players {
	private Game game;
	private int[] purses = new int[6];


	public Players(Game game) {
		this.game = game;
	}

	int currentPlayerCoins() {
		return purses[game.currentPlayer];
	}

	int currentPlayerWinsACoin() {
		return purses[game.currentPlayer]++;
	}
}
