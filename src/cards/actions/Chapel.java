package cards.actions;

import cards.Card;
import game.DominionException;
import game.GameEnvironment;
import game.Player;
import intents.*;
import intents.results.CardListResult;
import intents.results.IntentResult;

import java.util.List;

import static intents.Intent.Discard;
import static intents.Intent.Trash;

/**
 * Created by bobsmirnov on 11.04.16.
 */

public class Chapel extends ActionCard {
  public Chapel(GameEnvironment env) {
    super(env);
  }

  @Override
  public IntentWrapper play() {
    return new RepeatedIntentWrapper(Trash, IntentTarget.Player, 0, 4);
  }

  @Override
  public void onIntentReceived(Player from, IntentResult result) throws DominionException {
    if (from.equals(env.getActivePlayer()) && result instanceof CardListResult && result.getIntent() == Discard) {
      env.trashCards(((List<Card>) result.getResult()));
    } else throw new DominionException("Invalid action!");
  }

  @Override
  public int price() {
    return 2;
  }
}
