package cards.actions;

import game.DominionException;
import game.GameEnvironment;
import game.Player;
import game.TurnState;
import intents.IntentWrapper;
import intents.results.IntentResult;

import static intents.Intent.Null;
import static intents.IntentTarget.*;

/**
 * Created by bobsmirnov on 15.04.16.
 */

public class Village extends ActionCard {
  public Village(GameEnvironment env) {
    super(env);
  }

  @Override
  public IntentWrapper play() {
    env.addActions(2);
    env.drawCards(1);
    return new IntentWrapper(Null, All);
  }

  @Override
  public TurnState onIntentReceived(Player from, IntentResult result) throws DominionException {
    return TurnState.WAITING_FOR_CARD_TO_PLAY;
  }

  @Override
  public int price() {
    return 3;
  }
}
