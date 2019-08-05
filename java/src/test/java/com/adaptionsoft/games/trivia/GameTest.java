package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.trivia.runner.GameRunner;
import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.Players;
import com.adaptionsoft.games.uglytrivia.Questions;
import org.approvaltests.Approvals;
import org.junit.Test;

import java.io.*;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.fail;

public class GameTest {

	@Test
	public void itsLockedDown() throws Exception {

		Random randomizer = new Random(123455);
		ByteArrayOutputStream resultStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(resultStream));

		IntStream.range(1, 15).forEach(i -> GameRunner.playGame(randomizer, "debug"));

		Approvals.verify(resultStream.toString());

	}

	@Test
	public void itsLockedDown_longerTest() throws Exception {

		Random randomizer = new Random(123455);
		ByteArrayOutputStream resultStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(resultStream));

		IntStream.range(1, 1000).forEach(i -> GameRunner.playGame(randomizer, "debug"));

		Approvals.verify(resultStream.toString());

	}

	@Test
	public void itsLockedDown_broaderTest() throws Exception {

		ByteArrayOutputStream resultStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(resultStream));

		IntStream.range(1, 1000).forEach(i -> GameRunner.playGame(new Random(i), "debug"));

		Approvals.verify(resultStream.toString());

	}


	@Test
	public void itsLockedDown_silent() throws Exception {

		Random randomizer = new Random(123455);
		ByteArrayOutputStream resultStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(resultStream));

		IntStream.range(1, 15).forEach(i -> GameRunner.playGame(randomizer, ""));

		Approvals.verify(resultStream.toString());

	}

	@Test
	public void itsLockedDown_longerTest_silent() throws Exception {

		Random randomizer = new Random(123455);
		ByteArrayOutputStream resultStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(resultStream));

		IntStream.range(1, 1000).forEach(i -> GameRunner.playGame(randomizer, ""));

		Approvals.verify(resultStream.toString());

	}

	@Test
	public void itsLockedDown_broaderTest_silent() throws Exception {

		ByteArrayOutputStream resultStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(resultStream));

		IntStream.range(1, 1000).forEach(i -> GameRunner.playGame(new Random(i), ""));

		Approvals.verify(resultStream.toString());

	}

	@Test
	public void exhaust_all_questions() throws Exception {

		ByteArrayOutputStream resultStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(resultStream));

		Game aGame = new Game(new Questions(), new Players("Chet", "Pat", "Sue"), "");

		int i = 50;
		int steps = 0;
		do {
			aGame.roll(0);
			aGame.wasCorrectlyAnswered();
			steps++;
			System.out.println(String.format("steps = %d is correct", steps));
			i--;
		} while (i > 0);

		Exception exception = null;
		try {
			aGame.roll(0);
		} catch (Exception e) {
			exception = e;
		} finally {
			if (null == exception) {
				fail("Should have thrown an exception here ");
			}
		}

		Approvals.verify(resultStream.toString());

	}

}
