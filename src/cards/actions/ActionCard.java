package cards.actions;

import cards.Card;

/**
 * Created by bobsmirnov on 11.04.16.
 */

public interface ActionCard extends Card {
  public int bonusActions();

  public int bonusCards();

  public int bonusBuys();

  public int bonusCoins();
}
