package cards;

import game.GameEnvironment;
import game.PlayersCount;

/**
 * Created by bobsmirnov on 09.05.16.
 */

public class Curse extends Card {
  public Curse(GameEnvironment env) {
    super(env);
  }

  @Override
  public int price() {
    return 0;
  }

  @Override
  public int getCardMaxKingdomCount(PlayersCount playerCount) {
    switch (playerCount) {
      case TWO:
        return 10;
      case THREE:
        return 20;
      case FOUR:
        return 30;
      default:
        return -1;
    }
  }
}
