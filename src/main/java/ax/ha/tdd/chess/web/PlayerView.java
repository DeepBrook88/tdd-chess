package ax.ha.tdd.chess.web;

import ax.ha.tdd.chess.engine.Player;

public class PlayerView {

    private final Player player;

    public PlayerView(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        if (player == Player.WHITE) {
            return "whites";
        } else {
            return "black";
        }
    }
}
