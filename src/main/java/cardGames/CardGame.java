/**
 * Interface for card games.
 */
package cardGames;

import player.CardPlayer;

import java.util.Set;

public interface CardGame {
    /**
     * Checks if the player is eligible to play
     * the game.
     *
     * @param player a player.
     * @return true if the player is eligible.
     */
    boolean isEligible(CardPlayer player);

    /**
     * Checks if the player meets the winning condition
     * of the game.
     *
     * @param player a player.
     * @return true if the player is a winner.
     */
    boolean isWinner(CardPlayer player);

    /**
     * Checks if the player has lost.
     *
     * @param player a player.
     * @return true if the player has lost.
     */
    boolean isOut(CardPlayer player);

    /**
     * Returns the player with the best
     * hand according to the game rules.
     *
     * @param players a player.
     * @return a player with the best hand.
     */
    CardPlayer getBestHand(Set<CardPlayer> players);

    /**
     * Returns the number of cards a player can have.
     *
     * @return number of cards.
     */
    int getCardsPerPlayer();
}
