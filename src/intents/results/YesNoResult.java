package intents.results;

import intents.Intent;
import intents.IntentTarget;

/**
 * Created by bobsmirnov on 15.04.16.
 */

public class YesNoResult implements IntentResult<Boolean>{
  private boolean agreed;
  private Intent intent;

  public YesNoResult(boolean agreed, Intent intent) {
    this.agreed = agreed;
    this.intent = intent;
  }

  @Override
  public Intent getIntent() {
    return intent;
  }

  @Override
  public Boolean getResult() {
    return agreed;
  }

 @Override
 public IntentTarget getTarget() {
   return null;
 }
}
