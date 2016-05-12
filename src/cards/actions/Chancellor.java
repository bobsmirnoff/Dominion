package cards.actions;

import game.GameEnvironment;
import game.Player;
import intents.results.IntentResult;
import intents.IntentWrapper;
import intents.results.YesNoResult;

import static intents.Intent.*;
import static intents.IntentTarget.*;

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
    return new IntentWrapper(ChancellorDecision, Player);
  }

  @Override
  public void onIntentReceived(Player from, IntentResult result) {
    if (from.equals(env.getActivePlayer()) && result instanceof YesNoResult && ((Boolean) result.getResult())) {
      env.discardDeck();
    }
  }

  @Override
  public int price() {
    return 3;
  }
}
