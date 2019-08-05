
package com.adaptionsoft.games.trivia.runner;
import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.Players;
import com.adaptionsoft.games.uglytrivia.Questions;


public class GameRunner {

	private static boolean notAWinner;

	public static void main(String[] args) {
		Random rand = new Random();
		playGame(rand, "debug");
	}

	public static void playGame(Random rand, String verbosity) {
		Game aGame = new Game(new Questions(), new Players());
		aGame.setVerbosity(verbosity);

		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");


		do {

			aGame.roll(rand.nextInt(5) + 1);

			if (rand.nextInt(9) == 7) {
				notAWinner = aGame.wrongAnswer();
			} else {
				notAWinner = aGame.wasCorrectlyAnswered();
			}



		} while (notAWinner);
	}
}
