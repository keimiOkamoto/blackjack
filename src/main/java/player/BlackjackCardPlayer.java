package player;

import java.util.ArrayList;
import java.util.List;

public class BlackjackCardPlayer implements CardPlayer {

    private int id;
    private List<Integer> hand;

    public BlackjackCardPlayer(int id) {
        this.id = id;
        hand = new ArrayList<>();
    }

    @Override
    public void drawCard(int cardValue) {
        hand.add(cardValue);
    }

    @Override
    public int getTotalHandValue() {
        int acc = 0;
        for (int num : hand) acc = acc + num;
        return acc;
    }

    @Override
    public int getId() {
        return id;
    }
}
