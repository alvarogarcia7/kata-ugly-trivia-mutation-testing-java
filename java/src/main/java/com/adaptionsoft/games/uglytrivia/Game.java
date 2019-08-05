package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class Game {

	Players players = new Players(this);

    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();
    
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
		log(players.getCurrentPlayer() + " is the current player");
		log("They have rolled a " + roll);

		if (players.isCurrentPlayerInPenaltyBox()) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;

				log(players.getCurrentPlayer() + " is getting out of the penalty box");
				movePlayerAndAskQuestion(roll);
			} else {
				log(players.getCurrentPlayer() + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
			}

		} else {

			movePlayerAndAskQuestion(roll);
		}

	}

	private void movePlayerAndAskQuestion(int roll) {
		players.currentPlayerRoll(roll);

		log(players.getCurrentPlayer()
			+ "'s new location is "
			+ players.currentPlayerPlace());
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
		if (players.currentPlayerPlace() == 0) return "Pop";
		if (players.currentPlayerPlace() == 4) return "Pop";
		if (players.currentPlayerPlace() == 8) return "Pop";
		if (players.currentPlayerPlace() == 1) return "Science";
		if (players.currentPlayerPlace() == 5) return "Science";
		if (players.currentPlayerPlace() == 9) return "Science";
		if (players.currentPlayerPlace() == 2) return "Sports";
		if (players.currentPlayerPlace() == 6) return "Sports";
		if (players.currentPlayerPlace() == 10) return "Sports";
		return "Rock";
	}

	public boolean wasCorrectlyAnswered() {
		if (players.isCurrentPlayerInPenaltyBox()) {
			if (isGettingOutOfPenaltyBox) {
				log("Answer was correct!!!!");
				players.nextCurrentPlayer();
				players.currentPlayerWinsACoin();
				System.out.println(players.getCurrentPlayer()
					+ " now has "
					+ players.currentPlayerCoins()
					+ " Gold Coins.");

				boolean winner = didPlayerWin();

				return winner;
			} else {
				players.nextCurrentPlayer();
				return true;
			}


		} else {

			log("Answer was corrent!!!!");
			players.currentPlayerWinsACoin();
			System.out.println(players.getCurrentPlayer()
				+ " now has "
				+ players.currentPlayerCoins()
				+ " Gold Coins.");

			boolean winner = didPlayerWin();
			players.nextCurrentPlayer();

			return winner;
		}
	}

	public boolean wrongAnswer() {
		log("Question was incorrectly answered");
		log(players.getCurrentPlayer() + " was sent to the penalty box");
		players.currentPlayerToPenaltyBox();

		players.nextCurrentPlayer();
		return true;
	}


	private boolean didPlayerWin() {
		return !(players.currentPlayerCoins() == 6);
	}

	public void setVerbosity(String value) {
		this.verbosity = value;
	}

	private void log(Object line) {
		if ("debug".equals(verbosity)) {
			System.out.println(line);
		}
	}


}
