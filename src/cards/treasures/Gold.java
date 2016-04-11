package cards.treasures;

/**
 * Created by bobsmirnov on 11.04.16.
 */

public final class Gold implements TreasureCard {
  @Override
  public int value() {
    return 3;
  }

  @Override
  public int price() {
    return 6;
  }
}
