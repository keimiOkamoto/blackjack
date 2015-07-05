package shuffles;

import java.util.Random;

public class EasyShuffle implements Shuffle {

    @Override
    public int[] shuffles(int[] cards) {
        Random random = new Random();

        for (int x = 0; x < cards.length; x++) {
            int change = x + random.nextInt(cards.length - x);
            change(cards, x, change);
        }
        return cards;
    }

    private static void change(int[] cards, int x, int change) {
        int helper = cards[x];
        cards[x] = cards[change];
        cards[change] = helper;
    }
}
