package cards;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import cards.treasures.Silver;
import game.GameEnvironment;
import org.reflections.Reflections;

/**
 * Created by bobsmirnov on 24.04.16.
 */

public class CardFactory {
  private static Set<Class<? extends Card>> allCardClasses;

  public static void init() {
    allCardClasses = (new Reflections("cards")).getSubTypesOf(Card.class);
  }

  public static Card get(String cardName, GameEnvironment env)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    for (Class<? extends Card> cardClass : allCardClasses) {
      if (cardClass.getSimpleName().equals(cardName))
        return cardClass.getConstructor(GameEnvironment.class).newInstance(env);
    }
    return null;
  }
}
