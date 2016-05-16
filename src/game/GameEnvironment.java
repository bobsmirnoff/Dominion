package game;

import cards.Card;
import cards.CardFactory;
import gnu.trove.map.TObjectIntMap;
import gnu.trove.map.hash.TObjectIntHashMap;

import java.util.*;

/**
 * Created by bobsmirnov on 09.04.16.
 */

public class GameEnvironment {
  private final Supply supply;
  private final List<Card> trash;
  private int buys;
  private int actions;
  private int coins;
  private List<Card> deck;
  private Set<Card> hand;
  private List<Card> played;
  private List<Card> discard;
  private Player activePlayer;

  public void addBuys(int bonusBuys) {
    this.buys = bonusBuys;
  }

  public void addActions(int bonusActions) {
    this.actions = bonusActions;
  }

  public void addCoins(int bonusCoins) {
    this.coins = bonusCoins;
  }

  public GameEnvironment(List<Card> trash, Supply supply) throws DominionException {
    this.supply = supply;
    this.trash = trash;
    this.buys = 1;
    this.actions = 1;
    this.coins = 0;
    this.played = new ArrayList<>();
    this.discard = new ArrayList<>();
    this.hand = new HashSet<>();
    this.deck = new ArrayList<>();
    for (String cardName : supply.getStartingDeck()) deck.add(CardFactory.get(cardName, this));
    Collections.shuffle(deck);
    drawCards(5);
  }

  public void shuffle(List<Card> list) {
    Collections.shuffle(list);
  }

  public void discardCard(Card card) throws DominionException {
    if (hand.remove(card)) discard.add(card);
    else throw new DominionException("Can't discard this card - it is not in the hand.");
  }

  public void discardDeck() {
    if (deck.size() != 0) for (int i = 0; i < deck.size(); i++) discard.add(deck.remove(i));
  }

  public void trashCard(Card card) throws DominionException {
    if (hand.remove(card)) trash.add(card);
    else throw new DominionException("Can't trash this card - it is not in the hand.");
  }

  public void trashCards(List<Card> cards) {
    cards.forEach(card -> {
      try {
        trashCard(card);
      } catch (DominionException e) {
        messageStream.print(e.getMessage());
        messageStream.flush();
      }
    });
  }

  public TObjectIntMap<Card> getTrashedCards() {
    final TObjectIntMap<Card> aMap = new TObjectIntHashMap<>();
    for (final Card trashedCard : trash) aMap.adjustOrPutValue(trashedCard, 1, 1);
    return aMap;
  }

  private Card drawCard() throws DominionException {
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
      throw new DominionException("Can't draw any more cards - your deck is no more.");
    }
  }

  public List<Card> drawCards(int n) {
    final List<Card> drawn = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      try {
        drawn.add(drawCard());
      } catch (DominionException e) {
        messageStream.print(e.getMessage());
        messageStream.flush();
        break;
      }
    }
    return drawn;
  }

  public void gainCard(String cardName, GainPosition position) {
    final Card card = supply.gainCard(cardName, this);
    if (card != null) {
      switch (position) {
        case DISCARD_PILE: {
          discard.add(card);
          break;
        }
        case TOPDECK: {
          deck.add(0, card);
          break;
        }
      }
    } else {
      messageStream.print("invalid card");
      messageStream.flush();
    }
  }

  public void endTurn() {
    discard.addAll(played);
    discard.addAll(hand);
    played.clear();
    hand.clear();
    hand.addAll(drawCards(5));
  }

  public int getBuys() {
    return buys;
  }

  public int getActions() {
    return actions;
  }

  public int getCoins() {
    return coins;
  }

  public Player getActivePlayer() {
    return activePlayer;
  }
}
