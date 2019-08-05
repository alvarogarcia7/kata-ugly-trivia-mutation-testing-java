package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class Players {
	private int currentPlayer = 0;
	private List<Player> players = new ArrayList<>();

	private Player currentPlayer() {
		return this.players.get(currentPlayer);
	}

	int currentPlayerCoins() {
		return currentPlayer().getCoins();
	}

	int currentPlayerWinsACoin() {
		return currentPlayer().winCoin();
	}

	int currentPlayerPlace() {
		return currentPlayer().getPlace();
	}

	void currentPlayerRoll(int roll) {
		currentPlayer().roll(roll);
	}

	void currentPlayerToPenaltyBox() {
		currentPlayer().toPenaltyBox();
	}

	boolean isCurrentPlayerInPenaltyBox() {
		return currentPlayer().isInPenaltyBox();
	}

	void nextCurrentPlayer() {
		currentPlayer++;
		if (currentPlayer == players.size()) currentPlayer = 0;
	}

	public String getCurrentPlayer() {
		return players.get(currentPlayer).name;
	}

	public void add(String playerName) {
		this.players.add(new Player(playerName));
	}

	public int size() {
		return this.players.size();
	}
}
