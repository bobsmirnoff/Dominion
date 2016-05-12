package game;

import cards.Card;
import cards.actions.ActionCard;
import intents.Intent;
import intents.IntentTarget;
import intents.IntentWrapper;
import intents.results.IntentResult;

import java.util.List;

/**
 * Created by bobsmirnov on 16.04.16.
 */

public class Turn implements Runnable {
  private TurnState state;
  private final Player player;

  public Turn(Player player) {
    this.player = player;
  }

  @Override
  public void run() {
    final GameEnvironment gameEnv = player.getGameEnv();
    state = TurnState.PLAYING;

    // play actions
    actions_loop:
    while (true) {
      switch (state) {
        case PLAYING:
          if (gameEnv.getActions() > 0) {
            sendIntent(new IntentWrapper(Intent.PlayActionCard, IntentTarget.Player));
            ActionCard card = getResult();
            sendIntent(card.play());
            state = TurnState.WAITING_FOR_RESPONSE;
          } else {
            break actions_loop;
          }
        case WAITING_FOR_RESPONSE:
          card.onIntentReceived(getResult());
      }

      // buy cards
      while (true) {
        if (gameEnv.getActions() > 0) {
          sendIntent(new IntentWrapper(Intent.PlayTreasures, IntentTarget.Player));
          List<Card> played = getResult();
//          buy cards for total value
        }
      }

    }
  }

  private void sendIntent(IntentWrapper intentWrapper) {

  }
}
