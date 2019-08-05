package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class Questions {
	private LinkedList<String> popQuestions = new LinkedList<>();
	private LinkedList<String> scienceQuestions = new LinkedList<>();
	private LinkedList<String> sportsQuestions = new LinkedList<>();
	private LinkedList<String> rockQuestions = new LinkedList<>();

	public Questions() {
		for (int i = 0; i < 50; i++) {
			popQuestions.addLast("Pop Question " + i);
			scienceQuestions.addLast(("Science Question " + i));
			sportsQuestions.addLast(("Sports Question " + i));
			rockQuestions.addLast("Rock Question " + i);
		}
	}

	public String getPopQuestion() {
		return popQuestions.pop();
	}

	public String getScienceQuestion() {
		return scienceQuestions.pop();
	}

	public String getSportsQuestion() {
		return sportsQuestions.pop();
	}

	public String getRockQuestion() {
		return rockQuestions.pop();
	}

	String currentCategory(int currentPlayerPlace) {
		if (currentPlayerPlace == 0) return "Pop";
		if (currentPlayerPlace == 4) return "Pop";
		if (currentPlayerPlace == 8) return "Pop";
		if (currentPlayerPlace == 1) return "Science";
		if (currentPlayerPlace == 5) return "Science";
		if (currentPlayerPlace == 9) return "Science";
		if (currentPlayerPlace == 2) return "Sports";
		if (currentPlayerPlace == 6) return "Sports";
		if (currentPlayerPlace == 10) return "Sports";
		return "Rock";
	}

	String askQuestion(int currentPlayerPlace, Game game) {
		if (currentCategory(currentPlayerPlace) == "Pop")
			return getPopQuestion();
		if (currentCategory(currentPlayerPlace) == "Science")
			return getScienceQuestion();
		if (currentCategory(currentPlayerPlace) == "Sports")
			return getSportsQuestion();
		if (currentCategory(currentPlayerPlace) == "Rock")
			return getRockQuestion();
		throw new IllegalArgumentException();
	}
}
