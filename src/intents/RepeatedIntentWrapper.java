package intents;

/**
 * Created by bobsmirnov on 15.04.16.
 */

public class RepeatedIntentWrapper extends IntentWrapper {
  int minCount;
  int maxCount;

  public RepeatedIntentWrapper(Intent intent, IntentTarget target, int minCount, int maxCount) {
    super(intent, target);
    this.minCount = minCount;
    this.maxCount = maxCount;
  }
}
