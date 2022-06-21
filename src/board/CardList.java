package board;
import java.util.ArrayList;
import cards.*;

public class CardList{

  private ArrayList<Card> cList = new ArrayList<Card>();

  public CardList(){}

  public void add(Card c){
    cList.add(0, c);
  }

  public int size(){
    return cList.size();
  }

  public Card getElementAt(int i){
    return cList.get(i);
  }

  public Card removeCardAt(int i){
    Card playerCard;
    switch(i){
      case 8:
        playerCard =  cList.get(0);
        cList.remove(0);
        return playerCard;
      case 7:
        playerCard =  cList.get(1);
        cList.remove(1);
        return playerCard;
      case 6:
        playerCard =  cList.get(2);
        cList.remove(2);
        return playerCard;
      case 5:
        playerCard =  cList.get(3);
        cList.remove(3);
        return playerCard;
      case 4:
        playerCard =  cList.get(4);
        cList.remove(4);
        return playerCard;
      case 3:
        playerCard =  cList.get(5);
        cList.remove(5);
        return playerCard;
      case 2:
        playerCard =  cList.get(6);
        cList.remove(6);
        return playerCard;
      case 1:
        playerCard =  cList.get(7);
        cList.remove(7);
        return playerCard;
    }
    return null;
  }

}
