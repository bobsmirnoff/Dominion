package cards.victory;

import game.GameEnvironment;
import game.PlayersCount;

/**
 * Created by bobsmirnov on 11.04.16.
 */

public final class Duchy extends VictoryCard {
  public Duchy(GameEnvironment env) {
    super(env);
  }

  @Override
  public int vp() {
    return 3;
  }

  @Override
  public int price() {
    return 5;
  }
}
