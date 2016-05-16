package cards.actions;

import cards.Card;
import game.*;
import intents.IntentWrapper;
import intents.RangedValueIntentWrapper;
import intents.results.IntentResult;
import intents.results.SingleCardResult;

import static intents.Intent.SelectKingdomCard;
import static intents.IntentTarget.Active_Player;

/**
 * Created by bobsmirnov on 15.04.16.
 */

public class Workshop extends ActionCard {
  public Workshop(GameEnvironment env) {
    super(env);
  }

  @Override
  public IntentWrapper play() {
    return new RangedValueIntentWrapper(SelectKingdomCard, Active_Player, 0, 4);
  }

  @Override
  public TurnState onIntentReceived(Player from, IntentResult result) throws DominionException {
    if (from.equals(env.getActivePlayer())
      && result instanceof SingleCardResult && result.getIntent() == SelectKingdomCard && ((Card) result.getResult()).price() < 5)
      env.gainCard(((Card) result.getResult()).getClass().getSimpleName(), GainPosition.DISCARD_PILE);
    return TurnState.WAITING_FOR_CARD_TO_PLAY;
  }

  @Override
  public int price() {
    return 3;
  }
}
