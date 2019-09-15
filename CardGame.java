import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class CardGame{
    //买牌
    private static final String[] COLORS =  {
            "♠️","♥️","♦️","♣️"
    };
    private static List<Card> buyDeck(){
        List<Card> deck = new ArrayList<>(52);
        //i代表花色，j代表数值
        for (int i = 0; i < 4; i++) {
            String color = COLORS[i];
            for (int j = 1; j < 13; j++) {
                int value = j;

                Card card = new Card(value,color);
                deck.add(card);
            }
        }
        return deck;
    }


    //洗牌
    private static void shuffle(List<Card> deck){
        //random类：生成随机数的
        Random random = new Random(20190910);
        for (int i = deck.size() - 1; i > 0 ; i--) {
            int r = random.nextInt(i);
            swap(deck,i,r);
        }
    }

    //List的swap方法
    private static void swap(List<Card> deck,int i,int j){
        Card t = deck.get(i);
        deck.set(i, deck.get(j));
        deck.set(j, t);
    }

    public static void main(String[] args) {
        //*
        List<Card> deck = buyDeck();
        System.out.println(deck);
        shuffle(deck);
        System.out.println(deck);
        //每个玩家的首牌（嵌套的用法）
        List<List<Card>> hands = new ArrayList<>();
        //发牌
        send(hands, deck, 3, 5);
        System.out.println(hands.get(0));
        System.out.println(hands.get(1));
        System.out.println(hands.get(2));
        System.out.println(deck);
        play(hands);
    }

    private static void play(List<List<Card>> hands) {
        Card card = new Card(1,"♠️");
        for (int i = 0; i < hands.size(); i++) {
            if (hands.get(i).contains(card)) {
                System.out.println("%d 输了");
                return;
            }
            /*
            for (int j = 0; j < hands.get(i).size(); j++) {
                //错误的
                Card handCard = hands.get(i).get(j);
                if (card.equals(handCard)){
                    System.out.println("%d 输了");
                    return;
                }
            }
            */
        }
    }

    //发牌
    private static void send(List<List<Card>> hands, List<Card> deck, int numPerson, int numCard) {
        //调用get之前一定要保证元素是存在的
        //先给hands里面插入一个元素，防止其为空，发生下标越界
        for (int k = 0; k < numPerson; k++) {
            hands.add(new ArrayList<>());
        }
        for (int i = 0; i < numCard; i++) {
            for (int j = 0; j < numPerson; j++) {
                //抓牌
                Card card = deck.remove(0);
                hands.get(j).add(card);
            }

        }
    }
}