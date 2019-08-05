package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Players {
	private int currentPlayer = 0;
	private List<Player> players = new ArrayList<>();

	public Players(String player1, String player2, String... rest) {
		this.add(player1);
		this.add(player2);
		for (String player : rest) {
			this.add(player);
		}
	}

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

	private void add(String playerName) {
		this.players.add(new Player(playerName));
	}

	public void forEach(Consumer<Player> mapper) {
		this.players.forEach(mapper);
	}
}
