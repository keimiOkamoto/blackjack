/**
 * Repository for all available games.
 */
import cardGames.CardGame;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameRepository  {
    private static GameRepository gameRepository = null;
    private Map<String, CardGame> games = null;

    private GameRepository() {
        games = new HashMap<>();
    }

    public static GameRepository getInstance() {
        if (gameRepository == null) gameRepository = new GameRepository();
        return gameRepository;
    }

    public void register(String name, CardGame game) {
        games.put(name, game);
    }

    public List<String> getTitles() {
        return games.keySet().stream().collect(Collectors.toList());
    }

    public CardGame get(String name) {
        return games.get(name);
    }
}
