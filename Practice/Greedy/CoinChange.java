package Greedy;
import java.util.*;
public class CoinChange {
    public static void exchange(int [] coins , int amt) {
        Arrays.sort(coins);
        int i = coins.length-1;
        while(amt>0){
            int count = amt/coins[i];
            if(count>0){
                System.out.println("Rs "+coins[i]+ " X "+ count);
                amt -= count*coins[i];
            }
            i--;
        }
        System.out.println("--------------------------------------");
    }
    public static void main(String[] args) {
        int [] coins = {1,2,5,10,20,50,100,200,500,2000};

        exchange(coins, 700);
        exchange(coins, 8978);
        exchange(coins, 24000);
        exchange(coins, 58365920);
    }
}
