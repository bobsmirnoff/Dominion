package cards.actions;

import cards.Card;
import game.Player;
import intents.*;
import game.GameEnvironment;
import intents.results.CardListResult;
import intents.results.IntentResult;

import java.util.List;

import static intents.Intent.*;

/**
 * Created by bobsmirnov on 11.04.16.
 */

public class Cellar extends ActionCard {
  public Cellar(GameEnvironment env) {
    super(env);
  }

  @Override
  public IntentWrapper play() {
    env.addActions(1);
    return new RepeatedIntentWrapper(Discard, IntentTarget.Player, 0, Integer.MAX_VALUE);
  }

  @Override
  public void onIntentReceived(Player from, IntentResult result) {
    if (from.equals(env.getActivePlayer()) && result instanceof CardListResult && result.getIntent() == Discard) {
      env.drawCards(((List<Card>) result.getResult()).size());
    }
  }

  @Override
  public int price() {
    return 2;
  }
}
