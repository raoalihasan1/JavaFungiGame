package board;
import java.util.ArrayList;
import cards.*;

public class Display implements Displayable{

  private ArrayList<Card> displayList = new ArrayList<Card>();

  public void add(Card c){
    displayList.add(c);
  }

  public int size(){
    return displayList.size();
  }

  public Card getElementAt(int i){
    return displayList.get(i);
  }

  public Card removeElement(int i){
    Card displayToBeRemoved = getElementAt(i);
    displayList.remove(i);
    return displayToBeRemoved;
  }

}
