package intents;

/**
 * Created by bobsmirnov on 15.04.16.
 */

public class IntentWrapper {
  Intent intent;
  IntentTarget target;

  public IntentWrapper(Intent intent, IntentTarget target) {
    this.intent = intent;
    this.target = target;
  }

  public Intent getIntent() {
    return intent;
  }
}
