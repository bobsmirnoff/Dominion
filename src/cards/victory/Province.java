package cards.victory;

import game.GameEnvironment;

/**
 * Created by bobsmirnov on 11.04.16.
 */

public final class Province extends VictoryCard {
  public Province(GameEnvironment env) {
    super(env);
  }

  @Override
  public int vp() {
    return 6;
  }

  @Override
  public int price() {
    return 8;
  }
}
