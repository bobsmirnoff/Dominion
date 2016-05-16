package intents.results;

import intents.IntentTarget;

/**
 * Created by bobsmirnov on 14.05.2016.
 */
public class ResultWrapper {
        IntentResult intent;
        IntentTarget target;

        public ResultWrapper(IntentResult intent, IntentTarget target) {
            this.intent = intent;
            this.target = target;
        }
}
