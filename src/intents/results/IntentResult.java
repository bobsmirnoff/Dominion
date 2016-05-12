package intents.results;

import intents.Intent;
import intents.IntentTarget;

/**
 * Created by bobsmirnov on 15.04.16.
 */

public interface IntentResult<T> {
  public Intent getIntent();

  public T getResult();

 public IntentTarget getTarget();
}
