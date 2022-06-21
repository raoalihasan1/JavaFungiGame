package board;
import java.util.ArrayList;
import cards.*;

public class Hand implements Displayable{

  private ArrayList<Card> handList = new ArrayList<Card>();

  public void add(Card c){
    handList.add(c);
  }

  public int size(){
    return handList.size();
  }

  public Card getElementAt(int i){
    return handList.get(i);
  }

  public Card removeElement(int i){
    Card cardToBeRemoved = getElementAt(i);
    handList.remove(i);
    return cardToBeRemoved;
  }

}
