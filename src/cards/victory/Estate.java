package cards.victory;

/**
 * Created by bobsmirnov on 11.04.16.
 */

public final class Estate implements VictoryCard {
  @Override
  public int vp() {
    return 1;
  }

  @Override
  public int price() {
    return 2;
  }
}
