package intents.results;

import cards.Card;
import intents.Intent;

/**
 * Created by bobsmirnov on 15.04.16.
 */

public class SingleCardResult implements IntentResult<Card> {
  private Card selectedCard;
  private Intent intent;

  public SingleCardResult(Card selectedCard, Intent intent) {
    this.selectedCard = selectedCard;
    this.intent = intent;
  }

  @Override
  public Intent getIntent() {
    return intent;
  }

  @Override
  public Card getResult() {
    return null;
  }
}
