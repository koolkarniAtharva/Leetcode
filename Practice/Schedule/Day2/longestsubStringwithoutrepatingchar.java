package Schedule.Day2;

import java.util.*;

public class longestsubStringwithoutrepatingchar {
    public static int find(String str) {
        Set<Character>set = new HashSet<>();
        int left = 0;
        int max = 0;
        for(int right = 0 ; right < str.length();right++){
            while(set.contains(str.charAt(right))){
                set.remove(str.charAt(left));
                left++;
            }
            set.add(str.charAt(right));
            max = Math.max(right-left+1, max);
        }
        return max;
    }
    public static void main(String[] args) {
        String str = "pwwkewxpw";
        System.out.println(find(str));
    }
}
