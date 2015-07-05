package player;

public interface CardPlayer {

    /**
     * Takes a card.
     *
     * @param cardValue a value of a card.
     */
    void drawCard(int cardValue);

    /**
     * Sums the total of the current hand.
     *
     * @return sum of hand.
     */
    int getTotalHandValue();

    /**
     * Gets the id of the player.
     *
     * @return an identifier for the player.
     */
    int getId();
}
