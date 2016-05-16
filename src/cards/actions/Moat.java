package cards.actions;

import game.GameEnvironment;
import game.Player;
import game.TurnState;
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
//    TODO react
  }

  @Override
  public IntentWrapper play() {
    env.drawCards(2);
    return new IntentWrapper(Intent.Null, IntentTarget.All);
  }

  @Override
  public TurnState onIntentReceived(Player from, IntentResult result) {
    // TODO
    return TurnState.WAITING_FOR_CARD_TO_PLAY;
  }

  @Override
  public int price() {
    return 2;
  }
}
