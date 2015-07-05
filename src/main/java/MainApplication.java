import cardGames.Blackjack;
import cardGames.CardGame;
import constants.Constants;
import player.CardPlayer;
import shuffles.EasyShuffle;
import shuffles.Shuffle;

import java.util.*;

public class MainApplication {

    private static GameRepository repo;

    public static void main(String[] args) {
        CardGame blackjack = new Blackjack();

        repo = GameRepository.getInstance();
        repo.register("blackjack", blackjack);

        launchApp();
    }

    public static void launchApp() {
        Scanner sc = new Scanner(System.in);

        System.out.println(Constants.WELCOME + repo.getTitles().toString().replace("[", "").replace("]", ""));
        String userInput = sc.nextLine();
        String name = userInput;

        System.out.println(Constants.ENTER_PLAYER_NUM);
        userInput = sc.next();
        String playerNum = userInput;

        Menu menu = new Menu(repo);
        CardGame game = menu.getGame(name);
        List<CardPlayer> players = menu.getPlayers(playerNum);
        Shuffle shuffle = new EasyShuffle();

        Dealer dealer = new DealerImpl(game, players, shuffle);
        dealer.shuffle();
        dealer.setupGame();

        while (dealer.getWinner() == null) {
            dealer.playGame();
        }
        System.out.println("Player with the ID " + dealer.getWinner().getId() + " wins with the winning hand: " + dealer.getWinnersScore());
    }
}
