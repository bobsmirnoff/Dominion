import cards.Card;
import cards.treasures.Copper;
import cards.victory.Estate;

import java.io.PrintStream;
import java.util.*;

/**
 * Created by bobsmirnov on 09.04.16.
 */

public class GameEnvironment {
  private List<Card> deck;
  private Set<Card> hand;
  private List<Card> played;
  private List<Card> discard;
  private PrintStream messageStream;

  public GameEnvironment(PrintStream stream, GameExtension extension) {
    this.messageStream = stream;
    this.played = new ArrayList<>();
    this.discard = new ArrayList<>();
    this.hand = new HashSet<>();
    this.deck = Utils.getStartingDeck(extension);
    drawCards(5);
  }

  public void shuffle(List<Card> list) {
    Collections.shuffle(list);
  }

  public Card drawCard() throws RuntimeException {
    if (deck.size() > 0) {
      final Card card = deck.remove(0);
      hand.add(card);
      return card;
    } else if (discard.size() > 0) {
      deck.addAll(discard);
      discard.clear();
      shuffle(deck);
      final Card card = deck.remove(0);
      hand.add(card);
      return card;
    } else {
      throw new RuntimeException("Can't draw any more cards - your deck is no more.");
    }
  }

  public List<Card> drawCards(int n) {
    final List<Card> drawn = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      try {
        drawn.add(drawCard());
      } catch (RuntimeException e) {
        messageStream.print(e.getMessage());
        break;
      }
    }
    return drawn;
  }

  public void endTurn() {
    discard.addAll(played);
    discard.addAll(hand);
    played.clear();
    hand.clear();
    hand.addAll(drawCards(5));
  }

}
