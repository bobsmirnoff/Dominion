package cards.treasures;

import game.GameEnvironment;
import game.PlayersCount;

/**
 * Created by bobsmirnov on 11.04.16.
 */

public final class Gold extends TreasureCard {
  public Gold(GameEnvironment env) {
    super(env);
  }

  @Override
  public int value() {
    return 3;
  }

  @Override
  public int price() {
    return 6;
  }

  @Override
  public int getCardMaxKingdomCount(PlayersCount playerCount) {
    return 30;
  }
}
