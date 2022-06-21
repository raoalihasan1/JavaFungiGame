package cards;

public abstract class Mushroom extends EdibleItem{

  protected int sticksPerMushroom;

  public Mushroom(CardType card, String name){
    super(card, name);
  }

  public int getSticksPerMushroom(){
    return sticksPerMushroom;
  }

}
