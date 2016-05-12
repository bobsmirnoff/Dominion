package cards;

import game.GameEnvironment;
import game.PlayersCount;

/**
 * Created by bobsmirnov on 21.11.15.
 */

public abstract class Card {
  protected final GameEnvironment env;

  public Card(GameEnvironment env) {
    this.env = env;
  }

  public abstract int price();

  public int getCardMaxKingdomCount(PlayersCount playerCount) {
    return 10;
  }
}
