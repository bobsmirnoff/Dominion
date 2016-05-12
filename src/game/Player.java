package game;

import cards.Card;
import intents.Intent;
import intents.results.IntentResult;

import java.util.List;

/**
 * Created by bobsmirnov on 21.11.15.
 */

public class Player {
  private String name;

  public GameEnvironment getGameEnv() {
    return env;
  }

  private GameEnvironment env;

  public Player(String name, List<Card> trash, Supply supply) {
    this.env = new GameEnvironment(trash, supply);
    this.name = name;
  }

  public void processTurn() {
    sendIntent(Intent.PlayActionCard);
  }

  private void sendIntent(Intent playActionCard) {

  }

  private void onIntentReceived(IntentResult result) {

  }

  public void startTurn() {
    new Turn(this).run();
  }
}
