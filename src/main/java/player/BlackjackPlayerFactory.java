package player;

public class BlackjackPlayerFactory {

    private static BlackjackPlayerFactory playerFactory;

    private BlackjackPlayerFactory() {
    }

    public static BlackjackPlayerFactory getInstance() {
        if (playerFactory == null) playerFactory = new BlackjackPlayerFactory();
        return playerFactory;
    }

    /**
     * Generates a player with the given ID.
     *
     * @param id of the player.
     * @return a player.
     */
    public CardPlayer generatePlayer(int id) {
        return new BlackjackCardPlayer(id);
    }
}
