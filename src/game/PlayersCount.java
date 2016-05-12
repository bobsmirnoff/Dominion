package game;

/**
 * Created by bobsmirnov on 09.05.16.
 */

public enum PlayersCount {
  TWO,
  THREE,
  FOUR;

  public int value() {
    switch (this) {
      case TWO:
        return 2;
      case THREE:
        return 3;
      case FOUR:
        return 4;
      default:
        return -1;
    }
  }
}
