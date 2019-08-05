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

}
