package cards.actions;

import cards.treasures.Silver;
import game.DominionException;
import game.GainPosition;
import game.GameEnvironment;
import game.Player;
import intents.Intent;
import intents.IntentTarget;
import intents.IntentWrapper;
import intents.results.IntentResult;

/**
 * Created by bobsmirnov on 15.04.16.
 */

public class Bureaucrat extends ActionCard {
  public Bureaucrat(GameEnvironment env) {
    super(env);
  }

  @Override
  public IntentWrapper play() {
    env.gainCard(Silver.class.getSimpleName(), GainPosition.TOPDECK);
    return new IntentWrapper(Intent.ChoseVictoryCardFromHand, IntentTarget.Opponents);
  }

  @Override
  public void onIntentReceived(Player from, IntentResult result) throws DominionException {
    env.getPlayer(from).getEnv().
  }

  @Override
  public int price() {
    return 0;
  }
}
