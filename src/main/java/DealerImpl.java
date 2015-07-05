import cardGames.CardGame;
import constants.Constants;
import player.CardPlayer;
import shuffles.Shuffle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DealerImpl implements Dealer {

    private int[] cards;
    private int aux = Constants.DECK_SIZE;
    private CardGame game;
    private Shuffle shuffle;
    private CardPlayer winner;
    private List<CardPlayer> players;
    private Set<CardPlayer> stickingPlayers;
    private Set<CardPlayer> bustedPlayers;


    public DealerImpl(CardGame game, List<CardPlayer> players, Shuffle shuffle) {
        this.game = game;
        this.players = players;
        this.shuffle = shuffle;
        this.cards = IntStream.range(0, Constants.DECK_SIZE).toArray();
        this.stickingPlayers = new HashSet<>();
        this.bustedPlayers = new HashSet<>();
    }

    @Override
    public void shuffle() {
        this.cards = shuffle.shuffles(cards);
    }

    @Override
    public void setupGame() {
        System.out.println("Setting up the game.");
        for (CardPlayer player : players) {
            for (int x = 0; x < game.getCardsPerPlayer(); x++) {
                player.drawCard(dealCard(cards[aux - 1]));
                System.out.println("player.CardPlayer with ID " + player.getId() + " was dealt: " + dealCard(cards[aux - 1]));
                aux = aux - 1;

            }
        }
    }

    @Override
    public void playGame() {
        players.stream().forEach(player -> {

            if (isWinner(player) || last(player)) {
                winner = player;
            } else if (players.size() == (bustedPlayers.size() + stickingPlayers.size())) {
                winner = game.getBestHand(stickingPlayers);

            } else if (game.isEligible(player) && !bustedPlayers.contains(player)) {
                player.drawCard(dealCard(cards[aux]));
                System.out.println("player.CardPlayer with ID " + player.getId() + " was dealt: " + dealCard(cards[aux]));
                aux = aux - 1;
                if (isWinner(player)) {
                    winner = player;
                }
                if (game.isOut(player)) {
                    bustedPlayers.add(player);
                    System.out.println("The player with ID " + player.getId() + " who has a total of " + player.getTotalHandValue() + " is bust.");
                }
            } else if (!game.isOut(player) && !stickingPlayers.contains(player)){
                stickingPlayers.add(player);
                System.out.println("The player with ID " + player.getId() + " who has a total of " + player.getTotalHandValue() + " is sticking.");
            }
        });
    }

    @Override
    public CardPlayer getWinner() {
        return this.winner;
    }

    @Override
    public int getWinnersScore() {
        return winner.getTotalHandValue();
    }

    private boolean last(CardPlayer player) {
        return (players.size() - 1 == bustedPlayers.size()) && getLastPlayer() == player;
    }

    private boolean isWinner(CardPlayer player) {
        return game.isWinner(player);
    }

    private int dealCard(int number) {
        int actualValue = number % 13;
        if (actualValue == 11 || actualValue == 12 || actualValue == 0) return Constants.PICTURE_CARD_VALUE;
        else if (actualValue == 1) return Constants.ACE_VALUE;
        return actualValue;
    }

    private CardPlayer getLastPlayer() {
        return players.stream().filter(player -> !bustedPlayers.contains(player)).collect(Collectors.toList()).get(0);
    }
}
