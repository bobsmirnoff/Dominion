package cards.victory;

import cards.Card;
import game.GameEnvironment;
import game.PlayersCount;

/**
 * Created by bobsmirnov on 11.04.16.
 */

public abstract class VictoryCard extends Card {
  public VictoryCard(GameEnvironment env) {
    super(env);
  }

  public abstract int vp();

  @Override
  public int getCardMaxKingdomCount(PlayersCount playerCount) {
    switch (playerCount) {
      case TWO:
        return 8;
      default:
        return 12;
    }
  }
}
