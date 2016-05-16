package game;

import cards.Card;
import cards.actions.ActionCard;
import cards.treasures.TreasureCard;
import intents.Intent;
import intents.IntentTarget;
import intents.IntentWrapper;
import intents.RangedValueIntentWrapper;
import intents.results.CardListResult;
import intents.results.IntentResult;
import intents.results.SingleCardResult;

import java.util.List;

import static intents.Intent.Null;
import static intents.Intent.SelectKingdomCard;
import static intents.IntentTarget.Active_Player;

/**
 * Created by bobsmirnov on 16.04.16.
 */

public class Turn implements Runnable {
    private TurnState state;
    private final Player player;

    public Turn(Player player) {
        this.player = player;
    }

    @Override
    public void run() {
        final GameEnvironment gameEnv = player.getGameEnv();
        state = TurnState.MID_ACTION;

        // play actions
        actions_loop:
        while (true) {
            ActionCard currentCard = null;
            switch (state) {
                case MID_ACTION:
                    if (gameEnv.getActions() > 0) {
                        sendIntent(new IntentWrapper(Intent.PlayActionCard, IntentTarget.Active_Player));
                        state = TurnState.WAITING_FOR_CARD_TO_PLAY;
                    } else {
                        break actions_loop;
                    }
                    break;
                case WAITING_FOR_CARD_TO_PLAY:
                    currentCard = getResult();
                    final IntentWrapper chosenCardIntentWrapper = currentCard.play();
                    sendIntent(chosenCardIntentWrapper);
                    if (!chosenCardIntentWrapper.getIntent().equals(Null)) state = TurnState.WAITING_FOR_CHOICE;
                    else state = TurnState.MID_ACTION;
                    break;
                case WAITING_FOR_CHOICE:
                    IntentResult intentResult = getResult();
                    state = currentCard.onIntentReceived(intentResult);
                    break;
            }
        }

        // buy cards
        sendIntent(new IntentWrapper(Intent.PlayTreasures, IntentTarget.Active_Player));
        List<TreasureCard> playedTreasures;
        while (true) {
            playedTreasures = ((CardListResult<TreasureCard>) getResult()).getResult();
            break;
        }

//        buy cards for total value
        int budget = 0;
        for (TreasureCard treasure : playedTreasures) budget += treasure.value();
        final int buys = gameEnv.getBuys();
        sendIntent(new RangedValueIntentWrapper(SelectKingdomCard, Active_Player, 0, budget));
        while (buys > 0) {
            SingleCardResult<Card> result = (SingleCardResult<Card>) getResult();
            final Card boughtCard = result.getResult();
            budget -= boughtCard.price();
            sendIntent(new RangedValueIntentWrapper(Intent.SelectKingdomCard, Active_Player, 0, budget));
        }
    }

    private void sendIntent(IntentWrapper intentWrapper) {

    }

    public IntentResult getResult() {
        return result;
    }
}
