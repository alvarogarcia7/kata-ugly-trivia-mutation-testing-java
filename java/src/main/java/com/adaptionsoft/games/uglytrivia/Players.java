package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class Players {
	private Game game;
	private int[] purses = new int[6];
	private int[] places = new int[6];
	private boolean[] inPenaltyBox = new boolean[6];
	private int currentPlayer = 0;
	private List<Player> players = new ArrayList<>();


	public Players(Game game) {
		this.game = game;
	}

	int currentPlayerCoins() {
		return purses[game.players.getCurrentPlayerAsInt()];
	}

	int currentPlayerWinsACoin() {
		return purses[game.players.getCurrentPlayerAsInt()]++;
	}

	int currentPlayerPlace() {
		return places[game.players.getCurrentPlayerAsInt()];
	}

	void currentPlayerRoll(int roll) {
		places[game.players.getCurrentPlayerAsInt()] = currentPlayerPlace() + roll;
		if (currentPlayerPlace() > 11) places[game.players.getCurrentPlayerAsInt()] = currentPlayerPlace() - 12;
	}

	void currentPlayerToPenaltyBox() {
		inPenaltyBox[game.players.getCurrentPlayerAsInt()] = true;
	}

	boolean isCurrentPlayerInPenaltyBox() {
		return inPenaltyBox[game.players.getCurrentPlayerAsInt()];
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
