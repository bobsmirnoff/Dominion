package cards.treasures;

/**
 * Created by bobsmirnov on 11.04.16.
 */

public final class Silver implements TreasureCard {
  @Override
  public int value() {
    return 2;
  }

  @Override
  public int price() {
    return 3;
  }
}
