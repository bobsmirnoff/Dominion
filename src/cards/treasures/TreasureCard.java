package cards.treasures;

import cards.Card;
import game.GameEnvironment;
import game.PlayersCount;

/**
 * Created by bobsmirnov on 21.11.15.
 */

public abstract class TreasureCard extends Card {
  public TreasureCard(GameEnvironment env) {
    super(env);
  }

  public abstract int value();

  @Override
  public int price() {
    return 0;
  }
}
