import cardGames.CardGame;
import constants.Constants;
import player.CardPlayer;
import player.BlackjackPlayerFactory;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private GameRepository repository;

    public Menu(GameRepository repository) {
        this.repository = repository;
    }

    /**
     * Creates a list of players according to the input number.
     *
     * @param numberStr a number in string format.
     * @return A list of players.
     * @throws IllegalArgumentException if the player number is invalid.
     */
    public List<CardPlayer> getPlayers(String numberStr) throws IllegalArgumentException {
        if (numberStr.isEmpty()) return generatePlayer(Constants.DEFAULT_PLAYER_NUMBER);

        int number = Integer.parseInt(numberStr);
        if (number < Constants.DEFAULT_PLAYER_NUMBER || number > Constants.PLAYER_UPPER_BOUND) throw new IllegalArgumentException();
        else return generatePlayer(number);
    }

    public CardGame getGame(String name) {
        return repository.get(name);
    }


    private List<CardPlayer> generatePlayer(int number) {
        List<CardPlayer> list = new ArrayList<>();
        for (int x = 0; x < number; x++) {
            CardPlayer player = BlackjackPlayerFactory.getInstance().generatePlayer(x + 1);
            list.add(player);
            System.out.println("Player with ID " + player.getId() + " joined the game.");
        }
        return list;
    }
}
