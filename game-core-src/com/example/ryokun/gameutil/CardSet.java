package com.example.ryokun.gameutil;

import java.util.*;

/*
control List
  indexが指定できるもの
  - get(idx)
  - insert(idx)
  - remove(idx)
  ( - is)
  末尾に対して処理するもの
  - retrieve()
  - retrieve(idx)
  - push()
  - pop()
  その他のコントロール
  - shuffle()
  - sort(comparator)
  - isEmpty();
  - getCount();
*/

public class CardSet {
  private List<Card> list;

  public CardSet(){
    list = new ArrayList<Card>();
  }

  public Card get(int idx){
    if( idx >= 0 && idx < list.size() ){
      return list.get(idx);
    }
    return null;
  }

  public void insert(int idx, Card card){
    if( idx >= 0 && idx <= list.size() ){
      list.add(idx, card);
    }
  }

  public Card remove(int idx){
    if( idx >= 0 && idx < list.size() ){
      return list.remove(idx);
    }
    return null;
  }

  public Card retrieve(){
    return retrieve(0);
  }

  public Card retrieve(int sc){
    int idx = list.size() - sc - 1;
    if( idx >= 0 ){
      return list.get(idx);
    }
    return null;
  }

  public void push(Card card){
    list.add(card);
  }

  public void add(Card card){
    push(card);
  }

  public Card pop(){
    if( list.size() > 0 ){
      return list.remove(list.size() - 1);
    }
    return null;
  }

  public boolean isEmpty(){
    return list.size() == 0;
  }

  public int getCount(){
    return list.size();
  }

  void swapCard(int i1, int i2){
    Card tmp = list.get(i1);
    list.set(i1, list.get(i2));
    list.set(i2, tmp);
  }

  public void shuffle(){
    for(int i=0; i<list.size() / 2; i++){
      int i1 = (int)(Math.random() * list.size());
      int i2 = (int)(Math.random() * list.size());
      swapCard(i1, i2);
    }
  }

  public void sort(Comparator<Card> comparator){
    list.sort(comparator);
  }

  public void flipDeck(){
    for(int i=0; i<list.size() / 2; i++){
      int j = list.size() - i - 1;
      list.get(i).flip();
      list.get(j).flip();
      swapCard(i, j);
    }
  }

  public String toString(){
    String count = String.valueOf(getCount());
    String top = retrieve() != null ? retrieve().toString() : "null";
    return "CardSet@(count=" + count + ",top=" + top + ")";
  }

  public static void getFullCardSet(){
    CardSet set = new CardSet();
    for(int s=0; s<4; s++){
      for(int n=1; n<=13; n++){
        set.add(new Card(s, n, false));
      }
    }
    set.add(new Card(Card.JOKER, 0, false));
    set.add(new Card(Card.JOKER, 0, false));
  }
}
