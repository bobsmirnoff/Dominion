package game;

import cards.Card;

import java.util.List;

/**
 * Created by bobsmirnov on 21.11.15.
 */

public enum TurnState {
  WAITING_FOR_CARD_TO_PLAY,
  WAITING_FOR_CHOICE,
  PLAYING_CARD,
  MID_ACTION;
}
