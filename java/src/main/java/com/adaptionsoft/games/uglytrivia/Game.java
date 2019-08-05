package com.adaptionsoft.games.uglytrivia;

public class Game {

	Players players;

	Questions questions;
    
    boolean isGettingOutOfPenaltyBox;
	private String verbosity;

	public  Game(Questions questions, Players players){
		this.questions = questions;
		this.players = players;
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
		log("The category is " + questions.currentCategory(players.currentPlayerPlace()));
		log(questions.askQuestion(players.currentPlayerPlace(), this));
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
