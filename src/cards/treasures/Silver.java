package cards.treasures;

import game.GameEnvironment;
import game.PlayersCount;

/**
 * Created by bobsmirnov on 11.04.16.
 */

public final class Silver extends TreasureCard {
  public Silver(GameEnvironment env) {
    super(env);
  }

  @Override
  public int value() {
    return 2;
  }

  @Override
  public int price() {
    return 3;
  }

  @Override
  public int getCardMaxKingdomCount(PlayersCount playerCount) {
    return 40;
  }
}
