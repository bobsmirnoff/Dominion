package game;

import cards.Card;
import cards.CardFactory;
import gnu.trove.map.TObjectIntMap;

import java.io.PrintWriter;
import java.util.*;

/**
 * Created by bobsmirnov on 21.11.15.
 */

public class Game {
  private List<Card> trash;
  private TObjectIntMap<String> table;
  private boolean gameFinished;
  private PrintWriter messageStream;
  private Player activePlayer;
  private Extension gameExtension;
  private Queue<Player> players;

  public Game(Supply supply, PlayersCount playersCount, List<String> playersNames) throws DominionException {
    gameFinished = false;
    CardFactory.init();
    Collections.shuffle(playersNames);
    checkPlayersCount(playersCount.value(), playersNames);
    trash = new ArrayList<>();
    this.table = supply.getTableCards();
    this.players = new ArrayDeque<>(playersCount.value());
    for (int i = 0; i < playersCount.value(); i++) players.add(new Player(playersNames.get(i), trash, supply));
    activePlayer = players.peek();
  }

  private void checkPlayersCount(int playersCount, List<String> playersNames) throws DominionException {
    if (playersNames.size() < playersCount) throw new DominionException("Not enough players' names!");
    if (playersCount < 2) throw new DominionException("Forever alone ahaha!");
    else if (playersCount > 4) throw new DominionException("Too many players!");
  }

  public void runGame() {
    while (!gameFinished) {
      activePlayer.startTurn();

    }
  }
}
