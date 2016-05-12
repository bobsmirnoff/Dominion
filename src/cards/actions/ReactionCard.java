package cards.actions;

import game.GameEnvironment;
import intents.Intent;

/**
 * Created by bobsmirnov on 11.04.16.
 */

public abstract class ReactionCard extends ActionCard {
  public ReactionCard(GameEnvironment env) {
    super(env);
  }

  public abstract void react(Intent intent);
}
