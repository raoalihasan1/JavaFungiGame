package board;
import cards.*;
import java.util.*;

public class Player{

  private Hand h = new Hand();
  private Display d = new Display();
  private int score;
  private int handlimit = 8;
  private int sticks;

  public Player(){
    getDisplay().add(new Pan());
  }

  public int getScore(){
    return score;
  }

  public int getHandLimit(){
    return handlimit;
  }

  public int getStickNumber(){
    return sticks;
  }

  public void addSticks(int numOfSticks){
    sticks = sticks + numOfSticks;
    for(int i = 0; i < numOfSticks; i++){
      getDisplay().add(new Stick());
    }
  }

  public void removeSticks(int numOfSticks){
    sticks = sticks - numOfSticks;
    while(numOfSticks != 0){
      for(int i = 0; i < getDisplay().size(); i++){
          if(getDisplay().getElementAt(i).getType().equals(CardType.STICK)){
            getDisplay().removeElement(i);
            numOfSticks--;
            break;
          }
      }
    }
  }

  public Hand getHand(){
    return h;
  }

  public Display getDisplay(){
    return d;
  }

  public void addCardtoHand(Card c){
    if(c.getType().equals(CardType.BASKET)){
      this.handlimit += 2;
      addCardtoDisplay(c);
    } else {
      getHand().add(c);
    }
  }

  public void addCardtoDisplay(Card c){
    d.add(c);
  }

  public boolean takeCardFromTheForest(int i){

    if(i < 1 || i > 8){
      return false;
    }

    if(getHand().size() < getHandLimit()){
      if(i == 1 || i == 2){
        if(Board.getForest().getElementAt(i).getType().equals(CardType.BASKET)){
          addCardtoDisplay(Board.getForest().removeCardAt(i));
          handlimit += 2;
        } else {
          addCardtoHand(Board.getForest().removeCardAt(i));
        }
      } else {
        int y = i-2;
        if(getStickNumber() >= (i-2)){
          if(Board.getForest().getElementAt(i).getType().equals(CardType.BASKET)){
            addCardtoDisplay(Board.getForest().removeCardAt(i));
            handlimit += 2;
          } else {
            addCardtoHand(Board.getForest().removeCardAt(i));
          }
          removeSticks(i-2);
        } else {
          return false;
        }
      }
      return true;
    } else {
      return false;
    }
  }

  public boolean takeFromDecay(){

    int tempHandLimit = getHandLimit();
    int numOfBaskets = 0;

    for(int i = 0; i < Board.getDecayPile().size(); i++){
      if(Board.getDecayPile().get(i).getType().equals(CardType.BASKET)){
        tempHandLimit += 2;
        numOfBaskets++;
      }
    }

    if((getHand().size() + (Board.getDecayPile().size() - numOfBaskets)) <= tempHandLimit){
      for(int i = 0; i < Board.getDecayPile().size(); i++){
        if(Board.getDecayPile().get(i).getType().equals(CardType.BASKET)){
          addCardtoDisplay(Board.getDecayPile().get(i));
          this.handlimit += 2;
        } else {
          addCardtoHand(Board.getDecayPile().get(i));
        }
      }
      int decayPileSize = Board.getDecayPile().size();
      for(int i = 0; i < decayPileSize; i++){
        Board.getDecayPile().remove(0);
      }
      return true;
    }
    return false;
  }

  public boolean cookMushrooms(ArrayList<Card> c){

    boolean panInDisplay = false;
    boolean panInList = false;
    int mushroomCount = 0;
    int ciderCount = 0;
    int butterCount = 0;
    String mushroomName = "";


    for(int i = 0; i < c.size(); i++){
      if(c.get(i).getType().equals(CardType.PAN)){
        panInList = true;
        break;
      }
    }

    if(!panInList){
      for(int i = 0; i < getDisplay().size(); i++){
        if(getDisplay().getElementAt(i).getType().equals(CardType.PAN)){
          panInDisplay = true;
          break;
        }
      }
    }

    if(!panInList && !panInDisplay){
      return false;
    }

    for(int i = 0; i < c.size(); i++){
      if(c.get(i).getType().equals(CardType.DAYMUSHROOM) || c.get(i).getType().equals(CardType.NIGHTMUSHROOM)){
        mushroomName = c.get(i).getName();
        break;
      }
    }

    for(int i = 0; i < c.size(); i++){
      if(c.get(i).getType().equals(CardType.NIGHTMUSHROOM) && (c.get(i).getName().equals(mushroomName))){
        mushroomCount = mushroomCount + 2;
      } else if(c.get(i).getType().equals(CardType.DAYMUSHROOM) && (c.get(i).getName().equals(mushroomName))){
        mushroomCount++;
      } else if(c.get(i).getType().equals(CardType.CIDER)){
        ciderCount++;
      } else if(c.get(i).getType().equals(CardType.BUTTER)){
        butterCount++;
      } else if(c.get(i).getType().equals(CardType.PAN)){
        continue;
      } else {
        return false;
      }
    }

    if(mushroomCount < 3){
      return false;
    }

    if(butterCount != 0 && ciderCount != 0){
      if(mushroomCount < 9){
        return false;
      } else {
        this.score += 8;
      }
    } else if(butterCount == 0 && ciderCount != 0){
      if(mushroomCount < 5){
        return false;
      } else {
        this.score += Math.floor(mushroomCount/5)*5;
      }
    } else if(butterCount != 0 && ciderCount == 0){
      if(mushroomCount < 4){
        return false;
      } else {
        this.score += Math.floor(mushroomCount/4)*3;
      }
    }

    for(int i = 0; i < c.size(); i++){
      if(c.get(i).getType().equals(CardType.NIGHTMUSHROOM)){
        switch(c.get(i).getName()){
          case "birchbolete":
            this.score += (new BirchBolete(CardType.NIGHTMUSHROOM)).getFlavourPoints()*2;
            break;
          case "chanterelle":
            this.score += (new Chanterelle(CardType.NIGHTMUSHROOM)).getFlavourPoints()*2;
            break;
          case "henofwoods":
            this.score += (new HenOfWoods(CardType.NIGHTMUSHROOM)).getFlavourPoints()*2;
            break;
          case "morel":
            this.score += (new Morel(CardType.NIGHTMUSHROOM)).getFlavourPoints()*2;
            break;
          case "lawyerswig":
            this.score += (new LawyersWig(CardType.NIGHTMUSHROOM)).getFlavourPoints()*2;
            break;
          case "honeyfungus":
            this.score += (new HoneyFungus(CardType.NIGHTMUSHROOM)).getFlavourPoints()*2;
            break;
          case "porcini":
            this.score += (new Porcini(CardType.NIGHTMUSHROOM)).getFlavourPoints()*2;
            break;
          case "shiitake":
            this.score += (new Shiitake(CardType.NIGHTMUSHROOM)).getFlavourPoints()*2;
            break;
          case "treeear":
            this.score += (new TreeEar(CardType.NIGHTMUSHROOM)).getFlavourPoints()*2;
            break;
        }
      } else if(c.get(i).getType().equals(CardType.DAYMUSHROOM)){
        switch(c.get(i).getName()){
          case "birchbolete":
            this.score += (new BirchBolete(CardType.DAYMUSHROOM)).getFlavourPoints();
            break;
          case "chanterelle":
            this.score += (new Chanterelle(CardType.DAYMUSHROOM)).getFlavourPoints();
            break;
          case "henofwoods":
            this.score += (new HenOfWoods(CardType.DAYMUSHROOM)).getFlavourPoints();
            break;
          case "morel":
            this.score += (new Morel(CardType.DAYMUSHROOM)).getFlavourPoints();
            break;
          case "lawyerswig":
            this.score += (new LawyersWig(CardType.DAYMUSHROOM)).getFlavourPoints();
            break;
          case "honeyfungus":
            this.score += (new HoneyFungus(CardType.DAYMUSHROOM)).getFlavourPoints();
            break;
          case "porcini":
            this.score += (new Porcini(CardType.DAYMUSHROOM)).getFlavourPoints();
            break;
          case "shiitake":
            this.score += (new Shiitake(CardType.DAYMUSHROOM)).getFlavourPoints();
            break;
          case "treeear":
            this.score += (new TreeEar(CardType.DAYMUSHROOM)).getFlavourPoints();
            break;
        }
      }
    }

    if(panInList){
      for(int i = 0; i < getHand().size(); i++){
        if(getHand().getElementAt(i).getType().equals(CardType.PAN)){
          getHand().removeElement(i);
          break;
        }
      }
    } else {
      for(int i = 0; i < getDisplay().size(); i++){
        if(getDisplay().getElementAt(i).getType().equals(CardType.PAN)){
          getDisplay().removeElement(i);
          break;
        }
      }
    }

    for(int i = 0; i < getHand().size(); i++){
      for(int j = 0; j < c.size(); j++){
        if(getHand().getElementAt(i).getType().equals(CardType.BUTTER) && c.get(j).getType().equals(CardType.BUTTER)){
          if(butterCount != 0){
            getHand().removeElement(i);
            butterCount--;
            break;
          }
        } else if(getHand().getElementAt(i).getType().equals(CardType.CIDER) && c.get(j).getType().equals(CardType.CIDER)){
          if(ciderCount != 0){
            getHand().removeElement(i);
            ciderCount--;
            break;
          }
        } else if(getHand().getElementAt(i).getName().equals(c.get(j).getName()) && getHand().getElementAt(i).getType().equals(c.get(j).getType())){
          if(mushroomCount != 0){
            if(getHand().getElementAt(i).getType().equals(CardType.NIGHTMUSHROOM)){
              mushroomCount -= 2;
              getHand().removeElement(i);
            } else if(getHand().getElementAt(i).getType().equals(CardType.DAYMUSHROOM)){
              mushroomCount--;
              getHand().removeElement(i);
            }
            break;
          }
        }
      }
    }
    return true;
  }

  public boolean sellMushrooms(String s, int i){

    int mushroomCountOfType = 0;
    boolean mushroomExists = false;
    s = s.replaceAll(" ","");
    s.toLowerCase();
    int soldSoFar = 0;

    if(i < 2){
      return false;
    }

    for(int x = 0; x < getHand().size(); x++){
      if(getHand().getElementAt(x).getName().equals(s)){
        mushroomExists = true;
        if(getHand().getElementAt(x).getType().equals(CardType.NIGHTMUSHROOM)){
          mushroomCountOfType += 2;
        } else if(getHand().getElementAt(x).getType().equals(CardType.DAYMUSHROOM)){
          mushroomCountOfType++;
        }
      }
    }

    if(!mushroomExists || mushroomCountOfType < i){
      return false;
    } else {
      while(soldSoFar != i){
        for(int x = 0; x < getHand().size(); x++){
          if(soldSoFar == i){
            break;
          } else {
            if(getHand().getElementAt(x).getType().equals(CardType.NIGHTMUSHROOM) && getHand().getElementAt(x).getName().equals(s)){
              soldSoFar += 2;
              switch(getHand().getElementAt(x).getName()){
                case "birchbolete":
                  addSticks(new BirchBolete(CardType.NIGHTMUSHROOM).getSticksPerMushroom()*2);
                  break;
                case "chanterelle":
                  addSticks((new Chanterelle(CardType.NIGHTMUSHROOM)).getSticksPerMushroom()*2);
                  break;
                case "henofwoods":
                  addSticks((new HenOfWoods(CardType.NIGHTMUSHROOM)).getSticksPerMushroom()*2);
                  break;
                case "morel":
                  addSticks((new Morel(CardType.NIGHTMUSHROOM)).getSticksPerMushroom()*2);
                  break;
                case "lawyerswig":
                  addSticks((new LawyersWig(CardType.NIGHTMUSHROOM)).getSticksPerMushroom()*2);
                  break;
                case "honeyfungus":
                  addSticks((new HoneyFungus(CardType.NIGHTMUSHROOM)).getSticksPerMushroom()*2);
                  break;
                case "porcini":
                  addSticks((new Porcini(CardType.NIGHTMUSHROOM)).getSticksPerMushroom()*2);
                  break;
                case "shiitake":
                  addSticks((new Shiitake(CardType.NIGHTMUSHROOM)).getSticksPerMushroom()*2);
                  break;
                case "treeear":
                  addSticks((new TreeEar(CardType.NIGHTMUSHROOM)).getSticksPerMushroom()*2);
                  break;
              }
              getHand().removeElement(x);
            } else if(getHand().getElementAt(x).getType().equals(CardType.DAYMUSHROOM) && getHand().getElementAt(x).getName().equals(s)){
              soldSoFar++;
              switch(getHand().getElementAt(x).getName()){
                case "birchbolete":
                  addSticks((new BirchBolete(CardType.DAYMUSHROOM)).getSticksPerMushroom());
                  break;
                case "chanterelle":
                  addSticks((new Chanterelle(CardType.DAYMUSHROOM)).getSticksPerMushroom());
                  break;
                case "henofwoods":
                  addSticks((new HenOfWoods(CardType.DAYMUSHROOM)).getSticksPerMushroom());
                  break;
                case "morel":
                  addSticks((new Morel(CardType.DAYMUSHROOM)).getSticksPerMushroom());
                  break;
                case "lawyerswig":
                  addSticks((new LawyersWig(CardType.DAYMUSHROOM)).getSticksPerMushroom());
                  break;
                case "honeyfungus":
                  addSticks((new HoneyFungus(CardType.DAYMUSHROOM)).getSticksPerMushroom());
                  break;
                case "porcini":
                  addSticks((new Porcini(CardType.DAYMUSHROOM)).getSticksPerMushroom());
                  break;
                case "shiitake":
                  addSticks((new Shiitake(CardType.DAYMUSHROOM)).getSticksPerMushroom());
                  break;
                case "treeear":
                  addSticks((new TreeEar(CardType.DAYMUSHROOM)).getSticksPerMushroom());
                  break;
              }
              getHand().removeElement(x);
            }
          }
        }
      }
    }

    return true;
  }

  public boolean putPanDown(){
    for(int i = 0; i < getHand().size(); i++){
      if(getHand().getElementAt(i).getType().equals(CardType.PAN)){
        addCardtoDisplay(h.removeElement(i));
        return true;
      }
    }
    return false;
  }

}
