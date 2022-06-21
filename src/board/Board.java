package board;
import java.util.*;
import cards.*;

public class Board{

  private static CardPile forestCardsPile;
  private static CardList forest;
  private static ArrayList<Card> decayPile;

  public static void initialisePiles(){
    forestCardsPile = new CardPile();
    forest = new CardList();
    decayPile = new ArrayList<Card>();
  }

  public static void setUpCards(){
    forestCardsPile.addCard(new BirchBolete(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new BirchBolete(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new BirchBolete(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new BirchBolete(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new BirchBolete(CardType.NIGHTMUSHROOM));
    forestCardsPile.addCard(new Chanterelle(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new Chanterelle(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new Chanterelle(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new Chanterelle(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new Chanterelle(CardType.NIGHTMUSHROOM));
    forestCardsPile.addCard(new HenOfWoods(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new HenOfWoods(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new HenOfWoods(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new HenOfWoods(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new HenOfWoods(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new HenOfWoods(CardType.NIGHTMUSHROOM));
    forestCardsPile.addCard(new Morel(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new Morel(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new Morel(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new LawyersWig(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new LawyersWig(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new LawyersWig(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new LawyersWig(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new LawyersWig(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new LawyersWig(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new LawyersWig(CardType.NIGHTMUSHROOM));
    forestCardsPile.addCard(new HoneyFungus(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new HoneyFungus(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new HoneyFungus(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new HoneyFungus(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new HoneyFungus(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new HoneyFungus(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new HoneyFungus(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new HoneyFungus(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new HoneyFungus(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new HoneyFungus(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new HoneyFungus(CardType.NIGHTMUSHROOM));
    forestCardsPile.addCard(new Porcini(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new Porcini(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new Porcini(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new Porcini(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new Porcini(CardType.NIGHTMUSHROOM));
    forestCardsPile.addCard(new Shiitake(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new Shiitake(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new Shiitake(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new Shiitake(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new Shiitake(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new Shiitake(CardType.NIGHTMUSHROOM));
    forestCardsPile.addCard(new TreeEar(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new TreeEar(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new TreeEar(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new TreeEar(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new TreeEar(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new TreeEar(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new TreeEar(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new TreeEar(CardType.DAYMUSHROOM));
    forestCardsPile.addCard(new TreeEar(CardType.NIGHTMUSHROOM));
    forestCardsPile.addCard(new Butter());
    forestCardsPile.addCard(new Butter());
    forestCardsPile.addCard(new Butter());
    forestCardsPile.addCard(new Cider());
    forestCardsPile.addCard(new Cider());
    forestCardsPile.addCard(new Cider());
    forestCardsPile.addCard(new Basket());
    forestCardsPile.addCard(new Basket());
    forestCardsPile.addCard(new Basket());
    forestCardsPile.addCard(new Basket());
    forestCardsPile.addCard(new Basket());
    forestCardsPile.addCard(new Pan());
    forestCardsPile.addCard(new Pan());
    forestCardsPile.addCard(new Pan());
    forestCardsPile.addCard(new Pan());
    forestCardsPile.addCard(new Pan());
    forestCardsPile.addCard(new Pan());
    forestCardsPile.addCard(new Pan());
    forestCardsPile.addCard(new Pan());
    forestCardsPile.addCard(new Pan());
    forestCardsPile.addCard(new Pan());
    forestCardsPile.addCard(new Pan());
  }

  public static CardPile getForestCardsPile(){
    return forestCardsPile;
  }

  public static CardList getForest(){
    return forest;
  }

  public static ArrayList<Card> getDecayPile(){
    return decayPile;
  }

  public static void updateDecayPile(){
    if(getDecayPile().size() == 4){
      for(int i = 0; i < 4; i++){
        Board.getDecayPile().remove(0);
      }
    }
    Board.getDecayPile().add(getForest().removeCardAt(1));
  }

}
