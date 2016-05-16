package cards.actions;

import game.DominionException;
import game.GameEnvironment;
import game.Player;
import game.TurnState;
import intents.IntentWrapper;
import intents.results.IntentResult;
import intents.results.YesNoResult;

import static intents.Intent.ChancellorDecision;
import static intents.IntentTarget.Active_Player;

/**
 * Created by bobsmirnov on 15.04.16.
 */

public class Chancellor extends ActionCard {
    public Chancellor(GameEnvironment env) {
        super(env);
    }

    @Override
    public IntentWrapper play() {
        env.addCoins(2);
        return new IntentWrapper(ChancellorDecision, Active_Player);
    }

    @Override
    public TurnState onIntentReceived(Player from, IntentResult result) throws DominionException {
        if (from.equals(env.getActivePlayer()) && result instanceof YesNoResult && ((Boolean) result.getResult())) {
            env.discardDeck();
        } else throw new DominionException("Invalid action!");
        return TurnState.WAITING_FOR_CARD_TO_PLAY;
    }

    @Override
    public int price() {
        return 3;
    }
}
