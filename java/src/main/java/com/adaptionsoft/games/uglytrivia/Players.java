package com.adaptionsoft.games.uglytrivia;

public class Players {
	private Game game;

	public Players(Game game) {
		this.game = game;
	}

	int currentPlayerCoins() {
		return game.purses[game.currentPlayer];
	}

	int currentPlayerWinsACoin() {
		return game.purses[game.currentPlayer]++;
	}
}
