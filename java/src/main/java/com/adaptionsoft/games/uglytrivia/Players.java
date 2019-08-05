package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class Players {
	private Game game;
	private int currentPlayer = 0;
	private List<Player> players = new ArrayList<>();


	public Players(Game game) {
		this.game = game;
	}

	private Player currentPlayer(){
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

	public int getCurrentPlayerAsInt() {
		return currentPlayer;
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
