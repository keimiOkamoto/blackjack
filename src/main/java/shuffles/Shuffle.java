package shuffles;

public interface Shuffle {
    /**
     * Takes a list of cards and shuffles them.
     *
     * @param cards a deck of cards.
     * @return a shuffled deck of cards.
     */
    int[] shuffles(int[] cards);
}
