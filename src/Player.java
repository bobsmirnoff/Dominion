import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobsmirnov on 21.11.15.
 */

public class Player {
  private GameEnvironment gameEnv;
  private String name;

  public Player(String name) {
    this.name = name;
    gameEnv = new GameEnvironment(System.err, GameExtension.Classic);
  }

}
