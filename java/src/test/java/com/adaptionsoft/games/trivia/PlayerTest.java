package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Player;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {


	@Test
	public void winning_a_coin_increases_the_number_of_coins(){
		final Player player = new Player("player");

		player.winCoin();

		assertThat(player.getCoins(), Is.is(1));
	}

	@Test
	public void winning_a_coin_increases_the_number_of_coins_2(){
		final Player player = new Player("player");

		player.winCoin();
		player.winCoin();
		player.winCoin();

		assertThat(player.getCoins(), Is.is(3));
	}

}
