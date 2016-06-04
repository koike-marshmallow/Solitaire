package com.example.ryokun.gameutil;

public class Card {
  public static final int SPADE = 0;
  public static final int HART = 1;
  public static final int DIAMOND = 2;
  public static final int CLUB = 3;
  public static final int JOKER = 4;
  public static final int JOKER2 = 5;

  static final int JOKER_VALUE = 4 * 13;
  static final int JOKER2_VALUE = 4 * 13 + 1;

  private int cardValue;
  private boolean isOpen;

  public Card(){
    cardValue = 0;
    isOpen = true;
  }

  public Card(int suit, int number){
    this();
    setCard(suit, number);
  }

  public Card(int suit, int number, boolean isOpen){
    this();
    setCard(suit, number);
    setSurface(isOpen);
  }

  public void setCard(int suit, int number){
    switch( suit ){
      case SPADE:
      case HART:
      case DIAMOND:
      case CLUB:
        if( (suit>=0&&suit<=3) && (number>0&&number<=13) ){
          cardValue = (suit*13) + (number-1);
        }
        break;
      case JOKER:
        cardValue = JOKER_VALUE;
        break;
      case JOKER2:
        cardValue = JOKER2_VALUE;
        break;
    }
  }

  public void setSurface(boolean isOpen){
    this.isOpen = isOpen;
  }

  public void flip(){
    isOpen = !isOpen;
  }

  public int getCardSuit(){
    if( isNumberCard() ){
      return cardValue / 13;
    }else if( isJoker() ){
      if( cardValue == JOKER_VALUE ){
        return JOKER;
      }else if( cardValue == JOKER2_VALUE ){
        return JOKER2;
      }
    }
    return -1;
  }

  public int getCardNumber(){
    if( isNumberCard() ){
      return cardValue % 13 + 1;
    }
    return -1;
  }

  public boolean isOpen(){
    return isOpen;
  }

  public boolean isJoker(){
    return cardValue == JOKER_VALUE ||
      cardValue == JOKER2_VALUE;
  }

  public boolean isNumberCard(){
    return cardValue >= 0 && cardValue < (4*13);
  }

  public int hashCode(){
    return cardValue;
  }

  public boolean equals(Object obj){
    if( obj instanceof Card ){
      Card c1 = (Card)obj;
      return this.cardValue == c1.cardValue;
    }
    return false;
  }

  public String toString(){
    String[] suitstrs = {"spade", "hart", "diamond", "club"};
    String value = "(" + cardValue + ")";
    if( isJoker() ){
      if( cardValue == JOKER_VALUE ){
        return "card@[JOKER]" + value;
      }else if( cardValue == JOKER2_VALUE ){
        return "card@[JOKER2]" + value;
      }
    }else if( isNumberCard() ){
      return "card@[" + suitstrs[getCardSuit()] + "-" + getCardNumber() + "]" + value;
    }
    return "card@undefined" + value;
  }
}
