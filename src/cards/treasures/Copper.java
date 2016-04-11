package cards.treasures;

/**
 * Created by bobsmirnov on 11.04.16.
 */

public final class Copper implements TreasureCard {
  @Override
  public int value() {
    return 1;
  }

  @Override
  public int price() {
    return 0;
  }
}
