package board;
import java.util.*;
import cards.*;

public class CardPile{

  private Stack<Card> cPile = new Stack<Card>();

  public CardPile(){}

  public void addCard(Card c){
    cPile.push(c);
  }

  public Card drawCard(){
    return cPile.pop();
  }

  public void shufflePile(){
    Collections.shuffle(cPile);
  }

  public int pileSize(){
    return cPile.size();
  }

  public boolean isEmpty(){
    return cPile.isEmpty();
  }

}
