import com.example.ryokun.gameutil.*;

public class testCardSet{
  public static void main(String[] args){
    CardSet trump = CardSet.getFullCardSet();
    trump.shuffle();
    trump.printCards();
  }
}
