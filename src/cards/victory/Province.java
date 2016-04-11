package cards.victory;

/**
 * Created by bobsmirnov on 11.04.16.
 */

public final class Province implements VictoryCard {
  @Override
  public int vp() {
    return 6;
  }

  @Override
  public int price() {
    return 8;
  }
}
