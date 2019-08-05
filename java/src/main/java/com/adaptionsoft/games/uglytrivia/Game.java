package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {

	private Players playerList = new Players(this);
    ArrayList<String> players = new ArrayList();

    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();
    
    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;
	private String verbosity;

	public  Game(){
    	for (int i = 0; i < 50; i++) {
			popQuestions.addLast("Pop Question " + i);
			scienceQuestions.addLast(("Science Question " + i));
			sportsQuestions.addLast(("Sports Question " + i));
		    rockQuestions.addLast("Rock Question " + i);
		}
	}

	public void add(String playerName) {
		
		
	    players.add(playerName);

	    log(playerName + " was added");
	    log("They are player number " + howManyPlayers());
	}

	public int howManyPlayers() {
		return players.size();
	}

	public void roll(int roll) {
		log(getCurrentPlayer() + " is the current player");
		log("They have rolled a " + roll);

		if (playerList.isCurrentPlayerInPenaltyBox()) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;

				log(getCurrentPlayer() + " is getting out of the penalty box");
				movePlayerAndAskQuestion(roll);
			} else {
				log(getCurrentPlayer() + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
			}

		} else {

			movePlayerAndAskQuestion(roll);
		}

	}

	private void movePlayerAndAskQuestion(int roll) {
		playerList.currentPlayerRoll(roll);

		log(getCurrentPlayer()
			+ "'s new location is "
			+ playerList.currentPlayerPlace());
		log("The category is " + currentCategory());
		askQuestion();
	}

	private void askQuestion() {
		if (currentCategory() == "Pop")
			log(popQuestions.removeFirst());
		if (currentCategory() == "Science")
			log(scienceQuestions.removeFirst());
		if (currentCategory() == "Sports")
			log(sportsQuestions.removeFirst());
		if (currentCategory() == "Rock")
			log(rockQuestions.removeFirst());
	}


	private String currentCategory() {
		if (playerList.currentPlayerPlace() == 0) return "Pop";
		if (playerList.currentPlayerPlace() == 4) return "Pop";
		if (playerList.currentPlayerPlace() == 8) return "Pop";
		if (playerList.currentPlayerPlace() == 1) return "Science";
		if (playerList.currentPlayerPlace() == 5) return "Science";
		if (playerList.currentPlayerPlace() == 9) return "Science";
		if (playerList.currentPlayerPlace() == 2) return "Sports";
		if (playerList.currentPlayerPlace() == 6) return "Sports";
		if (playerList.currentPlayerPlace() == 10) return "Sports";
		return "Rock";
	}

	public boolean wasCorrectlyAnswered() {
		if (playerList.isCurrentPlayerInPenaltyBox()) {
			if (isGettingOutOfPenaltyBox) {
				log("Answer was correct!!!!");
				nextCurrentPlayer();
				playerList.currentPlayerWinsACoin();
				System.out.println(getCurrentPlayer()
					+ " now has "
					+ playerList.currentPlayerCoins()
					+ " Gold Coins.");

				boolean winner = didPlayerWin();

				return winner;
			} else {
				nextCurrentPlayer();
				return true;
			}


		} else {

			log("Answer was corrent!!!!");
			playerList.currentPlayerWinsACoin();
			System.out.println(getCurrentPlayer()
				+ " now has "
				+ playerList.currentPlayerCoins()
				+ " Gold Coins.");

			boolean winner = didPlayerWin();
			nextCurrentPlayer();

			return winner;
		}
	}

	public boolean wrongAnswer() {
		log("Question was incorrectly answered");
		log(getCurrentPlayer() + " was sent to the penalty box");
		playerList.currentPlayerToPenaltyBox();

		nextCurrentPlayer();
		return true;
	}


	private boolean didPlayerWin() {
		return !(playerList.currentPlayerCoins() == 6);
	}

	public void setVerbosity(String value) {
		this.verbosity = value;
	}

	private void log(Object line) {
		if ("debug".equals(verbosity)) {
			System.out.println(line);
		}
	}


	private void nextCurrentPlayer() {
		this.currentPlayer++;
		if (currentPlayer == players.size()) currentPlayer = 0;
	}

	public int getCurrentPlayerAsInt() {
		return currentPlayer;
	}

	public String getCurrentPlayer() {
		return players.get(currentPlayer);
	}
}
