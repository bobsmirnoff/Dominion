package intents.results;

import cards.Card;
import intents.Intent;
import intents.IntentTarget;

/**
 * Created by bobsmirnov on 15.04.16.
 */

public class SingleCardResult<C extends Card> implements IntentResult<Card> {
    private C selectedCard;
    private Intent intent;
    private IntentTarget target;

    public SingleCardResult(C selectedCard, IntentTarget target, Intent intent) {
        this.selectedCard = selectedCard;
        this.intent = intent;
        this.target = target;
    }

    @Override
    public Intent getIntent() {
        return intent;
    }

    @Override
    public Card getResult() {
        return selectedCard;
    }

    @Override
    public IntentTarget getTarget() {
        return target;
    }
}
