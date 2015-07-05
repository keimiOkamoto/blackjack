import player.CardPlayer;

public interface Dealer {
    /**
     * Shuffles card.
     */
    void shuffle();

    /**
     * Sets up game.
     */
    void setupGame();

    /**
     * Plays game.
     */
    void playGame();

    /**
     * Gets the winner of the game.
     *
     * @return the winner.
     */
    CardPlayer getWinner();

    /**
     * Gets the winners total score.
     *
     * @return score.
     */
    int getWinnersScore();
}
