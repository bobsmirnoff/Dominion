package intents;

/**
 * Created by bobsmirnov on 15.04.16.
 */

public class RangedValueIntentWrapper extends IntentWrapper {
  int minPrice;
  int maxPrice;

  public RangedValueIntentWrapper(Intent intent, IntentTarget target, int minPrice, int maxPrice) {
    super(intent, target);
    this.minPrice = minPrice;
    this.maxPrice = maxPrice;
  }
}
