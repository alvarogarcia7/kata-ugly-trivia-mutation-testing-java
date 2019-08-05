package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.trivia.runner.GameRunner;
import com.adaptionsoft.games.uglytrivia.Game;
import org.approvaltests.Approvals;
import org.junit.Test;

import java.io.*;
import java.util.NoSuchElementException;
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
	public void exhaust_questions() throws Exception {

		ByteArrayOutputStream resultStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(resultStream));
		NoSuchElementException exception = null;
		try {

			IntStream.range(1, 10).forEach(i -> {
				Random rand = new Random(i);
				Game aGame = new Game();
				aGame.setVerbosity("");

				aGame.add("Chet");
				aGame.add("Pat");
				aGame.add("Sue");


				int steps = 1000;
				do {

					aGame.roll(rand.nextInt(5) + 1);

					aGame.wrongAnswer();

					steps--;
				} while (steps > 0);
			});
		} catch (NoSuchElementException e) {
			exception = e;
		} finally {
			if (null == exception) {
				fail("should have thrown an exception");
			}
		}
	}
}
