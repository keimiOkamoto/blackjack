/**
 * Test for the logic of a game of blackjack.
 */
package cardGames;

import constants.Constants;
import org.junit.Before;
import org.junit.Test;
import player.CardPlayer;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class BlackjackTest {

    private CardGame blackjack;
    private CardPlayer player;

    @Before
    public void buildUp() {
        blackjack = new Blackjack();
        player = mock(CardPlayer.class);
    }

    @Test
    public void shouldBeAbleToCheckIfAGivenPlayerIsAWinner() {
        when(player.getTotalHandValue()).thenReturn(Constants.UPPER_BOUND);
        assertTrue(blackjack.isWinner(player));
    }

    @Test
    public void shouldBeAbleToCheckIfThePlayerIsNoLongerActive() {
        when(player.getTotalHandValue()).thenReturn(Constants.UPPER_BOUND + 1);
        assertTrue(blackjack.isOut(player));
    }

    @Test
    public void shouldBeAbleToGetTheBestHandFromAListOfPlayers() {
        CardPlayer expectedPlayer = mock(CardPlayer.class);
        Set<CardPlayer> players = new HashSet<>();

        players.add(player);
        players.add(expectedPlayer);

        when(player.getTotalHandValue()).thenReturn(18);
        when(expectedPlayer.getTotalHandValue()).thenReturn(20);

        assertEquals(expectedPlayer, blackjack.getBestHand(players));
    }

    @Test
    public void shouldBeAbleToCheckIfPlayerIsNotBustOrNotSticking() {
        CardPlayer player1 = mock(CardPlayer.class);

        when(player.getTotalHandValue()).thenReturn(Constants.UPPER_BOUND - 1);
        when(player1.getTotalHandValue()).thenReturn(Constants.LOWER_BOUND + 1);

        assertTrue(blackjack.isEligible(player));
        assertTrue(blackjack.isEligible(player1));
    }
}
