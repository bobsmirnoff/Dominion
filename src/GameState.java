import cards.Card;

import java.util.*;

/**
 * Created by bobsmirnov on 21.11.15.
 */

public class GameState {
  private List<Card> trash;
  private HashMap<Card, Integer> table = new HashMap<>(19);
  private GameExtension gameExtension;
  private Queue<Player> players;

  public GameState(HashMap<Card, Integer> table, int playersCount, List<String> playersNames) {
    if (playersNames.size() < playersCount) throw new RuntimeException("Not enough players' names!");
    this.trash = new ArrayList<>();
    this.table = table;
    this.players = new ArrayDeque<>(playersCount);
    for (int i = 0; i < playersCount; i++) {
      players.add(new Player(playersNames.get(i)));
    }
  }
}
