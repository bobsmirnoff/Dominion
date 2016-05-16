package cards.actions;

import cards.Card;
import game.DominionException;
import game.Player;
import game.TurnState;
import intents.results.IntentResult;
import intents.IntentWrapper;
import game.GameEnvironment;

/**
 * Created by bobsmirnov on 11.04.16.
 */

public abstract class ActionCard extends Card {

  public ActionCard(GameEnvironment env) {
    super(env);
  }

  public abstract IntentWrapper play();

  public abstract TurnState onIntentReceived(Player fromPlayer, IntentResult result) throws DominionException;
}
