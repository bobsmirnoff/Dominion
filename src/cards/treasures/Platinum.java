package cards.treasures;

/**
 * Created by bobsmirnov on 11.04.16.
 */

public final class Platinum implements TreasureCard {
  @Override
  public int value() {
    return 5;
  }

  @Override
  public int price() {
    return 10;
  }
}
