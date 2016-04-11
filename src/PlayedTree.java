//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by bobsmirnov on 09.04.16.
// */
//
//public class PlayedTree {
//  Node root = null;
//
//  public void addCard(cards.actions.ActionCard card) {
//    if (root == null) root = new Node(card, null);
//    else
//  }
//
//  public Node getFreeSlots
//
//  static class Node {
//    int actionsAvailable;
//    cards.actions.ActionCard card;
//    Node parent;
//    List<Node> children;
//    boolean locked;
//
//    public Node(cards.actions.ActionCard card, Node parent) {
//      final int bonusActions = card.bonusActions();
//      this.actionsAvailable = bonusActions;
//      this.card = card;
//      this.parent = parent;
//      if (bonusActions > 0) this.children = new ArrayList<>(bonusActions);
//      else this.locked = true;
//    }
//  }
//}
