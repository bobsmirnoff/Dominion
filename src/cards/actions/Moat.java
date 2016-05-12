package cards.actions;

import game.GameEnvironment;
import game.Player;
import intents.Intent;
import intents.results.IntentResult;
import intents.IntentTarget;
import intents.IntentWrapper;

/**
 * Created by bobsmirnov on 15.04.16.
 */

public class Moat extends ReactionCard {
  public Moat(GameEnvironment env) {
    super(env);
  }

  @Override
  public void react(Intent intent) {
    TODO react
  }

  @Override
  public IntentWrapper play() {
    env.drawCards(2);
    return new IntentWrapper(Intent.Notify, IntentTarget.All);
  }

  @Override
  public void onIntentReceived(Player from, IntentResult result) {
  }

  @Override
  public int price() {
    return 2;
  }
}
