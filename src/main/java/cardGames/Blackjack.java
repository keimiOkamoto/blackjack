package cardGames;

import constants.Constants;
import player.CardPlayer;

import java.util.Comparator;
import java.util.Set;

public class Blackjack implements CardGame {

    @Override
    public boolean isWinner(CardPlayer player) {
        return player.getTotalHandValue() == Constants.UPPER_BOUND;
    }

    @Override
    public boolean isOut(CardPlayer player) {
        return player.getTotalHandValue() > Constants.UPPER_BOUND;
    }

    @Override
    public CardPlayer getBestHand(Set<CardPlayer> players) {
       return players.stream().max(Comparator.comparing(CardPlayer::getTotalHandValue)).get();
    }

    @Override
    public boolean isEligible(CardPlayer player) {
        return  player.getTotalHandValue() < Constants.LOWER_BOUND || !isOut(player);
    }

    @Override
    public int getCardsPerPlayer() {
        return Constants.CARDS_PER_PLAYER;
    }
}
