package cards;

public abstract class Card{

  protected CardType type;
  protected String cardName;

  public Card(CardType card, String name){
    type = card;
    cardName = name;
  }

  public CardType getType(){
    return type;
  }

  public String getName(){
    return cardName;
  }

}
