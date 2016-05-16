package cards.actions;

import cards.Card;
import game.DominionException;
import game.Player;
import game.TurnState;
import intents.*;
import game.GameEnvironment;
import intents.results.CardListResult;
import intents.results.IntentResult;

import java.util.List;

import static intents.Intent.*;

/**
 * Created by bobsmirnov on 11.04.16.
 */

@SuppressWarnings("unchecked")
public class Cellar extends ActionCard {
  public Cellar(GameEnvironment env) {
    super(env);
  }

  @Override
  public IntentWrapper play() {
    env.addActions(1);
    return new RepeatedIntentWrapper(Discard, IntentTarget.Active_Player, 0, Integer.MAX_VALUE);
  }

  @Override
  public TurnState onIntentReceived(Player from, IntentResult result) throws DominionException {
    if (from.equals(env.getActivePlayer()) && result instanceof CardListResult && result.getIntent() == Discard) {
      env.drawCards(((List<Card>) result.getResult()).size());
    } else throw new DominionException("Invalid action!");
    return TurnState.WAITING_FOR_CARD_TO_PLAY;
  }

  @Override
  public int price() {
    return 2;
  }
}
