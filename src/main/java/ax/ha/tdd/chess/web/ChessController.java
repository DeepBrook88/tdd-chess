package ax.ha.tdd.chess.web;

import ax.ha.tdd.chess.engine.Game;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChessController {

    Game game = new Game();

    @GetMapping({"/", "/chess"})
    public String chess(Model model, @RequestParam(name = "move", required = false) String move) {
        if (move != null && !move.isEmpty()) {
            game.move(move);
        }
        model.addAttribute("player", new PlayerView(game.getPlayerToMove()));
        model.addAttribute("lastMoveResult", game.getLastMoveResult());
        model.addAttribute("chessboard",
                new ChessboardView(game.getBoard()));
        return "chess";
    }

    @GetMapping({"/new"})
    public String newGame() {
        game = new Game();
        return "redirect:/chess";
    }

}
