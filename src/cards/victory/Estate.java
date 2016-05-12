package cards.victory;

import game.GameEnvironment;

/**
 * Created by bobsmirnov on 11.04.16.
 */

public final class Estate extends VictoryCard {
  public Estate(GameEnvironment env) {
    super(env);
  }

  @Override
  public int vp() {
    return 1;
  }

  @Override
  public int price() {
    return 2;
  }
}
