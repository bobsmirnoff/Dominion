package cards.victory;

/**
 * Created by bobsmirnov on 11.04.16.
 */

public final class Duchy implements VictoryCard {
  @Override
  public int vp() {
    return 3;
  }

  @Override
  public int price() {
    return 5;
  }
}
