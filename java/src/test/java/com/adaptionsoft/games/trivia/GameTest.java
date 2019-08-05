package com.adaptionsoft.games.trivia;

import static org.junit.Assert.*;

import com.adaptionsoft.games.trivia.runner.GameRunner;
import org.approvaltests.Approvals;
import org.junit.Test;

import java.io.*;
import java.util.Random;
import java.util.stream.IntStream;

public class GameTest {

	@Test
	public void itsLockedDown() throws Exception {

        Random randomizer = new Random(123455);
        ByteArrayOutputStream resultStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(resultStream));

        IntStream.range(1,15).forEach(i -> GameRunner.playGame(randomizer));

        Approvals.verify(resultStream.toString());

	}

	@Test
	public void itsLockedDown_longerTest() throws Exception {

		Random randomizer = new Random(123455);
		ByteArrayOutputStream resultStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(resultStream));

		IntStream.range(1,1000).forEach(i -> GameRunner.playGame(randomizer));

		Approvals.verify(resultStream.toString());

	}

	@Test
	public void itsLockedDown_broaderTest() throws Exception {

		ByteArrayOutputStream resultStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(resultStream));

		IntStream.range(1,1000).forEach(i -> GameRunner.playGame(new Random(i)));

		Approvals.verify(resultStream.toString());

	}
}
