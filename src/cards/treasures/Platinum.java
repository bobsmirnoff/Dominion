package cards.treasures;

import game.GameEnvironment;

/**
 * Created by bobsmirnov on 11.04.16.
 */

public final class Platinum extends TreasureCard {
  public Platinum(GameEnvironment env) {
    super(env);
  }

  @Override
  public int value() {
    return 5;
  }

  @Override
  public int price() {
    return 10;
  }
}
