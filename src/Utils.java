import cards.Card;
import cards.treasures.Copper;
import cards.victory.Estate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobsmirnov on 11.04.16.
 */

public class Utils {

  public static List<Card> getStartingDeck(GameExtension extension) {
    final List<Card> startingDeck = new ArrayList<>(10);
    switch (extension) {
      case Classic:
        for (int i = 0; i < 7; i++) startingDeck.add(new Copper());
        for (int i = 0; i < 3; i++) startingDeck.add(new Estate());
        break;
    }
    return startingDeck;
  }
}
