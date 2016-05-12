package game;

import cards.Card;
import cards.CardFactory;
import cards.Curse;
import cards.treasures.Copper;
import cards.treasures.Gold;
import cards.treasures.Silver;
import cards.victory.Estate;
import gnu.trove.map.TObjectIntMap;
import gnu.trove.map.hash.TObjectIntHashMap;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobsmirnov on 15.04.16.
 */

public class Supply {
  private Extension extension;
  private TObjectIntMap<String> table;

  public Supply(List<Card> cards, PlayersCount playerCount) {
    this.table = new TObjectIntHashMap<>(10);
    table.put(Curse.class.getSimpleName(), new Curse(null).getCardMaxKingdomCount(playerCount));
    table.put(Copper.class.getSimpleName(), new Copper(null).getCardMaxKingdomCount(playerCount));
    table.put(Silver.class.getSimpleName(), new Silver(null).getCardMaxKingdomCount(playerCount));
    table.put(Gold.class.getSimpleName(), new Gold(null).getCardMaxKingdomCount(playerCount));

    //TODO manage extensions via extension
    for (int i = 0; i < 10; i++) {
      final Card card = cards.get(i);
      table.put(card.getClass().getSimpleName(), card.getCardMaxKingdomCount(playerCount));
    }
  }

  public Card gainCard(String cardName, GameEnvironment env) {
    try {
      if (table.get(cardName) > 0) {
        final Card card = CardFactory.get(cardName, env);
        return card != null ? card : null;
      }
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
      e.printStackTrace();
    }
    return null;
  }

  public List<String> getStartingDeck() {
    final List<String> startingDeck = new ArrayList<>(10);
    if (extension != null) {
      switch (extension) {
        case Classic:
          for (int i = 0; i < 7; i++) startingDeck.add(Copper.class.getSimpleName());
          for (int i = 0; i < 3; i++) startingDeck.add(Estate.class.getSimpleName());
          break;
      }
    }
    return startingDeck;
  }

  public TObjectIntMap<String> getTableCards() {
    return table;
  }
}
