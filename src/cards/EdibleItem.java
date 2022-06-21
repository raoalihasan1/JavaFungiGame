package cards;

public abstract class EdibleItem extends Card{

  protected int flavourPoints;

  public EdibleItem(CardType card, String name){
    super(card, name);
  }

  public int getFlavourPoints(){
    return flavourPoints;
  }

}
