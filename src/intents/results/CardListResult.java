package intents.results;

import cards.Card;
import intents.Intent;
import intents.IntentTarget;

import java.util.List;

/**
 * Created by bobsmirnov on 15.04.16.
 */

public class CardListResult implements IntentResult<List<Card>> {
  private List<Card> cardList;
  private Intent intent;
  private IntentTarget target;

  public CardListResult(IntentTarget target, List<Card> cardList, Intent intent) {
    this.cardList = cardList;
    this.intent = intent;
    this.target = target;
  }

  @Override
  public Intent getIntent() {
    return intent;
  }

  @Override
  public List<Card> getResult() {
    return cardList;
  }

 @Override
 public IntentTarget getTarget() {
   return target;
 }
}
