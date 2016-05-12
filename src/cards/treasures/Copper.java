package cards.treasures;

import game.GameEnvironment;
import game.PlayersCount;

/**
 * Created by bobsmirnov on 11.04.16.
 */

public final class Copper extends TreasureCard {
  public Copper(GameEnvironment env) {
    super(env);
  }

  @Override
  public int value() {
    return 1;
  }

  @Override
  public int price() {
    return 0;
  }

  @Override
  public int getCardMaxKingdomCount(PlayersCount playerCount) {
    return 60 - playerCount.value() * 7;
  }
}
